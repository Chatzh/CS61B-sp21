package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private Comparator<T> cmp;

    /** Creates an empty max array deque with parameter Comparator c. */
    public MaxArrayDeque(Comparator<T> c) {
        cmp = c;
    }

    /** Returns the maximum element in the deque as governed by the given Comparator. */
    public T max() {
        if (this == null || this.size() == 0) {
            return null;
        }

        T returnItem = get(0);
        for (int i = 0; i < this.size(); i++) {
            if (cmp.compare(get(i), returnItem) > 0) {
                returnItem = get(i);
            }
        }

        return returnItem;
    }

    /** Returns the maximum element in the deque as governed by the parameter Comparator c. */
    public T max(Comparator<T> c) {
        Comparator<T> tmp = cmp;    // Temporally storage old Comparator cmp.
        cmp = c;
        T returnItem = max();
        cmp = tmp;
        return returnItem;
    }
}
