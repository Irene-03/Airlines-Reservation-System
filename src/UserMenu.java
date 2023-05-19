
public class UserMenu extends Menu {

    User user;
    Tickets tickets = Tickets.getInstance();

    public UserMenu(User user) {
        this.user = user;
        userMenu();
    }

    public void userMenu() {
        int input;
        printNotify();
        label:
        while (true) {
            printUserMenu();
            if ((input = input()) != 0)
                switch (MenuUser.getValue(input)) {
                    case CHANGE_PASSWORD -> changePassword();
                    case SEARCH_FLIGHT -> searchProcess();
                    case BOOKING_TICKET -> bookingProcess();
                    case TICKET_CANCELLATION -> cancellationProcess();
                    case BOOKED_TICKETS -> showBookedProcess();
                    case ADD_CHARGE -> addChargeProcess();
                    case FLIGHT_SCHEDULE -> scheduleProcess();
                    case SIGN_OUT -> {
                        break label;
                    }
                    default -> System.out.println("Incorrect input ! try again");
                }
        }
    }

    private void printNotify() {
        if (!user.getNotify().equals("")) {
            System.out.println("there is some notify for you!");
            System.out.println(user.getNotify());
        }
    }

    private void changePassword() {
        String password = inputProcess("previous password :");
        if (user.checkOldPass(password)) {
            user.setPassword(inputProcess("new password :"));
        } else {
            System.out.println("incorrect input");
        }
    }

    private void searchProcess() {
        System.out.println("Enter your selected filter , if not (press Enter 0)");
        Flight flight = makeFlight();
        System.out.println("Result : ");
        for (Flight flight1 : flights.compare(flight))
            System.out.println(flight1);
       inputProcess("Press to continue...");
    }

    private void bookingProcess() {
        scheduleProcess();
        Flight flight = flights.findFlight(inputProcess("Flight ID :"));
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

    private void cancellationProcess() {
        Flight flight = tickets.removeUser(inputProcess("Ticket ID :"));
        if (flight != null) {
            user.updateCharge(-flight.getPrice());
            flight.updateSeats(1);
        } else
            System.out.println("No ticket with this ID");


    }

    private void showBookedProcess() {
        for (Flight flight : tickets.searchUser(user))
            System.out.println(flight);
        inputProcess("Press to continue...");
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

    private void addChargeProcess() {
        //---------------------------------check big number
        System.out.printf("Your current charge :\t%10d\n", user.getCharge());
        System.out.println("How many do you want to charge :");
        int price = Integer.parseInt(scanner.nextLine());
        if (price < 0)
            System.out.println("Incorrect input");
        else {
            user.updateCharge(price);
        }
    }

}
