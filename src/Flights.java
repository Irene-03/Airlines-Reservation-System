import java.io.IOException;
import java.io.RandomAccessFile;

public class Flights extends FileHandler{

    protected Tickets tickets;

    public Flights(Tickets tickets, RandomAccessFile raf) {
        super(raf, 20, 141);
        this.tickets=tickets;
    }

    public void flightSchedule() throws IOException {
        searcher(String.format("%130s","")).forEach(Menu::printFlight);
    }

    public boolean removeFlight(String id) throws IOException {
        if (remove(id , new Flight().toString())) return true;/*tickets.removeFlight(id);*/
        return false;
    }
}
