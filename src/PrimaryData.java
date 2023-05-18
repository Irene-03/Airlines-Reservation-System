import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class PrimaryData {

    private final ArrayList<String> city = new ArrayList<>(Arrays.asList("yazd", "kerman", "mashhad", "shiraz", "tehran", "esfahan", "ardabil", "kish", "ahvaz", "hamadan", "karaj", "semnan", "ilam", "gheshm", "amol", "tabas", "savah", "kashan"));

    private final Flights flights = Flights.getInstance();
    Random rand = new Random();

    public PrimaryData() {
    }

    /**
     * make 10 new flights as default
     */
    public void makePrimaryFlights() {
        for (int i = 0; i < 10; i++) {
            String temp =setOrigin();
            Flight flight = new Flight(temp,setDestination(temp),setDate(),setTime(),setPrice(),245);
            flight.makeFlightId();
            flights.addFlight(flight);
        }
    }

    /**
     * set random price in flight's price parameter
     */
    private int setPrice() {
        int[] price = {1500000, 1400000, 1700000, 1100000, 1350000, 1240000, 1432000, 1640000, 1030000, 1090000, 1300000};
        return (price[rand.nextInt(price.length)]);
    }

    /**
     * set random time in flight's time parameter
     */
    private String setTime() {

        return rand.nextInt(23)+":"+ rand.nextInt(59);

    }

    /**
     * set random date in flight's date parameter
     **/
    private String setDate() {

        return rand.nextInt(1401, 1410)+"-"+ rand.nextInt(1, 12)+"-"+rand.nextInt(1, 30);

    }

    /**
     * set random city in flight's origin and destination parameter
     **/
    private String setOrigin() {
        return city.get(rand.nextInt(city.size()));
    }

    private String setDestination(String origin) {
        city.remove(origin);
        String destination=  city.get(rand.nextInt(city.size()));
        city.add(origin);
        return destination;
    }
}


