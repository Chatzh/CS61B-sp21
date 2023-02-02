package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> buggyL = new BuggyAList<>();
        for (int i = 0; i < 3; i++) {
            L.addLast(i);
            buggyL.addLast(i);
            assertEquals(L.getLast(), buggyL.getLast());
        }
        for (int i = 0; i < 3; i++) {
            assertEquals(L.removeLast(), buggyL.removeLast());
        }
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> buggyL = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                buggyL.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                int buggySize = buggyL.size();
                System.out.println("size: " + size);
                assertEquals(size, buggySize);
            } else if (operationNumber == 2 && L.size() > 0) {
                // getLast
                int item = L.getLast();
                int buggyItem = buggyL.getLast();
                System.out.println("getLast(" + item + ")");
                assertEquals(item, buggyItem);
            } else if (operationNumber == 3 && L.size() > 0) {
                // removeLast
                int item = L.removeLast();
                int buggyItem = buggyL.removeLast();
                System.out.println("removeLast(" + item + ")");
                assertEquals(item, buggyItem);
            }
        }
    }
}
