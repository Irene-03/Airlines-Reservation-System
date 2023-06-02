
public class AdminMenu extends Menu {
    public AdminMenu() {
        adminMenu();
    }

    /**
     * just print admin menu
     */
    public void printAdminMenu() {
        System.out.print("""
                ::::::::::::::::::::::::::::::::::::::::
                           Admin MENU OPTIONS
                ::::::::::::::::::::::::::::::::::::::::
                 ......................................
                    <1> Add
                    <2> Update
                    <3> Remove
                    <4> Flight schedules
                    <0> Sign out
                """);
    }

    /**
     * print admin menu and get input means that what admin want to do , and  handel that whit switch and Enum , than call function
     */
    public void adminMenu() {
        label:
        while (true) {
            printAdminMenu();
                switch (AdminEnum.getValue(inputNumber())) {
                    case ADD_FLIGHT -> addProcess();
                    case UPDATE_FLIGHT -> updateProcess();
                    case REMOVE_FLIGHT -> removeProcess();
                    case FLIGHT_SCHEDULE -> flights.flightSchedule();
                    case SIGN_OUT -> {
                        break label;
                    }
                    default -> System.out.println("Incorrect input ! try again");
                }
            inputProcess("Enter to continue...");
        }
    }

    /**
     * print flight schedule and get flight id from admin
     * @return flight ID as string type
     */
    private String chooseFlight() {
        flights.flightSchedule();
        return (inputProcess("Enter Flight ID : "));
    }

    /**
     * call choose flight function and then call remove function in flights class
     */
    private void removeProcess() {
        if (!flights.removeFlight(chooseFlight()))
            System.out.println("there is no flight");

    }

    /**
     * find flight that want to update with call chooseFlight and findValue function
     * if exist that flight than get filter whit call makeFlight function
     * and update that
     */
    private void updateProcess() {
        Flight flight = flights.findValue(chooseFlight());
        if (flight == null)
            System.out.println("there is no flight");
        else {
            System.out.println("choose every information that you want filter ,(if dont ,press Enter, for price and seats (-1)");
            Flight flightNew = makeFlight();
            flight.update(flightNew);
            tickets.removeFlight(flight.getFlightId());
        }
    }

    /**
     * get information of new flight whit call makeFlight function and make flight ID than add to database
     * if there are some flight ID like that , so don't add flight and print a message
     */
    private void addProcess() {
        Flight flight = makeFlight();
        flight.makeFlightId();
        if (!flights.add(flight.getFlightId(),flight))
            System.out.println("there is a flight like this already!!");
    }


}
