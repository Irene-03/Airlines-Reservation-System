
public class AdminMenu extends Menu {
    public AdminMenu() {
        adminMenu();
    }

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

    public void adminMenu() {
        label:
        while (true) {
            printAdminMenu();
                switch (MenuAdmin.getValue(inputNumber())) {
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

    private String chooseFlight() {
        flights.flightSchedule();
        return (inputProcess("Enter Flight ID : "));
    }

    private void removeProcess() {
        if (!flights.removeFlight(chooseFlight()))
            System.out.println("there is no flight");

    }

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

    private void addProcess() {
        Flight flight = makeFlight();
        flight.makeFlightId();
        if (!flights.add(flight.getFlightId(),flight))
            System.out.println("there is a flight like this already!!");
    }


}
