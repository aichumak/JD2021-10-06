package by.it.astapchik.jd01_11;

import java.util.*;

class SetC <E> implements Set<E> {

    @SuppressWarnings("unchecked")

    private E[] elements = (E[]) new Object[]{};
    private int size = 0;

    @Override
    public void clear() {
        Arrays.copyOf(elements, 0);
        size = 0;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        for (Object element : collection) {
            remove(element);
        }
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        for (Object element : collection) {
            if(!contains(element)){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        for (E element : c) {
            add(element);
        }
        return true;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == null){
                if (elements[i] == o) {
                    return true;
                } else {
                    continue;
                }
            }
            if (elements[i].equals(o)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == null){
                if (elements[i] == o) {
                    System.arraycopy(elements, i+1, elements, i, size-i-1);
                    elements[--size] = null;
                    return true;
                } else {
                    continue;
                }
            }
            if (elements[i].equals(o)){
                System.arraycopy(elements, i+1, elements, i, size-i-1);
                elements[--size] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean add(E e) {

        for (int i = 0; i < size; i++) {
            if (elements[i] == null){
                if (elements[i] == e) {
                    return false;
                } else {
                    continue;
                }
            }
            if (elements[i].equals(e)){
                return false;
            }
        }

        if (size == elements.length){
            elements = Arrays.copyOf(elements, elements.length * 3 / 2 + 1);
        }
        elements[size++] = e;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        for (int i = 0; i < size; i++) {
            joiner.add(String.valueOf(elements[i]));
        }
        return joiner.toString();
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
    public <T> T[] toArray(T[] ts) {
        return null;
    }


    @Override
    public boolean retainAll(Collection<?> collection) {
        return false;
    }

}
