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

    public Flight() {
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
        if (!flightNew.origin.isEmpty())
            this.origin = flightNew.origin;
        if (!flightNew.destination.isEmpty())
            this.destination = flightNew.destination;
        if (!flightNew.date.isEmpty())
            this.date = flightNew.date;
        if (!flightNew.time.isEmpty())
            this.time = flightNew.time;
        if (flightNew.price != 0)
            this.price = flightNew.price;
        if (flightNew.seats != 0)
            this.seats = flightNew.seats;
    }

    public Flight compare(Flight flight) {
        if ((this.origin.equals("0") || this.origin.equals(flight.origin)) &&
                (this.destination.equals("0") || this.destination.equals(flight.destination)) &&
                (this.date.equals("0") || this.date.equals(flight.date)) &&
                (this.time.equals("0") || this.time.equals(flight.time)) &&
                (this.price == 0 || this.price == flight.price) && (this.seats == 0 || this.seats == flight.seats)) {
            return flight;
        }
        return null;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightId='" + flightId + '\'' +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", date=" + date +
                ", time=" + time +
                ", price=" + price +
                ", seats=" + seats +
                '}';
    }


}
