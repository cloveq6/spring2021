package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void Test1(){
        AListNoResizing<Integer> aListNoResizing = new AListNoResizing<>();
        BuggyAList<Integer> buggyAList = new BuggyAList<>();
        for(int i=4; i<=6; i++){
            aListNoResizing.addLast(i);
            buggyAList.addLast(i);
        }
        int n1 = aListNoResizing.removeLast();
        int n2 = buggyAList.removeLast();
        assertEquals(n1, n2);
        n1 = aListNoResizing.removeLast();
        n2 = buggyAList.removeLast();
        assertEquals(n1, n2);
        n1 = aListNoResizing.removeLast();
        n2 = buggyAList.removeLast();
        assertEquals(n1, n2);
    }

    @Test
    public void randomizedTest(){
        AListNoResizing<Integer> L = new AListNoResizing<>();

        int N = 500;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                System.out.println("size: " + size);
            } else if (operationNumber == 2){
                // last item
                if (L.size() == 0) continue;
                Integer item = L.getLast();
                System.out.println("item(" + item + ")");
            } else if (operationNumber == 3){
                if (L.size() == 0) continue;
                Integer removeLast = L.removeLast();
                System.out.println("removeItem(" + removeLast + ")");
            }
        }
    }

    @Test
    public void Test2(){
        BuggyAList<Integer> B = new BuggyAList<>();
        AListNoResizing<Integer> L = new AListNoResizing<>();

        int N = 50000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                B.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                assertEquals(L.size(), B.size());
                System.out.println("size: " + size);
            } else if (operationNumber == 2){
                // last item
                if (L.size() == 0) continue;
                Integer item = L.getLast();
                assertEquals(L.getLast(), B.getLast());
                System.out.println("item(" + item + ")");
            } else if (operationNumber == 3){
                if (L.size() == 0) continue;
                Integer removeLast = L.removeLast();
                Integer removeLast1 = B.removeLast();
                assertEquals(removeLast, removeLast1);
                System.out.println("removeItem(" + removeLast + ")");
            }
        }
    }

}
