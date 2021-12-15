package by.it.kanaplianik.jd02_04;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        while (true) {
            String something = scanner.nextLine();
            if (something.equals("end")) {
                return;
            }
            else {
                System.out.println(calculator.calculate(something));
            }

        }
    }
}
