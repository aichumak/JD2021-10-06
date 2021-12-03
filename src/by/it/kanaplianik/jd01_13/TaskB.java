package by.it.kanaplianik.jd01_13;

import java.util.Scanner;

import static java.lang.Double.parseDouble;
import static java.lang.Math.sqrt;

public class TaskB {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            String string = null;
            double sumNumbers = 0;
            do {
                string = scanner.nextLine();
                if (!string.equals("END")) {
                    double numbers = parseDouble(string);
                    System.out.println(numbers);
                    sumNumbers += numbers;
                    if (sumNumbers >= 0) {
                        System.out.println(sqrt(sumNumbers));
                    } else {
                        throw new ArithmeticException();
                    }
                }
            }
            while (!string.equals("END"));

        } catch (ArithmeticException e) {
            printException(e);
        } catch (NumberFormatException e) {
            printException(e);
        }
    }

    public static void printException(Exception e) {
        System.out.printf("name: %s\nclass: %s\nline: %d\n", getExceptionName(e), getExceptionClass(e), getLineNumber(e));
    }

    public static String getExceptionName(Exception ex) {
        return ex.getClass().getName();
    }

    public static String getExceptionClass(Exception ex) {
        for (StackTraceElement stackTraceElement : ex.getStackTrace()) {
            if (stackTraceElement.getClassName().equals(TaskB.class.getName())) {
                return stackTraceElement.getClassName();
            }
        }
        return "undefined";
    }

    public static int getLineNumber(Exception ex) {
        for (StackTraceElement stackTraceElement : ex.getStackTrace()) {
            if (stackTraceElement.getClassName().equals(TaskB.class.getName())) {
                return stackTraceElement.getLineNumber();
            }
        }
        return -1;
    }
}
