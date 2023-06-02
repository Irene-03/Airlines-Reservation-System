
public class UserMenu extends Menu {

    User user;
    Tickets tickets = Tickets.getInstance();

    public UserMenu(User user) {
        this.user = user;
        userMenu();
    }

    public void userMenu() {
        printNotify();
        label:
        while (true) {
            printUserMenu();
            switch (UserEnum.getValue(inputNumber())) {
                case CHANGE_PASSWORD -> changePassword();
                case SEARCH_FLIGHT -> searchProcess();
                case BOOKING_TICKET -> bookingProcess();
                case TICKET_CANCELLATION -> cancellationProcess();
                case BOOKED_TICKETS -> showBookedProcess();
                case ADD_CHARGE -> addChargeProcess();
                case FLIGHT_SCHEDULE -> flights.flightSchedule();
                case SIGN_OUT -> {
                    break label;
                }
                default -> System.out.println("Incorrect input ! try again");
            }
            inputProcess("Enter to continue...");
        }
    }

    private void printNotify() {
        if (!user.getNotify().equals("")) {
            System.out.println("there is some notify for you!");
            System.out.println(user.getNotify());
            inputProcess("Enter to continue...");
            user.setNotify("");
        }
    }

    /**
     * change user password with check old password ,
     * get new password and update pass word
     */
    private void changePassword() {
        String password = inputProcess("previous password :");
        if (user.checkOldPass(password)) {
            user.setPassword(inputProcess("new password :"));
        } else System.out.println("incorrect input");

    }

    /**
     * get filter with call make flight than compare that .
     * see compare function and makeFlight function
     */
    private void searchProcess() {
        System.out.println("Enter your selected filter , if not (press Enter 0)");
        Flight flight = makeFlight();
        System.out.println("Result : ");
        System.out.println("|FlightId     |Origin    |Destination  |Date      |Time |Price    |Seats |");
        System.out.println("..........................................................................");
        for (Flight flight1 : flights.compare(flight))
           printFlight(flight1.toString());
    }

    /**
     * show flight schedule and get flight id .
     * if existed then make ticket , reduce the user charge , reduce the seat parameter of flight object,
     *  if not existed or charge not enough ,print error message
     */
    private void bookingProcess() {
        flights.flightSchedule();
        Flight flight = flights.findValue(inputProcess("Flight ID :"));
        if (flight != null && flight.getPrice() <= user.getCharge()) {
            tickets.add(flight, user);
            flight.updateSeats(-1);
            user.updateCharge(-(flight.getPrice()));
            System.out.println("Done...");
        } else if (flight == null) {
            System.out.println("There is no flight like with this flight ID !!");
        } else {
            System.out.println("Insufficient inventory !!");
        }

    }

    /**
     * get ticket ID and if existed remove that ,if not print error message
     */
    private void cancellationProcess() {
        Ticket ticket = tickets.findValue(inputProcess("Ticket ID :"));
        if (ticket != null) {
            user.updateCharge(ticket.getFlight().getPrice());
            ticket.getFlight().updateSeats(1);
            tickets.remove(ticket.getTicketId());
        } else System.out.println("No ticket with this ID");
    }

    /**
     * show ticket with this user
     */
    private void showBookedProcess() {
        System.out.println("|ticketId           |FlightId     |Origin    |Destination  |Date      |Time |Price    |Seats |");
        System.out.println("..............................................................................................");
        for (Ticket ticket : tickets.searcher(user))
            System.out.println(ticket);
    }

    public void printUserMenu() {
        System.out.print("""
                ::::::::::::::::::::::::::::::::::::::::
                         PASSENGER MENU OPTIONS
                ::::::::::::::::::::::::::::::::::::::::
                 ......................................
                    <1> Change password
                    <2> Search flight tickets
                    <3> Booking ticket
                    <4> Ticket cancellation
                    <5> Booked tickets
                    <6> Add charge
                    <7> Flight schedules
                    <0> Sign out
                """);
    }

    /**
     * get number and add to user charge parameter
     */
    private void addChargeProcess() {
        System.out.printf("Your current charge :\t%10d\n", user.getCharge());
        System.out.println("How many do you want to charge :");
        int price = inputNumber();
        if (price < 0) System.out.println("Incorrect input");
        else {
            user.updateCharge(price);
            System.out.println("Done...");
        }
    }

}
