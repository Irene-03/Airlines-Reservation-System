import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public abstract class FileHandler<K, T > {
//-------------------------------------check fixed size and obj size in math--------------------------------------------------
    protected RandomAccessFile raf;
    public final int FIXED_SIZE=20;
    public final int OBJ_SIZE=50;

    public void add(String obj) throws IOException {
        writeObj(0,obj);
    }
    public boolean remove(String id) throws IOException {
        int pointer= findValue(id);
        for (long i = pointer; i < raf.length() / OBJ_SIZE; i++)
           return writeObj(pointer,readObj(pointer+1));
        return false;
    }
    public int findValue(String id) throws IOException {
        for (int i = 0; i < raf.length()/OBJ_SIZE ; i++)
            if (readPart(FIXED_SIZE,i*FIXED_SIZE).equals(id))
                return i*FIXED_SIZE;
        return -1;
    }
    public String readObj(long pointer) throws IOException {
        raf.seek(pointer);
        return raf.readLine();
    }
    public String readPart(int size , int pointer) throws IOException {
        String temp="";
        raf.seek(pointer);
        for (int i = 0; i < size; i++)
            temp += raf.readChar();
        return temp;
    }
    public boolean writeObj(long pointer, String obj) throws IOException {
        if (pointer == 0) pointer= raf.length();
        raf.seek(pointer);
        raf.writeUTF(obj+"\n");
        raf.close();
        return true;
    }
    public <E> List<T> searcher (E e) throws IOException {
        List<T> list = new ArrayList<>();
//        for (long i = 0; i < raf.length() / OBJ_SIZE; i++)
//            T temp = E.convert(readObj(i));
//            if(temp.equals(e)) list.add(temp);
//        }
//        data.values().stream().filter(t ->t.equals(e)).forEach(list::add);
//        return list;
    }

//    protected FileHandler(int fixed_size, int num) {
//        SIZE = fixed_size;
//    }
//
//    public String findValue(K k) throws IOException {
//        for (int i = 0; i < raf.length() / SIZE; i++)
//            if (readNChar(SIZE, i * SIZE).equals(k)){
//                return readNChar(NUM, SIZE*i);
//    }
//        return null;
//    }
//    public boolean existValue(K k) throws IOException {
//        for (int i = 0; i < raf.length()/SIZE ; i++)
//            if (readNChar(SIZE,i*SIZE).equals(k))
//                return true;
//        return false;
//    }
//
//
//
//    public boolean add (K k, String obj) throws IOException {
//        if (!existValue(k)) return false;
//        else {
//            try {
//                raf.seek(raf.length());
//                raf.writeUTF(obj);
//                raf.close();
//                return true;
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }
////---------------------------------------------------------------
//    public boolean remove (K k) throws IOException {
//        if (existValue(k)) {
//            for (int i = 0; i < raf.length()/SIZE ; i++)
//                if (readNChar(SIZE,i*SIZE).equals(k)) {
//                    for()
//                    raf.writeUTF(readNChar(NUM,i*SIZE));
//                    raf.seek(i * SIZE);
//
//                }
//            return true;
//        }else return false;
//    }
//    public <E> List<T> searcher (E e){
//        List<T> list = new ArrayList<>();
//        data.values().stream().filter(t ->t.equals(e)).forEach(list::add);
//        return list;
//    }
//
//    public String readNChar(int size , int pointer) throws IOException {
//        String temp="";
//        raf.seek(pointer);
//        for (int i = 0; i < size; i++)
//            temp += raf.readChar();
//        return temp;
//    }
//
//
}
