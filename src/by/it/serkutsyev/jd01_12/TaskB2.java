package by.it.serkutsyev.jd01_12;

import java.util.*;

public class TaskB2 {
    public static void main(String[] args) {
        List<String> multiplicity = Arrays.asList("one");
        ArrayList<String> peopleArray = new ArrayList<>(multiplicity);
        LinkedList<String> peopleLinked = new LinkedList<>(multiplicity);
        System.out.println(process(peopleArray));
        System.out.println(process(peopleLinked));

    }

    static String process(ArrayList<String> people) {
        return arraylist(people);
    }

    static String process(LinkedList<String> people) {

        return arraylist(people);

    }

    static String arraylist (List<String>people){
        boolean shouldRemoveFirst = false;
        Iterator<String> iterator = people.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            if (iterator.hasNext()) {
                iterator.next();
                iterator.remove();
                if (people.size() == 1) {
                    return people.get(0);
                }
                if (iterator.hasNext()) {
                    shouldRemoveFirst = true;
                } else {
                    shouldRemoveFirst = false;
                }

            } else {
                if (shouldRemoveFirst) {
                    iterator = people.iterator();
                    iterator.next();
                    iterator.remove();
                    if (people.size() == 1) {
                        return people.get(0);
                    }

                } else {
                    iterator = people.iterator();
                    if (people.size() == 1) {
                        return people.get(0);
                    }
                }
            }
            if (people.size() == 1) {
                return people.get(0);
            }
        }
        return people.get(0);
    }
}
