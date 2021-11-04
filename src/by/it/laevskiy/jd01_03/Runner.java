package by.it.laevskiy.jd01_03;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        double[] array = InOut.getArray(string);
        InOut.printArray(array);
        InOut.printArray(array, "V", 3);
        Helper.findMax(array);
        Helper.findMin(array);
        Helper.sort(array);


    }
}
