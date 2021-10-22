package by.it.chumak.jd01_05;

import java.util.Arrays;

import static java.lang.Math.*;

public class TaskC {
    public static void main(String[] args) {
        step1();
        step2();
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

    private static void step2() {
        int[] arrayA = new int[31];
        int[] arrayB;
        int a = 103;
        int b = 450;
        int arrayLengthOrIndex = 0;
        boolean indexToCols = false;

        for (int i = 0; i < arrayA.length; i++) {
            arrayA[i] = a + (int) (random() * (b - a));
            if ((arrayA[i] * 0.1) > i) {
                arrayLengthOrIndex = arrayLengthOrIndex + 1;
            }
        }

        arrayB = new int[arrayLengthOrIndex];
        arrayLengthOrIndex = 0;
        for (int i = 0; i < arrayA.length; i++) {
            if ((arrayA[i] * 0.1) > i) {
                arrayB[arrayLengthOrIndex] = arrayA[i];
                arrayLengthOrIndex = arrayLengthOrIndex + 1;
            }
        }
        Arrays.sort(arrayB);
        printTable(arrayA, "Array A (index to rows)", indexToCols);
        indexToCols = true;
        printTable(arrayB, "Array B (index to cols)", indexToCols);
    }

    public static void printArray(double[] arrayDoubleNumbers, String name, int columnCount) {
        for (int i = 0; i < arrayDoubleNumbers.length; i++) {
            System.out.printf("%s[%- 3d]= %-10.5f", name, i, arrayDoubleNumbers[i]);
            if ((i + 1) % columnCount == 0 || i == arrayDoubleNumbers.length - 1) {
                System.out.println();
            }
        }
    }

    private static void printTable(int[] array, String tableHeader, boolean indexToCols) {
        int countColumns = array.length < 5 ? array.length : 5;
        int countRows = (int) ceil((double) array.length / countColumns);
        boolean repeat = indexToCols;
        int tempCountColumns;

        System.out.println(tableHeader);
        printTopLine(countColumns);

        if (indexToCols) {
            for (int j = 0; j <= countRows - 1; j++) {
                tempCountColumns = 1;
                for (int i = j; i < array.length; i += countRows) {
                    System.out.print(String.format("║ A[%3d]=%d ", i, array[i]));
                    if (i + countRows > array.length - 1 && tempCountColumns != countColumns) {
                        System.out.print(String.format("║            ", i, array[i]));
                    }
                    if (tempCountColumns == countColumns) {
                        break;
                    } else {
                        tempCountColumns++;
                    }
                }
                System.out.print("║\n");

                if (j == countRows - 1) {
                    printBottomLine(countColumns);
                } else {
                    printMiddleLine(countColumns);
                }
            }
        } else {
            for (int i = 0; i < array.length; i++) {
                if ((i + 1) % countColumns == 0 && i != array.length - 1) {
                    System.out.print(String.format("║ A[%3d]=%d ║\n", i, array[i]));
                    printMiddleLine(countColumns);
                } else {
                    System.out.print(String.format("║ A[%3d]=%d ", i, array[i]));
                }
                if (i == array.length - 1) {
                    printEmptyLines(countColumns * countRows - array.length);
                    printBottomLine(countColumns);
                }
            }
        }
    }

    private static void printTopLine(int countColumns) {
        StringBuffer finalLine = new StringBuffer("╔════════════╗");
        String bufferLine = "";
        for (int i = 1; i < countColumns; i++) {
            bufferLine += "════════════╦";
        }
        finalLine.insert(1, bufferLine);
        System.out.println(finalLine);
    }

    private static void printMiddleLine(int countColumns) {
        StringBuffer finalLine = new StringBuffer("╠════════════╣");
        String bufferLine = "";
        for (int i = 1; i < countColumns; i++) {
            bufferLine += "════════════╬";
        }
        finalLine.insert(1, bufferLine);
        System.out.println(finalLine);
    }

    private static void printBottomLine(int countColumns) {
        StringBuffer finalLine = new StringBuffer("╚════════════╝");
        String bufferLine = "";
        for (int i = 1; i < countColumns; i++) {
            bufferLine += "════════════╩";
        }
        finalLine.insert(1, bufferLine);
        System.out.println(finalLine);
    }

    private static void printEmptyLines(int countColumns) {
        for (int i = 1; i <= countColumns; i++) {
            if (i == countColumns) {
                System.out.print("║            ║\n");
            } else {
                System.out.print("║            ");
            }
        }
    }
}
