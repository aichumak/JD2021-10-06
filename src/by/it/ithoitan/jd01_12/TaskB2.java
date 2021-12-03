package by.it.ithoitan.jd01_12;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TaskB2 {
    public static void main(String[] args) {
        LinkedList<String> peoples2 = new LinkedList<>();
        peoples2.add("1");
        peoples2.add("2");
        peoples2.add("3");
        peoples2.add("4");
        peoples2.add("5");
        peoples2.add("6");
        peoples2.add("7");
        peoples2.add("8");
        peoples2.add("9");
        ArrayList<String> peoples = new ArrayList<>();
        peoples.add("1");
        peoples.add("2");
        peoples.add("3");
        peoples.add("4");
        peoples.add("5");
        peoples.add("6");
        peoples.add("7");
        peoples.add("8");
        peoples.add("9");
        peoples.add("10");
        peoples.add("11");
        process(peoples);
        process(peoples2);
        System.out.println(peoples);
        System.out.println(peoples2);

    }
        static String process(ArrayList<String> peoples) {
            boolean remove = false;
            while (true) {
                Iterator<String> iterator = peoples.iterator();
                while (iterator.hasNext()) {
                    String skip = iterator.next();
                    if (remove) {
                        iterator.remove();
                    }
                    remove = !remove;
                    if (peoples.size()==1){
                        return skip;
                    }
                }
            }
        }

        static String process(LinkedList<String> peoples) {
            boolean remove = false;
            while (true) {
                Iterator<String> iterator = peoples.iterator();
                while (iterator.hasNext()) {
                    String skip = iterator.next();
                    if (remove) {
                        iterator.remove();
                    }
                    remove = !remove;
                    if (peoples.size()==1){
                        return skip;
                    }
                }
            }
//        List<String> peoples2 = new LinkedList<>();
//        peoples2.add("1");
//        peoples2.add("2");
//        peoples2.add("3");
//        peoples2.add("4");
//        peoples2.add("5");
//        peoples2.add("6");
//        peoples2.add("7");
//        peoples2.add("8");
//        peoples2.add("9");
//        List<String> peoples = new ArrayList<>();
//        peoples.add("1");
//        peoples.add("2");
//        peoples.add("3");
//        peoples.add("4");
//        peoples.add("5");
//        peoples.add("6");
//        peoples.add("7");
//        peoples.add("8");
//        peoples.add("9");
//        peoples.add("10");
//        peoples.add("11");
//        boolean remove = false;
//        while (peoples.size()>1) {
//            Iterator<String> iterator = peoples.iterator();
//            while (iterator.hasNext()) {
//                String skip = iterator.next();
//                if (remove) {
//                    iterator.remove();
//                }
//                remove = !remove;
//
//                System.out.println(peoples.toString());
//            }
//        }
//        while (peoples2.size()>1) {
//            Iterator<String> iterator = peoples2.iterator();
//            while (iterator.hasNext()) {
//                String skip = iterator.next();
//                if (remove) {
//                    iterator.remove();
//                }
//                remove = !remove;
//
//                System.out.println(peoples2.toString());
//            }
//        }
    }
}


