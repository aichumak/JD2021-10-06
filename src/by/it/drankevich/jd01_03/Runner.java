package by.it.drankevich.jd01_03;


import java.util.Arrays;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        double[] array = InOut.getArray(line);
        InOut.printArray(array);
        InOut.printArray(array,"V",3);
        Helper.findMin(array);
        Helper.findMax(array);
        Helper.sort(array);
        Helper.sortbubble(array);
        System.out.println(Arrays.toString(array));
        double[][]matrixL={{3,4},
                          {1,2}};
        double[]vector={4,5};
        double[][]matrixR={{3,4},
                           {5,7}};
        Helper.multiply(matrixL,vector);
        Helper.multiply(matrixL, matrixR);

        }


    }


