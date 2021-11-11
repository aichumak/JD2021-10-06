package by.it.drankevich.jd01_11;

import java.util.*;

public class SetC<E> implements Set<E> {

    private E[] elements = (E[]) new Object[]{};
    private int size=0;


    @Override
    public String toString() {
        StringJoiner sj =new StringJoiner(", ","[","]");
        for (int i = 0; i < size; i++) {
            sj.add(elements[i].toString());
        }

        return sj.toString();
    }

    @Override
    public boolean add(E e) {
        if (size == elements.length)
            elements = Arrays.copyOf(elements, (size * 3) / 2 + 1);
        for (int i = 0; i < elements.length; i++) {
            if(elements[i]==null) continue;
            if (elements[i].equals(e)) return false;
        }
                elements[size++] = e;

        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }



    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }
}