package by.it.vrublevskii.jd01_11;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String> list = new ListA<>();
        list.add("0");
        list.add("2");
        list.add("4");
        list.add("6");
        list.add("8");
        list.add("10");
        list.add("12");
        list.add("14");
        list.add("16");
        list.add("18");
        System.out.println(list);
        String two = list.get(0);
        System.out.println(two);
        System.out.println(list.remove(0));
        System.out.println(list);
    }
}
