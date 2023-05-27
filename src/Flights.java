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

    public void flightSchedule() {
        searcher(null).forEach(flight ->  Menu.printFlight(flight.toString()));
    }

    public boolean removeFlight(String id) {
        if (remove(id))
            return tickets.removeFlight(id);
        return false;
    }

    public List<Flight> compare(Flight flight) {
        List<Flight> list =new ArrayList<>() ;
        searcher(null).stream().filter(flight::compare).forEach(list::add);
//
//        for(Flight flight1 : searcher(null)){
//            if((flight2 = flight.compare(flight1)) != null)
//                list.add(flight2);
//        }
        return list;
    }


}
