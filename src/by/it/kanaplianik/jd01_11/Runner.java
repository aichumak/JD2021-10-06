package by.it.kanaplianik.jd01_11;

import java.util.ArrayList;

public class Runner {
    public static void main(String[] args) {
        var list = new ListA<Integer>();

        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));

        list.remove(new Integer(2));

        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));

        ArrayList<Integer> i = new ArrayList<Integer>();
        i.add(3);
        i.add(5);

        var a = i.set(1, null);
        i.add(1, 42);

        System.out.println(i);

        var list2 = new ListB<Integer>();

        list2.add(1);
        list2.add(2);
        list2.add(3);

        list2.set(1, null);
        list2.add(1, 42);
        System.out.println(list2);
    }
}
