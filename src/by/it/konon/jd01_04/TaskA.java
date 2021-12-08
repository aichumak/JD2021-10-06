package by.it.konon.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskA {


    static void printMulTable() {

        for (int i = 2; i <= 9; i++) {
            int count = 0;
            for (int j = 2; j <= 9; j++) {
                count++;
                System.out.printf("%d*%d=%-3d", i, j, i * j);
                if (count % 8 == 0) {
                    System.out.println();

                }
            }

        }


    }

    static void buildOneDimArray(String line) {
        double [] array = InOut.getArray(line);
        double firstIndex = array[0];
        double lastIndex = array[array.length-1];
        InOut.printArray(array,"V",5);
        Arrays.sort(array);
        System.out.println();
        InOut.printArray(array,"V",4);
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == firstIndex){
                System.out.println("Index of first element=" + i);
                break;
            }
        }
        for (int i = 0; i < array.length; i++) {
            if(array[i] == lastIndex){
                System.out.println("Index of last element=" + i);
                break;
            }

        }

    }







    public static void main(String[] args) {


        printMulTable();
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        buildOneDimArray(string);


    }

}


