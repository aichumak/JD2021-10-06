package by.it.ithoitan.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String personamber = scanner.nextLine();
        String person1 = scanner.next();
        String person2 = scanner.next();
        String person3 = scanner.next();
        String sal1 = scanner.nextLine();
        int[] arr1;
        arr1 = stringLineToIntArray(sal1);



    }

    public static int[] stringLineToIntArray(String line) {
        String[] elemString = line.split("");
        int[] mas = new int[elemString.length];
        for (int i = 0; i < elemString.length; i++) {
            mas[i] = Integer.parseInt(elemString[i]);

        }
        return mas;
    }


}
