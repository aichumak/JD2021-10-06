package by.it.astapchik.jd01_12;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

class TaskA3 {
    private static final String STOP = "end";

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> integers = new ArrayList<>();
        int pos = 0;
        for(;;){
            String word = input.next();
            if (word.equals(STOP)){
                break;
            } else {
                Integer integer = Integer.valueOf(word);
                if (integer > 0){
                      integers.add(pos++, integer);
                }
                else if (integer == 0){
                    integers.add(pos, integer);
                }
                else {
                    integers.add(integer);
                }
            }
        }
        System.out.println(integers);
        System.out.println("App Calculator closed.");
    }
}
