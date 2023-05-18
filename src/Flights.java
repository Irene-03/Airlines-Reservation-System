import java.util.ArrayList;
import java.util.List;

public class Flights {
    ArrayList<Flight> flights =new ArrayList<>();
    private static final Flights instance = new Flights();
    private final Tickets tickets=Tickets.getInstance();

    private Flights() {
    }

    public static Flights getInstance() {
        return instance;
    }

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public Flight findFlight(String id) {
        for(Flight flight : flights){
            if (flight.getFlightId().equals(id))
                return flight;
        }
        return null;
    }

    public void updateFlight(Flight flightOld, Flight flightNew) {
        flightOld.update(flightNew);
        //notify or no access
    }

    public void flightSchedule() {
        flights.forEach(flight -> System.out.println(flight));
    }

    public void remove(Flight flight) {
        flights.remove(flight);
        tickets.removeFlight(flight);
    }

    public List<Flight> compare(Flight flight) {
        List<Flight> list =new ArrayList<>() ;
        for(Flight flight1 : flights){
            Flight flight2 = flight.compare(flight1);
            if(flight2!= null)
                list.add(flight2);
        }
        return list;
    }


}
