package by.it.chumak.jd01_05;

import java.util.Arrays;

import static java.lang.Math.*;

public class TaskC {
    public static void main(String[] args) {
        step1();
    }

    private static void step1() {
        int a = 20;
        int b = 40;
        int randomNumber = a + (int) (random() * (b - a));
        int arrayZIndex = 0;
        int arrayLengthOrIndex = 0;
        double deltaX = (9 - 5.33) / randomNumber;
        double[] arrayZ = new double[randomNumber + 1];
        double[] arrayNew;
        double averageGeometricValue;
        double estimatedAmount = 1;

        for (double x = 5.33; x <= 9; x += deltaX) {
            arrayZ[arrayZIndex] = cbrt(pow(x, 2) + 4.5);
            if (arrayZ[arrayZIndex] > 3.5) {
                arrayLengthOrIndex += 1;
            }
            arrayZIndex++;
        }

        System.out.println("Массив A[]");
        printArray(arrayZ, "A", 5);

        arrayNew = new double[arrayLengthOrIndex];
        arrayLengthOrIndex = 0;

        for (int i = 0; i < arrayZ.length; i++) {
            if (arrayZ[i] > 3.5) {
                arrayNew[arrayLengthOrIndex] = arrayZ[i];
                arrayLengthOrIndex += 1;
                estimatedAmount = estimatedAmount * arrayZ[i];
            }
        }
        System.out.println("Массив B[] из элементов массива A > 3.5");
        averageGeometricValue = pow(estimatedAmount, 1.0 / arrayNew.length);
        printArray(arrayNew, "A", 5);
        System.out.printf("Среднее геометрическое значение = %f\n", averageGeometricValue);
    }

    public static void printArray(double[] arrayDoubleNumbers, String name, int columnCount) {
        for (int i = 0; i < arrayDoubleNumbers.length; i++) {
            System.out.printf("%s[%- 3d]= %-10.5f", name, i, arrayDoubleNumbers[i]);
            if ((i + 1) % columnCount == 0 || i == arrayDoubleNumbers.length - 1) {
                System.out.println();
            }
        }
    }
}
