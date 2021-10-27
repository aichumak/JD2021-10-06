package by.it.brutski.jd01_03;

import java.util.Arrays;
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        double [] array = InOut.getArray(line);
        System.out.println(Arrays.toString(array));

        InOut.printArray(array);
        InOut.printArray(array, "name", 4);

        double min = Helper.findMin(array);
        System.out.println(min);

        double max = Helper.findMax(array);
        System.out.println(max);

        Helper.sort(array);

        double[][] matrix = {{1, -5, -8, 2, 3}, {9, 6, 8, 48, 8}};
        double[] vector = {5, 2, 5, 5, 5};
        double[] matrix_vector = Helper.multiply(matrix, vector);

        double[][] matrixLeft = {{1, 2, 3}, {-9, -0.5, -7}};
        double[][] matrixRight = {{-9, 0.25, 48}, {-4, 78, 15}};
        double[ ][ ] matrixLeft_Right = Helper.multiply(matrixLeft, matrixRight);

    }
}
