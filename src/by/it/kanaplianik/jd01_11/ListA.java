package by.it.kanaplianik.jd01_11;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListA<T> implements List<T> {

    private Item<T> head = null;

    @Override
    public boolean add(T t) {
        Item<T> newItem = new Item<T>(t);
        if (head == null) {
            head = newItem;
            return true;
        }
        else {
            Item<T> i = head;
            while (i.getNext() != null){
                i = i.getNext();
            }
            i.setNext(newItem);
            return true;
        }
    }

    @Override
    public boolean remove(Object o) {
        if (head == null) {
            return false;
        }
        else {
            if (o.equals(head.getValue())) {
                head = null;
                return true;
            }
            else {
                Item<T> currentItem = head;
                while (currentItem.getNext() != null){
                    if (o.equals(currentItem.getNext().getValue())) {
                        currentItem.setNext(currentItem.getNext().getNext());
                        return true;
                    }
                    currentItem = currentItem.getNext();
                }
                return false;
            }
        }
    }

    @Override
    public T remove(int index) {
        if (head == null) {
            return null;
        }
        else {
            if (index == 0) {
                var itemToDelete = head;
                head = head.getNext();
                return itemToDelete.getValue();
            }
            else {
                int currentItemIndex = 0;
                Item<T> currentItem = head;
                while (currentItem.getNext() != null){
                    if (index == currentItemIndex+1) {
                        var itemToDelete = currentItem.getNext();
                        currentItem.setNext(currentItem.getNext().getNext());
                        return itemToDelete.getValue();
                    }
                    currentItem = currentItem.getNext();
                    currentItemIndex++;
                }
                return null;
            }
        }
    }

    @Override
    public String toString() {
        if (head == null) {
            return "[]";
        }
        else {
            StringBuilder result = new StringBuilder("[");
            Item<T> currentItem = head;
            while (currentItem != null){
                if (currentItem.getNext()== null) {
                    result.append(currentItem.getValue()).append("]");
                }
                else {
                    result.append(currentItem.getValue()).append(", ");
                }

                currentItem = currentItem.getNext();
            }

            return result.toString();
        }
    }

    @Override
    public T get(int index) {
        int itemIndex = 0;
        if (head == null) {
            return null;
        }
        else {
            if (index == 0) {
                return head.getValue();
            }
            else {
                Item<T> currentItem = head;
                while (currentItem.getNext() != null){
                    currentItem = currentItem.getNext();
                    itemIndex++;
                    if (itemIndex == index) {
                        return currentItem.getValue();
                    }
                }
                return null;
            }
        }
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
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
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
    public T set(int index, T element) {
        return null;
    }

    @Override
    public void add(int index, T element) {

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
