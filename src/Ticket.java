import java.util.Random;


public class Ticket {
    Random random = new Random();
    private Flight flight;
    private User user;
    private String ticketId;


    public Ticket(Flight flight, User user) {
        this.flight = flight;
        this.user = user;
        ticketId = "WH-"+flight.getFlightId()+"-"+user.getUsername()+"-"+random.nextInt(10)+random.nextInt(10)+random.nextInt(10);
    }

    public String getTicketId() {
        return ticketId;
    }

    public Flight getFlight() {
        return flight;
    }

    public User getUser() {
        return user;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Flight flight1)
            if(flight.equals(flight1)) return true;
        if (o instanceof  User user1)
            if(user.equals(user1)) return true;
        if (o instanceof String id)
            return ticketId.equals(id) || flight.equals(id);
        return false;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                ", ticketId='" + ticketId + '\'' +
                "flight=" + flight +
                '}';
    }
}
