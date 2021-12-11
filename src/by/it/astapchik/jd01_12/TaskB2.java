package by.it.astapchik.jd01_12;

import java.util.*;

class TaskB2 {
    public static void main(String[] args) {
        List<String> persons = Arrays.asList("ONE", "TWO", "THREE","FOUR", "FIVE", "SIX");
        ArrayList<String> arrayList = new ArrayList<>(persons);
        LinkedList<String> linkedList = new LinkedList<>(persons);
        System.out.println(process(arrayList));
        System.out.println(process(linkedList));
    }

    static String process(ArrayList<String> list) {
        iteratePeople(list);
        return list.get(0);
    }
    static String process(LinkedList<String> list) {
        iteratePeople(list);
        return list.get(0);
    }

    private static void iteratePeople(List<String> people) {
        Iterator<String> iterator = people.iterator();
        int counter = 0;
        while (people.size() > 1){
            if(!iterator.hasNext()){
                iterator = people.iterator();
            }
            iterator.next();
            if ( counter == 0 ){
                counter++;
            }
            else{
                iterator.remove();
                counter--;
            }
        }
    }
}
