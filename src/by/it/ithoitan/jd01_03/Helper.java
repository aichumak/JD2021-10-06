package by.it.ithoitan.jd01_03;


public class Helper {
    public static double findMin(double[] array) {
        double min = array[0];
        for (double element : array) {
            if (min > element) min = element;
        }
        System.out.println(min + " ");
        return min;
    }

    public static double findMax(double[] array) {
        double max = array[0];
        for (double element : array) {
            if (max < element) max = element;
        }
        System.out.println(max + " ");
        return max;
    }

    public static void sort(double[] array) {
        for (int start = 0; start < array.length; start++) {
            int least = start;
            for (int j = start + 1; j < array.length; j++) {
                if ((array[j] < array[least]) || (!(array[j] > array[least]))) {

                    least = j;
                }
            }

            double tmp = array[start];
            array[start] = array[least];
            array[least] = tmp;
        }


    }


}


