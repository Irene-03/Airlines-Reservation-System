import java.util.ArrayList;
import java.util.List;

public class Flights extends Worker<String,Flight>{
    private static final Flights instance = new Flights();
    private final Tickets tickets=Tickets.getInstance();

    private Flights() {
    }

    public static Flights getInstance() {
        return instance;
    }

    /**
     * print all flight
     */
    public void flightSchedule() {
        System.out.println("|FlightId     |Origin    |Destination  |Date      |Time |Price    |Seats |");
        System.out.println("..........................................................................");
        searcher(null).forEach(flight ->  Menu.printFlight(flight.toString()));
    }

    /**
     * remove flight with flight id if existed , then remove tickets with this flight
     * @param id
     * @return
     */
    public boolean removeFlight(String id) {
        if (remove(id))
            return tickets.removeFlight(id);
        return false;
    }

    /**
     * compare parameters of input flight with all flight in database and filter that
     * @param flight that we want to compare with all flight in database
     * @return a list include that filter after compare
     */
    public List<Flight> compare(Flight flight) {
        List<Flight> list =new ArrayList<>() ;
        searcher(null).stream().filter(flight::compare).forEach(list::add);

        return list;
    }


}
