package by.it.chumak.jd01_11;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String> listA = new ListA<>();
        listA.add("One");
        listA.add("Two");
        listA.add("Three");
        listA.add("Four");
        listA.add("Five");
        System.out.println(listA.toString());

        List<String> listB = new ListB<>();
        listB.add("One");
        listB.add("Two");
        listB.add("Three");
        listB.add("Four");
        listB.add("Five");
        System.out.println(listB.toString());

        SetC<Object> setC = new SetC<>();
        setC.add("One");
        setC.add("Two");
        setC.add("Three");
        setC.add("Four");
        setC.add("Five");
        System.out.println(setC.toString());

    }
}
