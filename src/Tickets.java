
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

    public boolean removeFlight(String id) {
        for (Ticket ticket : searcher(id)) {
            ticket.getUser().addNotify (ticket.getFlight());
            ticket.getUser().updateCharge(ticket.getFlight().getPrice());
            remove(ticket.getTicketId());
        }
        return true;
    }
}
