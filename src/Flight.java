import java.util.Objects;
import java.util.Random;

public class Flight {
    Random rand = new Random();
    private String flightId;
    private String origin;
    private String destination;
    private String date;
    private String time;
    private int price;
    private int seats;
    public void makeFlightId() {
        flightId = "wh_" + origin.charAt(0) + destination.charAt(0) + "_" + rand.nextInt(10) + rand.nextInt(10);
    }
    public int getPrice() {
        return price;
    }

    public void updateSeats(int num) {
        seats += num;
    }

    public Flight(String origin, String destination, String date, String time, int price, int seats) {
        this.origin = origin;
        this.destination = destination;
        this.date = date;
        this.time = time;
        this.price = price;
        this.seats = seats;
    }

    public String getFlightId() {
        return flightId;
    }

    public void update(Flight flightNew) {
        if (!flightNew.origin.isEmpty()) origin = flightNew.origin;
        if (!flightNew.destination.isEmpty()) destination = flightNew.destination;
        if (!flightNew.date.isEmpty()) date = flightNew.date;
        if (!flightNew.time.isEmpty()) time = flightNew.time;
        if (flightNew.price != 0) price = flightNew.price;
        if (flightNew.seats != 0) seats = flightNew.seats;
    }

    public boolean compare(Flight flight) {
        return (origin.equals("0") || origin.equals(flight.origin)) &&
                (destination.equals("0") || destination.equals(flight.destination)) &&
                (date.equals("0") || date.equals(flight.date)) &&
                (time.equals("0") || time.equals(flight.time)) &&
                (price == 0 || price == flight.price) && (seats == 0 || seats == flight.seats);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o || o== null) return true;
        if (o instanceof String id)
            if ( flightId.equals(id)) return true;
        if ( getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return flightId.equals(flight.flightId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightId, origin, destination, date, time, price, seats);
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightId='" + flightId + '\'' +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", price=" + price +
                ", seats=" + seats +
                '}';
    }
}
