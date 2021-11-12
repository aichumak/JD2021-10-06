package by.it.drankevich.jd01_11;

import java.util.*;

public class SetC <E> implements Set<E> {
    private E [] elements= (E[]) new Object[]{};

    private int size=0;

    @Override
    public String toString() {
        StringJoiner sj= new StringJoiner(", ", "[", "]");
        for (int i = 0; i < size; i++) {
            sj.add(String.valueOf(elements[i]));
        }

        return sj.toString();

    }

    @Override
    public boolean add(E e) {

            for (int i = 0; i < size; i++) {
                if(elements[i]==null) {
                    if(elements[i]==e) return false;
                    else continue;
                }
                if(elements[i].equals(e)) return false;
            }
            if(size==elements.length)
                elements= Arrays.copyOf(elements, (size*3)/2+1);
            elements[size++]=e;

            return true;

    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        for (E e : c) {
            add(e);

        }


        return true;
    }


    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if(elements[i]==null){
                if (elements[i]==o) {
                    System.arraycopy(elements,i+1,elements, i, size-i-1 );
                    elements[--size] = null;
                    return true;}
                else continue ;
            }
            if(elements[i].equals(o)){
                System.arraycopy(elements,i+1,elements, i, size-i-1 );
                elements[--size] = null;
                return true;
            }

        }

        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        for (Object o : c) {
            remove(o);

        }
        return true;
    }

    @Override
    public boolean contains(Object o) {
            for (int i = 0; i < size; i++) {
                if(elements[i]==null){
                    if (elements[i]==o) return true;
                    else continue;
                }

                if (elements[i].equals(o))
                    return true;
            }


        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if(!contains(o)) return false;

        }
        return true;
    }

    @Override
    public boolean isEmpty() {
        if(size==0) return true;

        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int position=0;

            @Override
            public boolean hasNext() {
                return position<size;
            }

            @Override
            public E next() {
                return elements[position++];
            }
        };
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
        elements=Arrays.copyOf(elements,0);
        size=0;

    }
}
