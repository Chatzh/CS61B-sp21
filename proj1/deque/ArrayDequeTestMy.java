package deque;

import static org.junit.Assert.*;
import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

public class ArrayDequeTestMy {
    @Test
    public void randomizedTest() {
        LinkedListDeque<Integer> llDeque = new LinkedListDeque<>();
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();

        int N = 50000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 6);
            if (operationNumber == 0) {
                // addFirst
                int randVal = StdRandom.uniform(0, 100);
                arrayDeque.addFirst(randVal);
                llDeque.addFirst(randVal);
                assertEquals(arrayDeque.get(0), llDeque.get(0));
            } else if (operationNumber == 1) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                arrayDeque.addLast(randVal);
                llDeque.addLast(randVal);
                assertEquals(arrayDeque.get(arrayDeque.size() - 1),
                        llDeque.get(llDeque.size() - 1));
            } else if (operationNumber == 2) {
                // size
                int size = arrayDeque.size();
                int testSize = llDeque.size();
                assertEquals(size, testSize);
            } else if (operationNumber == 3 && arrayDeque.size() > 0) {
                // removeFirst
                int item = arrayDeque.removeFirst();
                int testItem = llDeque.removeFirst();
                assertEquals(item, testItem);
            } else if (operationNumber == 4 && arrayDeque.size() > 0) {
                // removeLast
                int item = arrayDeque.removeLast();
                int testItem = llDeque.removeLast();
                assertEquals(item, testItem);
            } else if (operationNumber == 5 && arrayDeque.size() > 0) {
                // equals
                assertTrue(llDeque.equals(arrayDeque));
            }
        }
    }
}
