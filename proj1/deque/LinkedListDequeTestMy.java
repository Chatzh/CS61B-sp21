package deque;

import static org.junit.Assert.*;
import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

public class LinkedListDequeTestMy {
    @Test
    public void randomizedTest() {
        LinkedListDeque<Integer> LLDeque = new LinkedListDeque<>();
        ArrayDeque<Integer> ArrayDeque = new ArrayDeque<>();

        int N = 50000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 6);
            if (operationNumber == 0) {
                // addFirst
                int randVal = StdRandom.uniform(0, 100);
                ArrayDeque.addFirst(randVal);
                LLDeque.addFirst(randVal);
                assertEquals(ArrayDeque.get(0), LLDeque.get(0));
            } else if (operationNumber == 1) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                ArrayDeque.addLast(randVal);
                LLDeque.addLast(randVal);
                assertEquals(ArrayDeque.get(ArrayDeque.size() - 1), LLDeque.get(LLDeque.size() - 1));
            } else if (operationNumber == 2) {
                // size
                int size = ArrayDeque.size();
                int testSize = LLDeque.size();
                assertEquals(size, testSize);
            } else if (operationNumber == 3 && ArrayDeque.size() > 0) {
                // removeFirst
                int item = ArrayDeque.removeFirst();
                int testItem = LLDeque.removeFirst();
                assertEquals(item, testItem);
            } else if (operationNumber == 4 && ArrayDeque.size() > 0) {
                // removeLast
                int item = ArrayDeque.removeLast();
                int testItem = LLDeque.removeLast();
                assertEquals(item, testItem);
            } else if (operationNumber == 5 && ArrayDeque.size() > 0) {
                // equals
                assertTrue(LLDeque.equals(ArrayDeque));
            }
        }
    }
}
