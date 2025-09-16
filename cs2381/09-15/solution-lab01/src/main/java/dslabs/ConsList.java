package dslabs;

import java.util.List;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

public class ConsList<E> implements List<E> {
    ConsL<E> data = new ConsEmpty<E>();

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        // this is O(n)
        //return data.size() == 0;
       
        // this is O(1)
        return data.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public boolean add(E e) {
        data = data.append(e);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public E get(int index) {
        return data.get(index);
    }

    @Override
    public E set(int index, E element) {
        E old_val = get(index);
        this.data = data.set(index, element);
        return old_val;
    }

    @Override
    public void add(int index, E element) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public E remove(int index) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public ListIterator<E> listIterator() {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public String toString() {
        return data.toString();
    }
}

interface ConsL<E> {
    int size();
    boolean isEmpty();
    ConsL<E> append(E item);
    E first();
    ConsL<E> rest();
    E get(int index);
    ConsL<E> set(int index, E elem);
}

record ConsCell<E>(E first, ConsL<E> rest) implements ConsL<E> {
    public int size() {
        return 1 + rest.size();
    }

    public boolean isEmpty() {
        return false;
    }
    
    public ConsL<E> append(E item) {
        var cell = new ConsCell<E>(
                this.first(), 
                this.rest().append(item));
        return cell;
    }
    
    public E get(int index) {
        if (index == 0) {
            return first();
        }
        else {
            return rest.get(index - 1);
        }
    }

    public ConsL<E> set(int index, E elem) {
        if (index == 0) {
            return new ConsCell<E>(elem, rest);
        }
        else {
            var new_rest = rest.set(index - 1, elem);
            return new ConsCell<E>(first, new_rest);
        }
    }
}

record ConsEmpty<E>() implements ConsL<E> {
    public int size() {
        return 0;
    }
    
    public boolean isEmpty() {
        return true;
    }

    public E first() {
        throw new RuntimeException("empty list");
    }
    
    public ConsL<E> rest() {
        throw new RuntimeException("empty list");
    }

    public ConsL<E> append(E item) {
        var cell = new ConsCell<E>(item, this);
        return cell;
    }
    
    public E get(int index) {
        throw new RuntimeException("empty list");
    }

    public ConsL<E> set(int index, E elem) {
        throw new RuntimeException("empty list");
    }
}




