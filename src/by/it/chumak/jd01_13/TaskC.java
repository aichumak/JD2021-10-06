package by.it.chumak.jd01_13;

import java.util.*;

public class TaskC {
    static Stack<Double> doubleStack = new Stack<>();
    static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        readData();
    }

    static void readData() {
        int countErrors = 0;
        String text = "";

        while (countErrors < 6) {

            try {
                text = sc.next();
            } catch (NoSuchElementException | IllegalStateException ex) {
                countErrors++;
            }

            List<String> arrayList = List.of(text.split(" "));
            for (String element : arrayList) {
                if (countErrors == 5) {
                    throw new RuntimeException("123");
                }
                try {
                    doubleStack.add(Double.valueOf(element));
                } catch (NumberFormatException e) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        //ex.printStackTrace();
                    }
                    countErrors++;
                    StringJoiner stringJoiner = new StringJoiner(" ");
                    Stack<Double> bufferStack = (Stack<Double>) doubleStack.clone();
                    bufferStack.sort(Collections.reverseOrder());
                    for (Double aDouble : bufferStack) {
                        stringJoiner.add(aDouble.toString());
                    }
                    System.out.println(stringJoiner);
                }
            }
        }
    }
}
