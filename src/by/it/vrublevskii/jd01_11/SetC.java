package by.it.vrublevskii.jd01_11;


import java.util.*;

public class SetC<E> implements Set<E> {

    private E[] elements = (E[]) new Object[10];

    private int size = 0;


    @Override
    public boolean add(E e) {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 3 / 2 + 1);
        }
        for (int i = 0; i < size; i++) {
            if (this.contains(e)) {
                return false;
            }
        }
        elements[size++] = e;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == null && o == null) {
                System.arraycopy(elements, i + 1, elements, i, size - i - 1);
                elements[--size] = null;
                size--;
                return true;
            }
            if (elements[i] == null || o == null) {
                continue;
            }
            if (o.equals(elements[i])) {
                System.arraycopy(elements, i + 1, elements, i, size - i - 1);
                elements[--size] = null;
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if
//            (elements[i] == null ?  o == null: elements[i].equals(o)){
             (o == null ?  elements[i] == null: o.equals(elements[i])){
                return true;
            }
//            if (elements[i] == null && o == null) {
//                return true;
//            }
//            if (elements[i] == null || o == null) {
//                continue;
//            }
//            if (o.equals(elements[i])) {
//                return true;
//            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean result = false;
        for (E element : c) {
            result = this.add(element);
        }
        return result;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object elementC : c) {
            if (!this.contains(elementC)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(", ", "{", "}");
        for (int i = 0; i < size; i++) {
            stringJoiner.add(String.valueOf(elements[i]));
        }
        return stringJoiner.toString();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        int result = 0;
        for (Object element : c) {
            boolean removed = this.remove(element);
            if (removed) {
                result++;
            }
        }
        return result != 0;
    }

    @Override
    public void clear() {
        for (int i = size - 1; i >= 0; i--) {
            this.remove(elements[i]);
        }
    }
    //
    //
//
//
//
//
//
//

//

//

//


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
    public boolean retainAll(Collection<?> c) {
        return false;
    }
}


