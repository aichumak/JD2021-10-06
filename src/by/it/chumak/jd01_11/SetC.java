package by.it.chumak.jd01_11;

import java.util.*;
import java.util.function.UnaryOperator;

public class SetC<E> implements List<E> {

    private E[] arrayElements = (E[]) new Object[]{};
    private int size = 0;

    @Override
    public boolean add(E e) {
        if (elementFoundInArray(e)) {
            return false;
        } else {
            if (size == arrayElements.length) {
                arrayElements = Arrays.copyOf(arrayElements, (size * 3) / 2 + 1);
            }
            arrayElements[size++] = e;
            return true;
        }
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

    private boolean elementFoundInArray(E e) {
        for (E element : arrayElements) {
            if (element.equals(e)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < arrayElements.length; i++) {
            if (o.equals(arrayElements[i])) {
                System.arraycopy(arrayElements, i + 1, arrayElements, i, size - 1 - i);
                arrayElements[size] = null;
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(Object o) {
        for (E element : arrayElements) {
            if (element.equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
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

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public void add(int index, E element) {

    }

    @Override
    public E remove(int index) {
        return null;
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
