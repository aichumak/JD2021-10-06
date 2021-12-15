package by.it.brutski.jd01_12;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Iterator;
import java.util.Collections;


public class TaskB1 {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        HashSet<String> hashSet = new HashSet<>();
        Scanner scanner = new Scanner(System.in);

        for(; ; ){
            String word = scanner.nextLine();
            if(word.equals("end")) {
                break;
            }else {
                String[] str = word.trim().split("[,\\.:;?!\\s]+");

                for (int i = 0; i < str.length; i++) {
                    arrayList.add(str[i]);
                }
            }
        }

        Iterator<String> iterator = arrayList.iterator();
        while (iterator.hasNext()){
            String words = iterator.next();
            int a = Collections.frequency(arrayList, words);
            hashSet.add(words + "=" + a);
        }
        System.out.println(hashSet);
    }
}
