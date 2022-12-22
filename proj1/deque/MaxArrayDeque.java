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
        for (int i=0 ;i<size(); ++i){
            if(comparator.compare(this.get(i), res) > 0 ){
                res = this.get(i);
            }
        }
        return res;
    }

    public T max(Comparator<T> c){
        if (size() == 0) return null;
        T res = get(0);
        for (int i=0 ;i<size(); ++i){
            if(c.compare(this.get(i), res) > 0 ){
                res = this.get(i);
            }
        }
        return res;
    }
}
