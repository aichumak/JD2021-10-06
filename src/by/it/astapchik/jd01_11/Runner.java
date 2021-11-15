package by.it.astapchik.jd01_11;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String> list = new ListA<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        list.add("six");

        System.out.println(list);


        List<String> list1 = new ListB<>();
        list1.add("a->1");
        list1.add("b->2");
        list1.add("c->3");
        list1.add("d->4");
        list1.add("e->5");
        list1.add("f->6");
        System.out.println(list1);
        System.out.println(list1.set(1, "fuck"));
    }

}
