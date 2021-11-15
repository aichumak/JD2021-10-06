package by.it.drankevich.jd01_12;

import java.util.*;

public class TaskC3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        s.trim();
        String[] array = s.split("");
        String[] array1 = {};
        for (int i = 0; i < array.length; i++) {

            if (array[i].equals("{") || array[i].equals("}") || array[i].equals("(") || array[i].equals(")")
                    || array[i].equals("[") || array[i].equals("]")) {

                array1 = Arrays.copyOf(array1, array1.length + 1);
                array1[array1.length - 1] = array[i];

            }
        }

        List<String> array2 = Arrays.asList(array1);

        LinkedList<String> list = new LinkedList<>();
        for (int i = 0; i < array2.size(); i++) {
            list.add(array2.get(i));

        }

        System.out.println(result(list));


    }

    private static boolean result(LinkedList<String> list) {
        LinkedList<String> list1 = new LinkedList<>();

        if (list.size() % 2 != 0) {
            return false;
        } else {
            int a = Collections.frequency(list, "[");
            int b = Collections.frequency(list, "]");
            int c = Collections.frequency(list, "(");
            int d = Collections.frequency(list, ")");
            int i = Collections.frequency(list, "{");
            int f = Collections.frequency(list, "}");
            if(a!=b||c!=d||i!=f){
                return false;
            }

          /*  int a=list.size();
            while (list.size() != (a/ 2)) {

                list1.addLast(list.removeFirst());

            }
            System.out.println(list1);
            System.out.println(list);
            list.retainAll(list1);
            System.out.println(list);
            if (list.size() == 0) {
                return true;
            }  */

        }
        return true;
    }
}

