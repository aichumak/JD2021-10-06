package by.it.konon.jd01_11;

import java.util.*;

public class ListB<E> implements List<E> {

    @SuppressWarnings("unchecked")
    private E[] elements = (E[]) new Object[10];

    private int size = 0;


    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        for (int i = 0; i < size; i++) {
            joiner.add(String.valueOf(elements[i]));

        }
        return joiner.toString();
    }

    @Override
    public boolean add(E e) {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 3 / 2 - 1);
        }
        elements[size++] = e;
        return true;
    }

    @Override
    public E remove(int index) {
        E returnElement = elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[--size] = null;
        return returnElement;
    }

    @Override
    public E get(int index) {
        return elements[index];
    }


    @Override
    public E set(int index, E element) {
        E nextElement = elements[index];
        if (size < elements.length) {
            elements[index] = element;
            return nextElement;
        } else {

            return null;
        }


    }

    @Override
    public void add(int index, E element) {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 3 / 2 - 1);

        }
        System.arraycopy(elements, index , elements, index +1 , size - index);
        elements[index] = element;
        size++;

    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        boolean mod = false;
        for (E element : c) {
            add(index++,element);
            mod = true;

        }
        return mod;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return addAll(size,c);
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return true;
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
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }
}
