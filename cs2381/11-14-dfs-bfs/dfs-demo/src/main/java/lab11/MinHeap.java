package lab11;

import java.util.ArrayList;
import java.util.function.BiFunction;
import java.util.Iterator;

/**
 *
 * @author Nat Tuck
 * @author Data Structures Students, Fall 2023
 */
public class MinHeap<T> implements Iterable<T> {
    ArrayList<T> data;
    BiFunction<T, T, Integer> compare;

    MinHeap(BiFunction<T, T, Integer> compare) {
        this.data = new ArrayList<T>();
        this.compare = compare;
    }

    void add(T xx) {
        this.data.add(xx);
        int ii = this.data.size() - 1;
        while (ii != 0) {
            int pidx = parent(ii);
            var aa = this.data.get(ii);
            var bb = this.data.get(pidx);
            int cmp = this.compare.apply(aa, bb);
            if (cmp < 0) {
                swap(ii, pidx);
            }
            else {
                break;
            }
            ii = pidx;
        }
    }

    void swap(int ii, int jj) {
        T temp = this.data.get(ii);
        this.data.set(ii, this.data.get(jj));
        this.data.set(jj, temp);
    }

    T peek() {
        if (this.data.size() > 0) {
            return this.data.get(0);
        }
        else {
            return null;
        }
    }

    T poll() {
        if (this.data.size() == 0) {
            return null;
        }

        T yy = this.data.get(this.data.size() - 1);
        this.data.remove(this.data.size() - 1);
        return yy;
    }

    @Override
    public Iterator<T> iterator() {
        return this.data.iterator();
    }

    private int minChild(int ii) {
        int li = leftChild(ii);
        int ri = rightChild(ii);
        if (ri >= this.data.size()) {
            return li;
        }
        T lc = this.data.get(li);
        T rc = this.data.get(ri);
        if (this.compare.apply(lc, rc) < 0) {
            return li;
        }
        else {
            return ri;
        }
    }

    private int parent(int ii) {
        return (ii - 1) / 2;
    }

    private int leftChild(int ii) {
        return 2 * ii + 1;
    }

    private int rightChild(int ii) {
        return 2 * ii + 2;
    }
}
