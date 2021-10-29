package by.it.kanaplianik.jd01_03;

import java.util.Arrays;

public class Runner {
    public static void main (String[] args) {
        String line = "1 2 6 9 12 4";
        double[] vector = {2, 3, 7};
        double[] array = InOut.getArray(line);
        InOut.printArray(array);
        InOut.printArray(array, "LastArray", 3);
        Helper.findMin (array);
        Helper.findMax (array);
        Helper.sort(array);
        double[] result = Helper.multiply(
            new double[][] {
                {2, 4, 5},
                {3, 4, 5}
            }, vector);
        InOut.printArray(result);

        System.out.println(Arrays.toString(array));
    }
}
