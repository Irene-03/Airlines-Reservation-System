
public class Tickets extends Worker<String, Ticket> {
    private static final Tickets instance = new Tickets();

    private Tickets() {
    }

    public static Tickets getInstance() {
        return instance;
    }


    public void add(Flight flight, User user) {
        Ticket ticket = new Ticket(flight, user);
        add(ticket.getTicketId(), ticket);
    }

    /**
     * when a flight removed then with id , we cancel the thicket include this flight ,
     * and remove that ticket from database
     * @param id id of flight
     * @return just true show that finished
     */
    public boolean removeFlight(String id) {
        for (Ticket ticket : searcher(id)) {
            ticket.getUser().addNotify (ticket.getFlight());
            ticket.getUser().updateCharge(ticket.getFlight().getPrice());
            remove(ticket.getTicketId());
        }
        return true;
    }
}
