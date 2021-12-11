package by.it.astapchik.jd01_11;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Runner {
    public static void main(String[] args) {
        List<String> list = new ListA<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        list.add("six");

        List<String> list1 = new ListB<>();
        list1.add("a->1");
        list1.add("b->2");
        list1.add("c->3");
        list1.add("d->4");
        list1.add("e->5");
        list1.add("f->6");

        SetC<String> set2 = new SetC<>();
        set2.add("one");
        set2.add("two");
        set2.add("three");
        set2.add("four");
        set2.add("five");
        set2.add("six");


        SetC<String> set1 = new SetC<>();
        set1.add("one");
        set1.add("two");
        set1.add("three");
        set1.add("four");
        set1.add("five");
        set1.add("six");

        set1.remove("three");

        System.out.println(set1.containsAll(set2));


    }

}
