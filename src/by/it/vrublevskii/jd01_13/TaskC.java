package by.it.vrublevskii.jd01_13;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskC {

    static Scanner sc;

    public static void main(String[] args) throws InterruptedException {
        sc = new Scanner(System.in);
        readData();
    }

    static void readData() throws InterruptedException {
        ArrayList<Double> inputs = new ArrayList<>();
        for (int i = 0; i < 4; ) {
            try {
                inputDouble(inputs);
            } catch (NumberFormatException e) {
                Thread.sleep(100);
                i++;
                for (int j = inputs.size() - 1; j >= 0; j--) {
                    System.out.print(inputs.get(j) + " ");
                }
                System.out.println();
            }
        }
        inputDouble(inputs);
    }

    private static void inputDouble(ArrayList<Double> inputs) {
        String stringElement = sc.next();
        double element = Double.parseDouble(stringElement);
        inputs.add(element);
    }
}
