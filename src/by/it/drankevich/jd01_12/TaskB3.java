package by.it.drankevich.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class TaskB3 {
    public static void main(String[] args) {

        int n = 4096;
        ArrayList<String> array = new ArrayList<>();
        LinkedList<String> linked = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            array.add("number+" + i);
            linked.add("number+" + i);
        }

        long timestart=System.nanoTime();
        System.out.println(process(array));
        long delta=(System.nanoTime()-timestart);
        System.out.println(delta);

        long timestart1=System.nanoTime();
        System.out.println(process(linked));
        long delta1=(System.nanoTime()-timestart1);
        System.out.println(delta1);
    }




    static String process(ArrayList<String> peoples) {
        Iterator<String> iterator = peoples.iterator();


        while (peoples.size() > 1) {
            int a = peoples.size();

            if (peoples.size() == 2) {
                peoples.remove(1);
                return peoples.get(0).toString();
            }

            iterator.next();
            while (iterator.hasNext()) {
                iterator.next();

                iterator.remove();
                if (iterator.hasNext()) {
                    iterator.next();
                }
            }

            iterator = peoples.iterator();
            if (a % 2 != 0) {
                iterator.next();
                iterator.remove();
            }


        }


        return peoples.get(0).toString();
    }


    static String process(LinkedList<String> peoples) {
        while (peoples.size()>1) {
            for (int i = 0; i < 1; i++) {
                peoples.addLast(peoples.get(i));
                peoples.removeFirst();
                peoples.removeFirst();


            }
        }
        return peoples.get(0).toString();

        }



    }


