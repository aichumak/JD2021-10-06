package by.it.fomin.jd01_03;

import java.util.Arrays;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        double[] array = InOut.getArray(line);
        InOut.printArray(array);
        System.out.println(Arrays.toString(array));
        InOut.printArray(array, "A", 5);
        Helper.findMin(array);
        Helper.findMax(array);
        Helper.sort(array);
        double[][] array2D = {
                {1.5, 2.4, 5.9, 6.2},
                {5.6, 6.5, 9.1, 8.7}};
        double[] vector = {5.8, 10.8};

        //Helper.multiply(array2D, vector);
        //      int rows = array2D.length;
        //    int clmns = array2D.length [0];
        //  System.out.println("Rows"+ rows + "Clmns" + clmns);
        //Arrays.binarySearch();

    }
}