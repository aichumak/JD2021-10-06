package by.it.brutski.jd01_11;

import java.util.*;

public class ListB<T> implements List<T> {
    private T[] elements = (T[]) new Object[10];
    private int size = 0;

    public String toString() {
        StringJoiner st_joiner = new StringJoiner(", ", "[", "]");
        for (int i = 0; i < size; i++) {
            st_joiner.add(String.valueOf(elements[i]));
        }
        return st_joiner.toString();
    }

    public boolean add(T e) {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 3 / 2 + 1);
        }
        elements[size++] = e;
        return true;
    }

    public T remove(int index) {
        T returnElement = elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[--size] = null; //GC
        return returnElement;
    }

    public T get(int index) {
        return elements[index];
    }

    public T set(int index, T e){
        T e_Element = elements[index];
        elements[index] = e;
        return e_Element;
    }

    public void add(int index, T e){
        if (size == elements.length)
            elements = Arrays.copyOf(elements, size * 3 / 2 +1);
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = e;
        size++;
    }

    public boolean addAll(Collection<? extends T> c){
        if(size == elements.length)
            elements = Arrays.copyOf(elements, elements.length * 3 / 2 + c.size());
        System.arraycopy(c.toArray(), 0, elements, size, c.size());
        size = size + c.size();
        return true;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object o) {
        return false;
    }

    public Iterator<T> iterator() {
        return null;
    }

    public Object[] toArray() {
        return new Object[0];
    }

    public <T> T[] toArray(T[] a) {
        return null;
    }

    public boolean remove(Object o) {
        return false;
    }

    public boolean containsAll(Collection<?> c) {
        return false;
    }

    public boolean addAll(List<? extends T> c) {
        return false;
    }

    public boolean addAll(int index, Collection<? extends T> c) {
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
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }

}
