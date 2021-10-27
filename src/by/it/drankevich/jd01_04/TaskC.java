package by.it.drankevich.jd01_04;

import java.util.Arrays;

public class TaskC {
    public static void main(String[] args) {
        String line ="2 4 1 6 5 7 9 8 0";

        buildOneDimArray(line);

    }
    static void buildOneDimArray(String line) {

        double[] array = InOut.getArray(line);
        double first = array[0];
        double last = array[array.length - 1];

        InOut.printArray(array, "V", 5);


        mergeSort(array);


        System.out.println();

        InOut.printArray(array, "V", 4);

        System.out.println();


                System.out.println("Index of first element=" + binarySearch(array,first));

                System.out.println("Index of last element=" + binarySearch(array,last));

            }





    private static int binarySearch(double[] array, double value) {
        int a=0;
        int b=array.length;
        int c=0;
        do{
             c=(a+b)/2;
            if(value>array[c]){
                a=c+1;
            }
            else {
                b=c-1;
            }
        } while (array[c]!=value);
        int index=c;
        return index;


    }


    static void mergeSort(double[] array){
        Arrays.sort(array);
    }


    }

