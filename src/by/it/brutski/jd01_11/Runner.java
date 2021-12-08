package by.it.brutski.jd01_11;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String> list = new ListA<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");

        System.out.println(list);

        String two = list.get(1);
        System.out.println(two);

        list.remove(2);
        System.out.println(list);
    }
}
