
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
        int input;
        label:
        while (true) {
            printAdminMenu();
            if ((input = input()) != 0)
                switch (MenuAdmin.getValue(input)) {
                    case ADD_FLIGHT -> addProcess();
                    case UPDATE_FLIGHT -> updateProcess();
                    case REMOVE_FLIGHT -> removeProcess();
                    case FLIGHT_SCHEDULE -> scheduleProcess();
                    case SIGN_OUT -> {
                        break label;
                    }
                    default -> System.out.println("Incorrect input ! try again");
                }
        }
    }

    private Flight finderFlight(){
        flights.flightSchedule();
        inputProcess("Press to continue...");
        return flights.findFlight(inputProcess("Enter Flight ID : "));
    }
    private void removeProcess() {
        Flight flight = finderFlight();
        if (flight == null)
            System.out.println("there is no flight");
        else
            flights.remove(flight);
        //price and notify
    }

    private void updateProcess() {
        Flight flightOld = finderFlight();
        if (flightOld == null)
            System.out.println("there is no flight");
        else {
            System.out.println("choose every information that you want filter ,(if dont ,press Enter, for price and seats (0)");
            Flight flightNew = makeFlight();
            flights.updateFlight(flightOld, flightNew);
        }
    }

    private void addProcess() {
        Flight flight = makeFlight();
        if (flights.findFlight(flight.getFlightId()) == null)
            flight.makeFlightId();
        else
            System.out.println("there is a flight like this already!!");
        flights.addFlight(flight);
    }


}
