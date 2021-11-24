package by.it.kanaplianik.jd01_11;

public class Item<T> {
    public Item(T e) {
        element = e;
    }

    private T element;

    public T getValue() {
        return element;
    }

    public void setValue(T value) {
        element = value;
    }

    private Item<T> next;

    public Item<T> getNext() {
        return next;
    }

    public void setNext(Item<T> e) {
        next = e;
    }
}
