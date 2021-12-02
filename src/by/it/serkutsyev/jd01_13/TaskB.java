package by.it.serkutsyev.jd01_13;

import java.util.*;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        List<String> numbers;
        Scanner scanner = new Scanner(System.in);
        StringJoiner stringJoiner = new StringJoiner(" ");
        for (; ; ) {
            String numberAsString = scanner.next();
            if (numberAsString.equals("END")) {
                break;
            }

            stringJoiner.add(numberAsString);
        }

        numbers = Arrays.asList(stringJoiner.toString().split(" "));

     try {
         double sum = 0;

         double numberAsDouble = 0;
         for (String number : numbers) {
             numberAsDouble = Double.parseDouble(number);
             sum = sum + numberAsDouble;
             double sqrtFromSum = sqrt(sum);
             if (Double.isNaN(sqrtFromSum)){
                 throw new ArithmeticException();
             }
             System.out.println(numberAsDouble);
             System.out.println(sqrtFromSum);
         }

     }
     catch (NumberFormatException | ArithmeticException e) {
         Class<TaskB> taskBClass = TaskB.class;
         String name = taskBClass.getName();

         StackTraceElement[] stackTrace = e.getStackTrace();
         for (StackTraceElement stackTraceElement : stackTrace) {
             String className = stackTraceElement.getClassName();
             if (className.equals(name)) {
                 Class<? extends RuntimeException> aClass = e.getClass();
                 String exceptionName = aClass.getName();
                 System.out.println("name:" + exceptionName);
                 int lineNumber = stackTraceElement.getLineNumber();
                 System.out.println("class:" + name);
                 System.out.println("line:" + lineNumber);
                 break;
             }

         }
     }

    }
}
