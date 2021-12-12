package by.it.brutski.jd01_12;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        int zero = 0;
        Scanner scanner = new Scanner(System.in);

        for (; ; ) {
            String word = scanner.next();
            if(word.equals("end")){
                break;
            }else{
                Integer value = Integer.valueOf(word);
                if(value > 0){
                    a.add(zero++, value);
                }else if(value == 0){
                    a.add(zero, value);
                }else {
                    a.add(value);
                }
            }
        }
        System.out.println(a);
    }
}
