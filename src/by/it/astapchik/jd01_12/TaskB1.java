package by.it.astapchik.jd01_12;

import java.util.Scanner;

class TaskB1 {

    private static final String STOP = "end";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        for( ; ; ){
            String end = input.next();
            if (end.equals(STOP)){
                break;
            }
        }
    }
}
