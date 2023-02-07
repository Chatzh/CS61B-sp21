package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T>, Iterable<T> {
    private class ListNode {
        private T item;
        private ListNode prev;
        private ListNode next;

        ListNode(T i, ListNode p, ListNode n) {
            item = i;
            prev = p;
            next = n;
        }
    }

    private ListNode head;
    private ListNode tail;
    private int size;

    /** Creates an empty linked list deque. */
    public LinkedListDeque() {
        head = new ListNode(null, null, null);
        tail = new ListNode(null, head, head);
        head.prev = head.next = tail;
        size = 0;
    }

    /** Adds item to the front of the deque. */
    @Override
    public void addFirst(T item) {
        // Storage previous first item's references
        ListNode temp = head.next;

        ListNode node = new ListNode(item, head, temp);
        head.next = node;
        temp.prev = node;
        size = size + 1;
    }

    /** Adds item to the end of the deque. */
    @Override
    public void addLast(T item) {
        // Storage previous last item's references
        ListNode temp = tail.prev;

        ListNode node = new ListNode(item, temp, tail);
        temp.next = node;
        tail.prev = node;
        size = size + 1;
    }

    /** Returns the size of the deque. */
    @Override
    public int size() {
        return size;
    }

    /** Prints all items in the deque in order. */
    @Override
    public void printDeque() {
        ListNode p = head.next;
        while (p != tail) {
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println();
    }

    /** Removes the first item in the deque and return it. */
    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }

        T item = head.next.item;
        head.next = head.next.next;
        head.next.prev = head;
        size = size - 1;
        return item;
    }

    /** Removes the last item in the deque and return it. */
    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }

        T item = tail.prev.item;
        tail.prev = tail.prev.prev;
        tail.prev.next = tail;
        size = size - 1;
        return item;
    }

    /** Returns the item with correct index in the deque. */
    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        ListNode p = head.next;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        return p.item;
    }

    /** Returns the item with correct index in the deque, recursively. */
    public T getRecursive(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return getRecursiveHelper(head.next, index);
    }

    /** If o same as this, return true.
     *  @source lectureCode-11*/
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (o.getClass() != this.getClass()) {
            return false;
        }

        ArrayDeque<T> other = (ArrayDeque<T>) o;
        if (other.size() != this.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (this.get(i) != other.get(i)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkListDequeIterator();
    }

    private class LinkListDequeIterator implements Iterator<T> {
        private int pos;

        LinkListDequeIterator() {
            pos = 0;
        }

        @Override
        public boolean hasNext() {
            return pos < size;
        }

        @Override
        public T next() {
            T returnItem = get(pos);
            pos += 1;
            return returnItem;
        }
    }

    /** Helper method of getRecursive(). */
    private T getRecursiveHelper(ListNode n, int i) {
        if (i == 0) {
            return n.item;
        }
        return getRecursiveHelper(n.next, i - 1);
    }
}
