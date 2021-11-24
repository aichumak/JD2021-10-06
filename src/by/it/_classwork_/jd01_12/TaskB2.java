package by.it._classwork_.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class TaskB2 {

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
    }
}
