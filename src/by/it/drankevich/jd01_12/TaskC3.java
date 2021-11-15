package by.it.drankevich.jd01_12;

import java.util.*;

public class TaskC3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String[] array = s.split("");
        String[] array1 = {};
        for (String value : array) {

            if (value.equals("{") || value.equals("}") || value.equals("(") || value.equals(")")
                    || value.equals("[") || value.equals("]")) {

                array1 = Arrays.copyOf(array1, array1.length + 1);
                array1[array1.length - 1] = value;

            }
        }

        List<String> array2 = Arrays.asList(array1);

        LinkedList<String> list = new LinkedList<>(array2);

        System.out.println(result(list));

    }

    private static boolean result(LinkedList<String> list) {

        if (list.size() % 2 != 0) {
            return false;
        } else {
            int a = Collections.frequency(list, "[");
            int b = Collections.frequency(list, "]");
            int c = Collections.frequency(list, "(");
            int d = Collections.frequency(list, ")");
            int i = Collections.frequency(list, "{");
            int f = Collections.frequency(list, "}");
            if (a != b || c != d || i != f) {
                return false;
            }
            for (int i1 = 0; i1 < list.size(); i1++) {
                if (list.get(i1).equals("[") && list.get(i1 + 1).equals("}")) return false;
                if (list.get(i1).equals("[") && list.get(i1 + 1).equals(")")) return false;
                if (list.get(i1).equals("(") && list.get(i1 + 1).equals("]")) return false;
                if (list.get(i1).equals("(") && list.get(i1 + 1).equals("}")) return false;
                if (list.get(i1).equals("{") && list.get(i1 + 1).equals("]")) return false;
                if (list.get(i1).equals("{") && list.get(i1 + 1).equals(")")) return false;
            }


        }
        return true;
    }
}

