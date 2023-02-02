package deque;

public class LinkedListDeque<T> {
    private class ListNode {
        public T item;
        public ListNode prev;
        public ListNode next;

        public ListNode(T i, ListNode p, ListNode n) {
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
    public void addFirst(T item) {
        // Storage previous first item's references
        ListNode temp = head.next;

        ListNode node = new ListNode(item, head, temp);
        head.next = node;
        temp.prev = node;
        size = size + 1;
    }

    /** Adds item to the end of the deque. */
    public void addLast(T item) {
        // Storage previous last item's references
        ListNode temp = tail.prev;

        ListNode node = new ListNode(item, temp, tail);
        temp.next = node;
        tail.prev = node;
        size = size + 1;
    }

    /** Returns true iff the deque is empty. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Returns the size of the deque. */
    public int size() {
        return size;
    }

    /** Prints all items in the deque in order. */
    public void printDeque() {
        ListNode p = head.next;
        while (p != tail) {
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println();
    }

    /** Removes the first item in the deque and return it. */
    public T removeFirst() {
        if (size == 0) {
            return null;
        }

        T item = head.next.item;
        head.next = head.next.next;
        head.next.prev = head;
        size = size - 1;
        return item;
    }

    /** Removes the last item in the deque and return it. */
    public T removeLast() {
        if (size == 0) {
            return null;
        }

        T item = tail.prev.item;
        tail.prev = tail.prev.prev;
        tail.prev.next = tail;
        size = size - 1;
        return item;
    }

    /** Returns the item with correct index in the deque. */
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

    /** Helper method of getRecursive(). */
    private T getRecursiveHelper(ListNode n, int i) {
        if (i == 0) {
            return n.item;
        }
        return getRecursiveHelper(n.next, i - 1);
    }
}
