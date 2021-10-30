package by.it.astapchik.jd01_03;

import java.util.Arrays;
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        double[] array = InOut.getArray(line);

        InOut.printArray(array);
        InOut.printArray(array, "A",  5);

        Helper.findMin(array);
        Helper.findMax(array);
        Helper.sort(array);

        double[ ][ ] matrix = { {1,2}, {3,4}};
        double[ ] vector = {5,6};
        double[] vectorResult = Helper.multiply(matrix, vector);
        System.out.println(Arrays.toString(vectorResult));

        double[ ][ ] matrixLeft = { {2,3}, {5,4}};
        double[ ][ ] matrixRight = { {1,2}, {4,3}};
        double[ ][ ] matrixResult = Helper.multiply(matrixLeft, matrixRight);
        System.out.println(Arrays.deepToString(matrixResult));

    }

}