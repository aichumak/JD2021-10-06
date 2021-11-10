package by.it.kanaplianik.jd01_09;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String something = scanner.nextLine();
            if (something.equals("end")) {
                return;
            }
            else {
                MathExpression expression = new MathExpression(something);
                BinaryOperation binary = new BinaryOperation(expression);
                System.out.println(binary.getResult());
            }

        }
    }
}
