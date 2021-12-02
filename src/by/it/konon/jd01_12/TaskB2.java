package by.it.konon.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class TaskB2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество людей: ");
        int n = scanner.nextInt();
        ArrayList<String> array = new ArrayList<>();
        LinkedList<String> linked = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            array.add("" + i);
            linked.add("" + i);
        }
        System.out.println(process(array));
        System.out.println(process(linked));
    }

    static String process(ArrayList<String> peoples) {
        Iterator<String> iterator = peoples.iterator();


        while (peoples.size() > 1) {
            int pplNum = peoples.size();

            if (peoples.size() == 2) {
                peoples.remove(1);
                return peoples.get(0);
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
            if (pplNum % 2 != 0) {
                iterator.next();
                iterator.remove();
            }


        }


        return peoples.get(0);
    }


    static String process(LinkedList<String> peoples) {
        Iterator<String> iterator = peoples.iterator();


        while (peoples.size() > 1) {
            int pplNum = peoples.size();

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
            if (pplNum % 2 != 0) {
                iterator.next();
                iterator.remove();
            }


        }
        return peoples.get(0);


    }
}

