package lab08;

import java.util.Iterator;

/**
 * Implements a generic linked list.
 *
 * @param  <T>  Type of list items
 *
 * @author Nat Tuck
 */
public interface ConsList<T> extends Iterable<T> {
    /**
     * Creates a list of the given items.
     *
     * @param  <T>   ConsList item type
     * @param  args  Zero or more items
     * @return       A list of those items
     */
    @SafeVarargs
    public static <T> ConsList<T> list(T... args) {
        ConsList<T> ys = new Empty<T>();
        for (int ii = args.length - 1; ii >= 0; --ii) {
            ys = new Cell<T>(args[ii], ys);
        }
        return ys;
    }

    /**
     * Add item at start of list.
     *
     * @param  <T>   Item type
     * @param  item  Item to add
     * @param  list  List to add item to
     * @return       New list with item added
     */
    public static <T> ConsList<T> cons(T item, ConsList<T> list) {
        return new Cell<T>(item, list);
    }

    /**
     * Get the first item in the list.
     *
     * @return  The first item
     */ 
    T first();

    /**
     * Get a list of all items except the first.
     *
     * @return  The rest of the list
     */
    ConsList<T> rest();

    /**
     * Determine if the list is empty.
     *
     * @return  True for empty list, else false.
     */
    boolean isEmpty();

    /**
     * Determine the length of the list.
     *
     * @return  ConsList length
     */
    int length();

    /**
     * Create a new list with items in reverse order.
     *
     * @return   New reversed list
     */
    ConsList<T> reverse();

    default public ConsIterator<T> iterator() {
        return new ConsIterator<T>(this);
    }
}

/**
 * An empty list.
 *
 * @param  <T>   ConsList item type
 *
 * @author Nat Tuck
 */
record Empty<T>() implements ConsList<T> {
    @Override
    public T first() {
        throw new RuntimeException("empty list");
    }

    @Override
    public ConsList<T> rest() {
        throw new RuntimeException("empty list");
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public int length() {
        return 0;
    }

    @Override
    public ConsList<T> reverse() {
        return this;
    }

    @Override
    public String toString() {
        return "()";
    }
}

/**
 * A non-empty list.
 *
 * @param  <T>    Type of item in list
 * @param  first  First item in the list
 * @param  rest   The rest of the list
 *
 * @author Nat Tuck
 */
record Cell<T>(T first, ConsList<T> rest) implements ConsList<T> {
    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int length() {
        return 1 + rest.length();
    }

    @Override
    public ConsList<T> reverse() {
        ConsList<T> ys = ConsList.<T>list();
        for (ConsList<T> xs = this; !xs.isEmpty(); xs = xs.rest()) {
            ys = ConsList.cons(xs.first(), ys);
        }
        return ys;
    }

    @Override
    public String toString() {
        var tmp = rest.toString();
        return "(" + first + " " + tmp.substring(1, tmp.length() - 1) + ")";
    }
}

class ConsIterator<T> implements Iterator<T> {
    ConsList<T> xs;

    ConsIterator(ConsList<T> xs) {
        this.xs = xs;
    }

    @Override
    public boolean hasNext() {
        return !this.xs.isEmpty();
    }

    @Override
    public T next() {
        T yy = this.xs.first();
        this.xs = this.xs.rest();
        return yy;
    }
} 
