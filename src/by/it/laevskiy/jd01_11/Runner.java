package by.it.laevskiy.jd01_11;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String> list = new ListB<>();
        List<String> arList = new ArrayList<>();

        arList.add("one");
        arList.add("two");
        arList.add("four");
        arList.add("five");

        list.add("one");
        list.add("two");
        list.add("four");
        list.add("five");

        System.out.println(list);
        System.out.println(arList);
        list.add(3,"999");
        arList.add(3,"999");
        System.out.println(list);
        System.out.println(arList);
    }
}

