package by.it.ithoitan.jd01_13;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

import static java.lang.Double.NaN;

/**
 * считывает данные из консоли построчно и закрывается при вводе в консоль слова END;
 * 
 * переводит каждую строку в вещественное число и выводит в консоль данное число и корень из суммы всех
 * ранее введенных чисел, включая введенное;
 * 
 * если перевести ввод в число невозможно, то программа перехватывает полученную ошибку и показывает
 * сообщение в консоли сообщение, такого же формата, как в предыдущем задании
 * 
 * если невозможно извлечь корень, то обработка аналогична, но тип ошибки - ArithmeticException
 */
public class TaskB {
    public static void main(String[] args) {
        ArrayList<Double> doubles = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        for (; ; ) {
            String lineString = scanner.nextLine();
            if (lineString.equals("END")) {
                break;
            } else {
                try {
                    double d = Double.parseDouble(lineString);
                    doubles.add(d);
                    double sum = 0;
                    for (Double aDouble : doubles) {
                        sum = sum + aDouble;
                    }
                    double squareRoot;
                    squareRoot = Math.sqrt(sum);
                    System.out.println(sum);
                    if (Objects.equals(squareRoot, NaN)) {
                        throw new ArithmeticException();
                    }
                    System.out.println(squareRoot);
                    System.out.println(d);
                } catch (NumberFormatException | ArithmeticException e) {
                    StackTraceElement[] stackTrace = e.getStackTrace();
                    for (StackTraceElement element : stackTrace) {
                        if (TaskB.class.getName().equals(element.getClassName())) {
                            String name = e.getClass().getName();
                            String className = element.getClassName();
                            int line = element.getLineNumber();
                            System.out.printf("""
                                    name: %s
                                    class: %s
                                    line: %d
                                    """, name, className, line);

                        }
                    }
                }
            }

        }
    }
}
