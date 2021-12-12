package by.it.brutski.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class TaskB2 {
    static String process(ArrayList<String> peoples){
        boolean flag = false;
        while (true){
            Iterator<String> iterator = peoples.iterator();

            while (iterator.hasNext()){
                String skip = iterator.next();
                if(flag) iterator.remove();

                flag = !flag;

                if(peoples.size() == 1) return skip;
            }
        }
    }

    static String process(LinkedList<String> peoples){
        boolean flag = false;
        while (true){
            Iterator<String> iterator = peoples.iterator();

            while (iterator.hasNext()){
                String skip = iterator.next();
                if(flag) iterator.remove();

                flag = !flag;

                if(peoples.size() == 1) return skip;
            }
        }
    }
}
