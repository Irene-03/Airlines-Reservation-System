import java.util.Random;

public class Ticket {
    Random random = new Random();
    private Flight flight;
    private User user;
    private String ticketId;


    public Ticket(Flight flight, User user) {
        this.flight = flight;
        this.user = user;
        ticketId = "wh-"+flight.getFlightId()+"-"+user.getUsername()+"-"+random.nextInt(10)+random.nextInt(10)+random.nextInt(10);
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




}
