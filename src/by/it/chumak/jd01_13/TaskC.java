package by.it.chumak.jd01_13;

import java.util.*;

public class TaskC {
    static Stack<Double> doubleStack = new Stack<>();
    static Scanner sc;

    public static void main(String[] args) throws InterruptedException {
        sc = new Scanner(System.in);
        readData();
    }

    static void readData() throws InterruptedException {
        int countErrors = 0;
        String inputText;

        while (countErrors < 6) {
            inputText = sc.next();
            List<String> arrayList = List.of(inputText.split(" "));
            for (String element : arrayList) {
                if (countErrors == 5) {
                    throw new RuntimeException("incorrect input");
                }
                try {
                    doubleStack.add(Double.valueOf(element));
                } catch (NumberFormatException | NoSuchElementException | IllegalStateException e) {
                    sleep();
                    countErrors++;
                    printException();
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    private static void printException() {
        StringJoiner stringJoiner = new StringJoiner(" ");
        Stack<Double> bufferStack = (Stack<Double>) doubleStack.clone();
        bufferStack.sort(Collections.reverseOrder());

        for (Double aDouble : bufferStack) {
            stringJoiner.add(aDouble.toString());
        }
        System.out.println(stringJoiner);
    }

    private static void sleep() throws InterruptedException {
        Thread.sleep(100);
    }
}
