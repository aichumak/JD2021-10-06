package by.it.kanaplianik.jd01_12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class TaskB2 {
    public static void main (String[] args) {

        System.out.println(process(new ArrayList<String>(Arrays.asList("1", "2", "3", "4", "5"))));
        System.out.println(process(new LinkedList<String>(Arrays.asList("1", "2", "3", "4", "5"))));
    }

    static String process (ArrayList<String> peoples) {
        boolean needToDelete = false;
        while (peoples.size() > 1) {
            Iterator<String> iter = peoples.iterator();
            while (iter.hasNext()) {
                iter.next();
                if (needToDelete) {
                    iter.remove();
                    needToDelete = false;
                } else {
                    needToDelete = true;
                }
            }
        }
        return peoples.get(0);
    }

    static String process (LinkedList<String> peoples) {
        boolean needToDelete = false;
        while (peoples.size() > 1) {
            Iterator<String> iter = peoples.iterator();
            while (iter.hasNext()) {
                iter.next();
                if (needToDelete) {
                    iter.remove();
                    needToDelete = false;
                } else {
                    needToDelete = true;
                }
            }
        }
        return peoples.get(0);
    }
}
