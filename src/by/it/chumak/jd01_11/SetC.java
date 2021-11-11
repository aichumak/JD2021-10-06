package by.it.chumak.jd01_11;

import java.util.*;

public class SetC<E> implements Set<E> {

    private E[] arrayElements = (E[]) new Object[]{};
    private int size = 0;

    @Override
    public boolean add(E e) {
        if (contains(e)) {
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
        boolean result = false;
        for (E element : c) {
            result = add(element);
        }
        return result;
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
            if(element == null && o == null) {
                return true;
            } else if (element == null || o == null) {
                return false;
            }
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
        return size == 0;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        boolean result = false;
        for (Object element : c) {
            result = contains(element);
        }
        return result;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean result = false;
        for (Object element : c) {
            result = remove(element);
        }
        return result;
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

    @Override
    public void clear() {

    }
}
