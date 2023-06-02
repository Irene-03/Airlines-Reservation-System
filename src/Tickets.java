import java.io.RandomAccessFile;

public class Tickets extends FileHandler{

    public Tickets(RandomAccessFile raf) {
        super(raf, 20, 61);
    }
}
