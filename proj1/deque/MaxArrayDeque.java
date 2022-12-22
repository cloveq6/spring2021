package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T>{

    private Comparator<T> comparator;
    public MaxArrayDeque(Comparator<T> c){
        comparator = c;
    }

    public T max(){
        if (size() == 0) return null;
        T res = get(0);
        for (T item : this){
            if (comparator.compare(item, res) > 0){
                res = item;
            }
        }
        return res;
    }

    public T max(Comparator<T> c){
        if (size() == 0) return null;
        T res = get(0);
        for (T item : this){
            if (c.compare(item, res) > 0){
                res = item;
            }
        }
        return res;
    }
}
