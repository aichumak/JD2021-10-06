package by.it.vrublevskii.jd01_13;

import java.util.Locale;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        double sumDouble = 0;
        double sqrtSumDouble;
        for (; ; ) {
            String next = scanner.nextLine();
            if (!next.equals("END")) {
                try {
                    double currentDouble = Double.parseDouble(next);
                    sumDouble += currentDouble;
                    if (sumDouble < 0) {
                        throw new ArithmeticException();
                    }
                    sqrtSumDouble = Math.sqrt(sumDouble);
                    System.out.printf("Current Number: %.3f\nSumma square root: %.3f\n", currentDouble, sqrtSumDouble);
                } catch (NumberFormatException | ArithmeticException e) {
                    Class<TaskB> taskBClass = TaskB.class;
                    ExceptionInfo exceptionInfo = new ExceptionInfo();
                    String info = exceptionInfo.getInfo(e, taskBClass);
                    System.out.println(info);
                }
            } else {
                break;
            }
        }
    }
}
