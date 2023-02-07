package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T>, Iterable<T> {
    private T[] items;
    private int size;

    /** Creates an empty array deque. */
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
    }

    /** Adds item to the front of the deque. */
    @Override
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
    @Override
    public void addLast(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[size] = item;
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
        for (int i = 0; i < items.length; i++) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }

    /** Removes the first item in the deque and return it. */
    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }

        if ((size < items.length / 4) && (size > 8)) {
            resize(items.length / 4);
        }

        T x = items[0];
        T[] temp = (T[]) new Object[items.length];
        System.arraycopy(items, 1, temp, 0, size - 1);
        items = temp;
        size = size - 1;
        return x;
    }

    /** Removes the last item in the deque and return it. */
    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }

        if ((size < items.length / 4) && (size > 8)) {
            resize(items.length / 4);
        }

        T x = items[size - 1];
        items[size - 1] = null;
        size = size - 1;
        return x;
    }

    /** Returns the item with correct index in the deque. */
    @Override
    public T get(int index) {
        return items[index];
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
        return new ArrayDeque.ArrayDequeIterator();
    }
    
    private class ArrayDequeIterator implements Iterator<T> {
        private int pos;

        ArrayDequeIterator() {
            pos = 0;
        }

        @Override
        public boolean hasNext() {
            return pos < size;
        }

        @Override
        public T next() {
            T returnItem = items[pos];
            pos += 1;
            return returnItem;
        }
    }

    /** Resizes the underlying array to the target capacity. */
    private void resize(int capacity) {
        T[] temp = (T[]) new Object[capacity];
        System.arraycopy(items, 0, temp, 0, size);
        items = temp;
    }
}
