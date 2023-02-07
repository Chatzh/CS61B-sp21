package deque;

public interface Deque<T> extends Iterable<T> {
    void addFirst(T item);

    void addLast(T item);

    /** Returns true iff the deque is empty. */
    default boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    int size();

    void printDeque();

    T removeFirst();

    T removeLast();

    T get(int index);
}
