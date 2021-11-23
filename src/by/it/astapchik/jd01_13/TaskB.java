package by.it.astapchik.jd01_13;

import by.it.chumak.jd01_13.ExceptionsInfo;

import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.Double.NaN;


class TaskB {

    private static final String STOP = "END";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Double> numbers = new ArrayList<>();

        for( ; ; ){
            String userInput = input.nextLine();
            if (userInput.equals(STOP)){
                break;
            } else {
                try {
                    double n = Double.parseDouble(userInput);
                    numbers.add(n);

                    double sum = 0;

                    for (Double number : numbers) {
                        sum += number;
                    }
                    if (sum < 0){
                        throw new ArithmeticException();
                    }
                    double findSqrt = Math.sqrt(sum);

                    if (findSqrt < 0){
                        throw new ArithmeticException();
                    }

                    System.out.println("sum " + sum);
                    System.out.println("findSqrt " + findSqrt);

                } catch (NumberFormatException | ArithmeticException e) {
                    Class<TaskB> currentClass = TaskB.class;
                    String currentClassName = currentClass.getName();
                    StackTraceElement[] stackTrace = e.getStackTrace();
                    for (StackTraceElement stackTraceElement : stackTrace) {
                        String className = stackTraceElement.getClassName();
                        if (className.equals(currentClassName)){
                            Class<? extends RuntimeException> aClassException = e.getClass();
                            String nameException = aClassException.getName();
                            int lineNumber = stackTraceElement.getLineNumber();
                            System.out.printf(" name: %s%n class: %s%n line: %d%n",
                                    nameException, currentClassName, lineNumber
                            );
                        }
                    }
                }
            }
        }
    }
}
