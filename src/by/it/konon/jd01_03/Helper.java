package by.it.konon.jd01_03;

public class Helper {
    static double findMin(double[] array) {
        double min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }


        }
        return min;
    }

    static double findMax(double[] array) {
        double max = array[0];
        for(int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    static void sort(double[] array) {
        boolean sort = false;
        double place= 0;
        while(!sort){
            sort = true;
            for (int i = 0; i < array.length-1; i++) {
                if(array[i]>array[i+1]){
                    place = array[i];
                    array[i]=array[i+1];
                    array[i+1]=place;
                    sort = false;
                }
            }
        }


    }


}

