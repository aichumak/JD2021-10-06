package by.it.serkutsyev.jd01_11;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
       // List<String> array = new ListB<>();
        List<String> array = new ArrayList<>();
        List<String> array1 = new ArrayList<>();

        array.add("one");
        array.add("two");
        array.add("three");
        array.add("four");
        array.add("five");
        array1.add("test5");
        array1.add("test7");
       // array.add("six");
        System.out.println(array);
        String two = array.get(1);
        System.out.println(two);
        array.remove(3);
        System.out.println(array);
        array.set(2,"test");
        System.out.println(array);
        array.add(2,"testaddindex");
       // array.add("test2");
        array.add(1,"test3");
        System.out.println(array);
        array.addAll(array1);
        System.out.println(array);
        System.out.println(array1.size());
    }
}


//[one, two, three, four, five]
//        two
//        [one, two, three, five]
//        [one, two, test, five]
//        [one, test3, two, testaddindex, test, five]