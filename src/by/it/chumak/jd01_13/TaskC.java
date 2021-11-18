package by.it.chumak.jd01_13;

import java.util.*;

public class TaskC {
    static Stack<Double> doubleStack = new Stack<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int countErrors = 0;
        readData();


    }

    static void readData() {
        int countErrors = 0;

        while (countErrors < 6) {
            try {
                String text = sc.nextLine();
                List<String> arrayList = List.of(text.split(" "));
                for (String element : arrayList) {
                    try {
                        doubleStack.add(Double.valueOf(element));
                    } catch (NumberFormatException e) {
                        throw e;
                    }
                }
                //readData();
            } catch (InputMismatchException | NullPointerException | NumberFormatException e) {

                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                countErrors++;
                StringJoiner stringJoiner = new StringJoiner(" ");
                Stack<Double> bufferStack = (Stack<Double>) doubleStack.clone();
                bufferStack.sort(Collections.reverseOrder());
                Iterator<Double> iterator = bufferStack.iterator();
                while (iterator.hasNext()) {
                    stringJoiner.add(iterator.next().toString());
                }
                System.out.println(stringJoiner);

                if (countErrors == 5) {
                    throw new Exception;
                }
            }
        }
    }
}
