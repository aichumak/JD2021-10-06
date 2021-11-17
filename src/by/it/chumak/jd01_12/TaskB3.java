package by.it.chumak.jd01_12;

import java.util.*;

public class TaskB3 {
    public static void main(String[] args) {
        List<String> peoples = Arrays.asList("Mike", "Denis", "John", "Aleks", "Arnold");
        ArrayList<String> peoples1 = new ArrayList<>(peoples);
        LinkedList<String> peoples2 = new LinkedList<>(peoples);
        System.out.println(process(peoples1));
        System.out.println(process(peoples2));
    }

    static String process(ArrayList<String> peoples) {
        processCollection(peoples);
        return peoples.get(0);
    }

    static String process(LinkedList<String> peoples) {
        processLinkedCollection(peoples);
        return peoples.get(0);
    }

    private static void processCollection(ArrayList<?> arrayPeoples) {
        if (arrayPeoples.size() == 1) {
            return;
        }

        int entryNumber = 1;
        Iterator<?> iterator = arrayPeoples.iterator();

        while (arrayPeoples.size() > 1) {
            if (!iterator.hasNext()) {
                iterator = arrayPeoples.iterator();
            }
            iterator.next();
            if (entryNumber == 1) {
                entryNumber++;
            } else {
                iterator.remove();
                entryNumber--;
            }
        }
    }

    private static void processLinkedCollection(LinkedList<String> arrayPeoples) {
        if (arrayPeoples.size() == 1) {
            return;
        }

        while (arrayPeoples.size() > 1) {
            arrayPeoples.addLast(arrayPeoples.pollFirst());
            arrayPeoples.pollFirst();
        }
    }

}
