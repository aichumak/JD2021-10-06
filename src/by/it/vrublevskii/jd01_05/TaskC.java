package by.it.vrublevskii.jd01_05;

import java.util.Arrays;

import static java.lang.Math.*;

public class TaskC {
    public static void main(String[] args) {
        double[] array = getArray();
        getNewArray(array);
    }

    static double[] getArray() {
        int i = (int)(random()*21)+20;
        double[] array = new double[i];
        double deltaX = (9-5.33)/(i-1);
        System.out.println("Массив A[]");
        for (int j = 0; j < i; j++) {
            double x = 5.33 + deltaX * j;
            array[j] = cbrt(pow(x, 2) + 4.5);
            System.out.printf("A[%- 3d] = %.5f    ", j, array[j]);
            if((j + 1) % 5 == 0){
                System.out.println();
            }
        }
        System.out.println();
        System.out.println();
        return array;
    }

    static void getNewArray(double[] array) {
        array[0] = 3.5;
        Arrays.sort(array);
        int i = Arrays.binarySearch(array,3.5);
        if(array[i] == array[i+1]){
            i++;
        }
        int newArrayLength = array.length - i - 1;
        double[] newArray = new double[newArrayLength];
        System.out.println("Массив B[] из элементов массива A > 3.5");
        for (int j = 0; j < newArrayLength; j++) {
            newArray[j] = array[j+i+1];
            System.out.printf("B[%- 3d] = %.5f    ", j, newArray[j]);
            if((j + 1) % 5 == 0){
                System.out.println();
            }
        }
    }
}
