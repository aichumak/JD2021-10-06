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

    private static void processCollection(List<?> arrayPeoples) {
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

    private static void processLinkedCollection(LinkedList<?> arrayPeoples) {
        if (arrayPeoples.size() == 1) {
            return;
        }

        for (int i = 0; i < arrayPeoples.size(); i++) {
            if (arrayPeoples.size() == i+1 && arrayPeoples.size() > 1){
                arrayPeoples.remove(arrayPeoples.get(0));
                i = 0;
            }
            int size = arrayPeoples.size();
            arrayPeoples.remove(arrayPeoples.get(i+1));
        }

    }

}
