package by.it.astapchik.jd01_12;

import java.util.*;

class TaskB3 {
    public static void main(String[] args) {
        int size = 4096;
        ArrayList<String> arrayList = new ArrayList<>();
        LinkedList<String> linkedList = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            arrayList.add("n " + i );
            linkedList.add("n " + i );
        }
        System.out.println(process(arrayList));
        System.out.println(process(linkedList));
    }

    static String process(ArrayList<String> list) {
        processForArray(list);
        return list.get(0);
    }


    static String process(LinkedList<String> list) {
        processForList(list);
        return list.get(0);
    }

    private static void processForList(LinkedList<String> list) {
        while (list.size() > 1){
            list.pollLast();
        }
    }


    private static void processForArray(ArrayList<String> list) {
        Iterator<String> iterator = list.iterator();
        int counter = 0;
        while (list.size() > 1){
            if(!iterator.hasNext()){
                iterator = list.iterator();
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
