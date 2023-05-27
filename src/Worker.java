import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Worker <K, T> {
    public Map <K,T> data = new HashMap<>();

    public T findValue(K k){
        if (data.containsKey(k)) return data.get(k);
        return null;
    }
    public boolean existValue(K k){
        return data.containsKey(k);
    }

    public boolean add (K k, T t) {
        if (data.containsKey(k)) return false;
        else {
             data.put(k, t);
            return true;
        }
    }

    public boolean remove (K k){
        if (data.containsKey(k)) {
            data.remove(k);
            return true;
        }else return false;
    }
    public <E> List<T> searcher (E e){
        List<T> list = new ArrayList<>();
        data.values().stream().filter(t ->t.equals(e)).forEach(list::add);
        return list;
    }


}