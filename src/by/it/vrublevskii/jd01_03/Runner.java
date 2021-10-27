package by.it.vrublevskii.jd01_03;

import java.util.Scanner;

class Runner {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        System.out.println("Ввести одномерный массив:");
        String inputLine = sc.nextLine();

        double[] array = InOut.getArray(inputLine);

        System.out.println("Введённый массив:");
        InOut.printArray(array);

        System.out.println("Введённый массив с именем, в 5 колонок:");
        InOut.printArray(array, "A", 5);

        System.out.printf("Array min: %.2f\n", Helper.findMin(array));
        System.out.printf("Array max: %.2f\n", Helper.findMax(array));
        Helper.sort(array);

        double[][] matrix = InOut.getMatrix(2);
        System.out.println("Vector:");
        String inputVector = sc.nextLine();
        double[] vector = InOut.getArray(inputVector);

        Helper.multiply(matrix, vector);


        double[][] twoStringMatrix = InOut.getMatrix(2);
        double[][] threeStringMatrix = InOut.getMatrix(3);

        Helper.multiply(twoStringMatrix, threeStringMatrix);

    }


}
