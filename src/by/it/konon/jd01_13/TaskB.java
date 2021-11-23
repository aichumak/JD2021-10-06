package by.it.konon.jd01_13;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Double.NaN;

public class TaskB {
    public static void main(String[] args) {
        ArrayList<Double> num = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        for (; ; ) {
            String n = scanner.nextLine();
            if (n.equals("END")) {
                break;
            } else {
                try {
                    Double number = Double.parseDouble(n);
                    num.add(number);


                    Double sum = 0.0;
                    for (Double aDouble : num) {
                        sum += aDouble;
                    }
                    Double sqrt = Math.sqrt(sum);
                    if (sqrt.equals(NaN)) {
                        throw new ArithmeticException();

                    }
                    System.out.println(sqrt);
                } catch (NumberFormatException | ArithmeticException e) {
                    Class<TaskB> currentClass = TaskB.class;
                    String currentClassName = currentClass.getName();
                    StackTraceElement[] stackTrace = e.getStackTrace();
                    for (StackTraceElement stackTraceElement : stackTrace) {
                        String className = stackTraceElement.getClassName();
                        if (className.equals(currentClassName)) {
                            Class<? extends RuntimeException> aClass = e.getClass();
                            String nameException = aClass.getName();
                            int lineNumber = stackTraceElement.getLineNumber();
                            System.out.printf("name: %s%nclass: %s%nline: %d%n", nameException, currentClassName, lineNumber);
                            break;

                        }

                    }


                }


            }
        }
    }
}

