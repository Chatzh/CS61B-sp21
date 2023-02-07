package deque;

import static org.junit.Assert.*;
import java.util.ArrayList;
import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

public class LinkedListDequeTestMy {
    @Test
    public void randomizedTest() {
        LinkedListDeque<Integer> testList = new LinkedListDeque<>();
        ArrayList<Integer> javaList = new ArrayList<>();

        int N = 50000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 5);
            if (operationNumber == 0) {
                // addFirst
                int randVal = StdRandom.uniform(0, 100);
                javaList.add(0, randVal);
                testList.addFirst(randVal);
                assertEquals(javaList.get(0), testList.get(0));
            } else if (operationNumber == 1) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                javaList.add(randVal);
                testList.addLast(randVal);
                assertEquals(javaList.get(javaList.size() - 1), testList.get(testList.size() - 1));
            } else if (operationNumber == 2) {
                // size
                int size = javaList.size();
                int testSize = testList.size();
                assertEquals(size, testSize);
            } else if (operationNumber == 3 && javaList.size() > 0) {
                // removeFirst
                int item = javaList.remove(0);
                int testItem = testList.removeFirst();
                assertEquals(item, testItem);
            } else if (operationNumber == 4 && javaList.size() > 0) {
                // removeLast
                int item = javaList.remove(javaList.size() - 1);
                int testItem = testList.removeLast();
                assertEquals(item, testItem);
            }
        }
    }
}
