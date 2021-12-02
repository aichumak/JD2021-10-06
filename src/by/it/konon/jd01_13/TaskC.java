package by.it.konon.jd01_13;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class TaskC {
    static Scanner scanner;

    public static void main(String[] args) throws InterruptedException {
        scanner = new Scanner(System.in);
        readData();

    }

    @SuppressWarnings("BusyWait")
    static void readData() throws InterruptedException {
        ArrayList<Double> list = new ArrayList<>();
        int count = 0;
        for (; ; ) {
            String s = scanner.nextLine();
            if (s.equals("end")) {
                break;
            } else {
                try {
                    double number = Double.parseDouble(s);
                    list.add(number);
                } catch (NumberFormatException e) {
                    sleep(100);
                    count++;

                    for (int i = list.size() - 1; i >= 0; i--) {
                        System.out.print(list.get(i) + " ");

                    }

                    if (count == 5) {
                        throw e;
                    }

                }
            }
        }
    }
}