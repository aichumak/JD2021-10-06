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
                String[] s = words.trim().split("[,\\.;:!?\\s]+");
                for (int i = 0; i < s.length; i++) {
                    text.add(s[i]);

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


