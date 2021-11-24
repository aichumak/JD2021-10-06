package by.it.serkutsyev.jd01_12;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        int zeroPosition = 0;
        Scanner scanner = new Scanner(System.in);
        for (;;){
            String word = scanner.next();
            if (word.equals("end")){
                break;
            }
            else {
                Integer number = Integer.valueOf(word);
                if (number>0){
                    numbers.add(zeroPosition++,number);
                }
                else if (number==0){
                    numbers.add(zeroPosition,number);
                }
                else {
                    numbers.add(number);
                }

            }
        }
        System.out.println(numbers);
    }
}
