package by.it.chumak.jd01_11;

import java.util.*;

public class ListB<E> implements List<E> {

    private E[] arrayElements = (E[]) new Object[]{};
    private int size = 0;

    @Override
    public void add(int index, E element) {
        if (size == arrayElements.length) {
            arrayElements = Arrays.copyOf(arrayElements, (size * 3) / 2 + 1);
        }
        System.arraycopy(arrayElements, index, arrayElements, index + 1, size + 1 - index);
        size++;
        arrayElements[index] = element;
    }

    @Override
    public boolean add(E e) {
        if (size == arrayElements.length) {
            arrayElements = Arrays.copyOf(arrayElements, (size * 3) / 2 + 1);
        }
        arrayElements[size++] = e;
        return true;
    }

    @Override
    public E remove(int index) {
        E tempIndexValue = arrayElements[index];
        System.arraycopy(arrayElements, index + 1, arrayElements, index, size - 1 - index);
        size--;
        arrayElements[size] = null;
        return tempIndexValue;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        if ((size + c.size() + 1) > arrayElements.length) {
            arrayElements = Arrays.copyOf(arrayElements, size + c.size() + 1);
        }
        System.arraycopy(c.toArray(), 0, arrayElements, size, c.size());
        size = size + c.size();
        return true;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        for (int i = 0; i < size; i++) {
            if (arrayElements[i] != null) {
                joiner.add(arrayElements[i].toString());
            } else {
                joiner.add("null");
            }
        }
        return joiner.toString();
    }

    @Override
    public E set(int index, E element) {
        E tempElement = arrayElements[index];
        if (index < size) {
            arrayElements[index] = element;
            return tempElement;
        } else {
            return null;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private int position = 0;

            @Override
            public boolean hasNext() {
                return position < size;
            }

            @Override
            public E next() {
                return arrayElements[position++];
            }
        };
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
    public E get(int index) {
        return arrayElements[index];
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

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
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
}
