import java.io.IOException;
import java.io.RandomAccessFile;

public class FileManagement {
    private final int SIZE = 30;
    private final byte[] buffer = new byte[30];
    protected RandomAccessFile raf;

    public String formatter(String input) {
        StringBuilder sb = new StringBuilder(input);
        while (sb.length() < SIZE)
            sb.append(" ");
        return sb.substring(0, SIZE);
    }

    public void writeInFile(String input) {
        try {
            raf.seek(raf.length());
            raf.writeUTF(input);
            raf.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //-------------------
    public void rewriteInFile(String id,String newText) throws IOException {
        for (int i = 0; i <raf.length()/SIZE ;i++ ) {
            if (readNChar(SIZE,i*SIZE).equals(id)) {
                raf.seek(i * SIZE);
                raf.writeUTF(newText);
                raf.close();
                break;
            }
        }
    }
    public String readNChar(int size , int pointer) throws IOException {
        String temp="";
        raf.seek(pointer);
        for (int i = 0; i < size; i++)
            temp += raf.readChar();
        return temp;
    }


    public String readInFile(String id) throws IOException {
        String temp="";
        for (int i = 0; i <raf.length()/SIZE ;i++ ) {
            if (readNChar(SIZE,i*SIZE).equals(id)) {
                raf.seek(i * SIZE);
                for (int i1 = 0; i1 < 210; i1++)
                   temp += raf.read();
                raf.close();
                break;
            }
        }
        return temp;
    }

}

