package by.it.vrublevskii.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class TaskB3 {

        public static void main(String[] args) {
            ArrayList<String> peoplesArrayList = new ArrayList<>();
            LinkedList<String> peoplesLinkedList = new LinkedList<>();
            peoplesArrayList.add("Егор");
            peoplesArrayList.add("Екатерина");
            peoplesArrayList.add("Владимир");
            peoplesArrayList.add("Виктор");
            peoplesArrayList.add("Анастасия");
            peoplesArrayList.add("Анастасия1");

            peoplesLinkedList.add("Егор");
            peoplesLinkedList.add("Екатерина");
            peoplesLinkedList.add("Владимир");
            peoplesLinkedList.add("Виктор");
            peoplesLinkedList.add("Анастасия");
            peoplesLinkedList.add("Анастасия1");
            System.out.println(process(peoplesArrayList));
            System.out.println(process(peoplesLinkedList));

        }

        static String process(ArrayList<String> peoples) {
            int numberPerson = 0;
            while (peoples.size() > 1){
                Iterator<String> iterator = peoples.iterator();
                numberPerson = terminatePersons(numberPerson, iterator);
            }
            return peoples.get(0);
        }

    static String process(LinkedList<String> peoples) {
            int numberPerson = 0;
            while (peoples.size() > 1){
                Iterator<String> iterator = peoples.iterator();
                numberPerson = terminatePersons(numberPerson, iterator);
            }
            return peoples.get(0);
        }

    private static int terminatePersons(int numberPerson, Iterator<String> iterator) {
        while (iterator.hasNext()) {
            numberPerson++;
            if (numberPerson % 2 == 0) {
                iterator.next();
                iterator.remove();
            } else {
                iterator.next();
            }
        }
        return numberPerson;
    }
}
