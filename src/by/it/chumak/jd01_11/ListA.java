package by.it.chumak.jd01_11;

import java.util.*;
import java.util.function.UnaryOperator;

public class ListA<E> implements List<E> {

    private E[] arrayElements = (E[]) new Object[]{};
    private int size = 0;

    @Override
    public boolean add(E e) {
        if (size == arrayElements.length) {
            arrayElements = Arrays.copyOf(arrayElements, (size * 3) / 2 + 1);
        }
        arrayElements[size++] = e;
        return true;
    }

    @Override
    public E get(int index) {
        return arrayElements[index];
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
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        for (E element : arrayElements) {
            if (element != null) {
                joiner.add(element.toString());
            }
        }
        return joiner.toString();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        size = 0;
        for (E element : arrayElements) {
            element = null;
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
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
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (arrayElements[i] == null && o == null) {
                return true;
            } else if (arrayElements[i] == null || o == null) {
                continue;
            }
            if (arrayElements[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void replaceAll(UnaryOperator<E> operator) {
        List.super.replaceAll(operator);
    }

    @Override
    public void sort(Comparator<? super E> c) {
        List.super.sort(c);
    }

    @Override
    public Spliterator<E> spliterator() {
        return List.super.spliterator();
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
    public boolean addAll(Collection<? extends E> c) {
        return false;
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
    public E set(int index, E element) {
        return null;
    }

    @Override
    public void add(int index, E element) {

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
