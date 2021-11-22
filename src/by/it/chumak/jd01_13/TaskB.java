package by.it.chumak.jd01_13;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> arrayList;
        StringJoiner stringJoiner = new StringJoiner(" ");
        String line;

        for (; ; ) {
            line = sc.next();
            if (line.equals("END")) {
                break;
            } else {
                stringJoiner.add(line);
            }
        }

        arrayList = Arrays.asList(stringJoiner.toString().split(" "));

        try {
            processAndPrintResult(arrayList);
        } catch (NullPointerException | NumberFormatException | ArithmeticException e) {
            ExceptionsInfo exceptionsInfo = new ExceptionsInfo();
            System.out.println(exceptionsInfo.getExceptionInfo(e, TaskB.class.getName()));
        }
    }

    private static void processAndPrintResult(List<String> arrayList) {
        double sumNumbers = 0;
        double sqrtNumber;

        for (String element : arrayList) {
            double value = Double.parseDouble(element);
            if (Double.isNaN(sqrtNumber = Math.sqrt(sumNumbers+=value))) {
                throw new ArithmeticException();
            }
            System.out.println(value);
            System.out.println(sqrtNumber);
        }
    }
}
