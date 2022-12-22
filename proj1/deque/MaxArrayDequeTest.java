package deque;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

import java.util.Comparator;


/**
 * 大于
 */
class ComparatorExample1 implements Comparator<Integer>{
    @Override
    public int compare(Integer o1, Integer o2) {
        return o1 - o2;
    }
}


/**
 * 小于
 */
class ComparatorExample2 implements Comparator<Integer>{
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2 - o1;
    }
}

public class MaxArrayDequeTest {
    @Test
    public void testGreater(){
        Comparator<Integer> comparator = new ComparatorExample1();
        MaxArrayDeque<Integer> maxArrayDeque = new MaxArrayDeque<>(comparator);
        for (int i=0; i<20; ++i){
            int randVal = StdRandom.uniform(0, 100);
            maxArrayDeque.addLast(randVal);
        }
        maxArrayDeque.printDeque();
        System.out.println(maxArrayDeque.max());
        System.out.println(maxArrayDeque.max(new ComparatorExample2()));
    }

    @Test
    public void testlesser(){
        MaxArrayDeque<Integer> maxArrayDeque = new MaxArrayDeque<>(new ComparatorExample2());
        for (int i=0; i<20; ++i){
            int randVal = StdRandom.uniform(0, 100);
            maxArrayDeque.addLast(randVal);
        }
        maxArrayDeque.printDeque();
        System.out.println(maxArrayDeque.max());
    }

    @Test
    public void emptyTest(){
        MaxArrayDeque<Integer> maxArrayDeque = new MaxArrayDeque<>(new ComparatorExample2());
        System.out.println(maxArrayDeque.max());
    }

    //to do 其他单元测试
}
