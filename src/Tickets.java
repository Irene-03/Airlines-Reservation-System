import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Tickets {
    private static final Tickets instance = new Tickets();

    private Tickets() {
    }

    public static Tickets getInstance() {
        return instance;
    }
    private HashMap <Flight, User> ticket = new HashMap<>();
    private List< Ticket> tickets = new ArrayList<>();

    public ArrayList<Flight> searchUser(User user){
        List<Flight> list = new ArrayList<>();
        for (Ticket ticket1 : tickets){
            if(ticket1.getUser() == user)
                list.add(ticket1.getFlight());
        }
        return (ArrayList<Flight>) list;
    }

    public void removeUser(Flight flight ,User user) {
        for (Ticket ticket1 : tickets)
            if(ticket1.getUser() == user && ticket1.getFlight()==flight)
                tickets.remove(ticket1);
    }

    public void add(Flight flight, User user) {
        tickets.add( new Ticket(flight,user));
    }

    public void removeFlight(Flight flight) {
        for (Ticket ticket1 : tickets){
            if(ticket1.getFlight() == flight){
                ticket1.getUser().addNotify(ticket1.getFlight());
                tickets.remove(ticket1);
                }
        }
    }
}
