package by.it.konon.jd01_03;

import java.util.Scanner;

class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        double[] array = InOut.getArray(string);
        InOut.printArray(array);
        InOut.printArray(array, "V", 3);

        double[] array1 = InOut.getArray(string);
        double arrayMin = Helper.findMin(array1);
        System.out.println(arrayMin);
        double arrayMax = Helper.findMax(array1);
        System.out.println(arrayMax);
        Helper.sort(array1);
        InOut.printArray(array1);



    }


}
