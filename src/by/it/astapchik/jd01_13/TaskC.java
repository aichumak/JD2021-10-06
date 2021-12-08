package by.it.astapchik.jd01_13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class TaskC {
    static Scanner input;
    public static void main(String[] args) throws InterruptedException {
        input = new Scanner(System.in);
        readData();
    }
    static void readData() throws InterruptedException {
        ArrayList<Double> numbers = new ArrayList<>();
        int errors = 0;
        while ( errors < 6 ) {
            String userInput = input.next();
            try{
                double n = Double.parseDouble(userInput);
                numbers.add(n);
            } catch (NumberFormatException e) {
                Thread.sleep(100);
                errors++;
                if (errors == 5) {
                    throw e;
                }
                numbers.sort(Collections.reverseOrder());
                for (Double number : numbers) {
                    System.out.print(number + " ");
                }
            }
        }
    }
}
