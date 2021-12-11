package by.it.konon.jd01_12;

import java.util.*;

public class TaskB1 {
    public static void main(String[] args) {


        ArrayList<String> text = new ArrayList<>();
        HashSet<String> result=new HashSet<>();
        Scanner scanner = new Scanner(System.in);
        for (; ; ) {
            String words = scanner.nextLine();
            if (words.equals("end")) break;
            else {
                String[] str = words.trim().split("[,\\.;:!?\\s]+");
                for (int i = 0; i < str.length; i++) {
                    text.add(str[i]);

                }
            }
        }
        Iterator<String> iterator = text.iterator();
        while (iterator.hasNext()) {
            String word = iterator.next();

            int count = Collections.frequency(text,word );
            result.add(word+"="+count);

        }




        System.out.println(result);

    }
}


