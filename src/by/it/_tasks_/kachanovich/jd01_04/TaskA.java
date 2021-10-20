package by.it._tasks_.kachanovich.jd01_04;

import java.util.Scanner;

class TaskA {
    static void printMulTable(){
        for (int i = 0; i <=9 ; i++) {
            for (int j = 0; j <=9 ; j++) {
                System.out.printf("%1d*%1d=%-3d", i,j,(i*j));
            }
        }
    }


    static void buildOneDimArray(String line){
        double[] array = InOut.getArray(line);
        double first = array[0];
        double last = array[array.length-1];
        InOut.printArray(array, "V", 5);
        array = Helper.sort(array);
        InOut.printArray(array, "V", 4);
        for (int i = 0; i < array.length; i++) {
            if (array[i] ==first){
                System.out.printf("Index of first element=%1d",i);
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] ==last){
                System.out.printf("Index of last element=%1d",i);
            }
        }
    }

    public static void main(String[] args) {
        printMulTable();
        Scanner scanner  = new Scanner(System.in);
        String line = scanner.nextLine();
        buildOneDimArray(line);
    }
}
