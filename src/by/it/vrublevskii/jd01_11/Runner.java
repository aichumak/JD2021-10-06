package by.it.vrublevskii.jd01_11;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Runner {
    public static void main(String[] args) {
//        List<String> list = new ListA<>();
//        List<String> list1 = new ListA<>();
//        list.add("0");
//        list.add("2");
//        list.add("4");
//        list.add("6");
//        list.add("8");
//        list.add("10");
//        list.add("12");
//        list.add("14");
//        list.add("16");
//        list.add("18");
//        System.out.println(list);
//        String two = list.get(2);
//        System.out.println(two);
//        System.out.println(list.remove(2));
//        System.out.println(list);
//
//        list1.add("0");
//        list1.add("2");
//        list1.add("4");
//        list1.add("5");
//        list1.add("7");
//        list1.addAll(list);
//        System.out.println(list1);


//        Object o = new Object();
//        Object o1 = new Object();
        HashSet<Object> objects = new HashSet<>();
        HashSet<Object> objects1 = new HashSet<>();
        objects.add(null);
        objects1.add(null);
        for (Object o : objects) {
            for (Object o1 : objects1) {
//                o.equals(o1);
                System.out.println(Objects.equals(o,o1));
            }
        }
    }
}
