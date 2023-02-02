package deque;

public class ArrayDeque<T> {
    private T[] items;
    private int size;

    /** Creates an empty list. */
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
    }

    /** Adds item to the front of the deque. */
    public void addFirst(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        T[] temp = (T[]) new Object[items.length];
        System.arraycopy(items, 0, temp, 1, size);
        temp[0] = item;
        items = temp;
        size = size + 1;
    }

    /** Adds item to the end of the deque. */
    public void addLast(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[size] = item;
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
        for (int i = 0; i < items.length; i++) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }

    /** Removes the first item in the deque and return it. */
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }

        T x = items[0];
        T[] temp = (T[]) new Object[items.length];
        System.arraycopy(items, 1, temp, 0, size - 1);
        items = temp;
        size = size - 1;
        return x;
    }

    /** Removes the last item in the deque and return it. */
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }

        if ((size < items.length / 4) && (size > 8)) {
            resize(items.length / 4);
        }

        T x = items[size];
        items[size - 1] = null;
        size = size - 1;
        return x;
    }

    /** Returns the item with correct index in the deque. */
    public T get(int index) {
        return items[index];
    }

    /** Resizes the underlying array to the target capacity. */
    private void resize(int capacity) {
        T[] temp = (T[]) new Object[capacity];
        System.arraycopy(items, 0, temp, 0, size);
        items = temp;
    }
}
