package by.it.konon.jd01_05;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        step1();

    }

    private static void step1() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double[] array = new double[n];
        if (n < 20 && n > 40) {
            System.out.println("Неверный размер массива");
        } else if (n >= 20 && n <= 40) {
            int count = 0;
            int length = 0;

            double step = (9 - 5.33) / n;

            int i = 0;

            array[0] = Math.pow((5.53 * 5.53 + 4.5), 1 / 3.0);
            for (double x = 5.53; x <= 9; x += step) {
                i++;
                array[i] = Math.pow((x * x + 4.5), 1 / 3.0);
                System.out.println(x);

            }
            for (int k = 0; k < array.length; k++) {
                if (array[k] < 3.5) {
                    count++;
                }
                System.out.println(k + " = " + array[k]);
            }
            double[] array2 = new double[count];


        }
    }
}









