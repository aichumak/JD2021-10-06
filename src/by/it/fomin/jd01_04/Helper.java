package by.it.fomin.jd01_04;

class Helper {

    static double findMin(double[] array) {
        double min = 0;
        for (int i = 0; i < array.length - 1; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        System.out.println("Min = " + min);
        return min;
    }

    static double findMax(double[] array) {
        double max = 0;
        for (int i = 0; i < array.length - 1; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        System.out.println("Max = " + max);
        return max;
    }

    static void sort(double[] array) {
        double tmp;
        int out;
        for (out = array.length - 1; out >= 1; out--) {  //Внешний цикл
            for (int in = 0; in < out; in++) {       //Внутренний цикл
                if (array[in] > array[in + 1]) {
                    tmp = array[in];
                    array[in] = array[in + 1];
                    array[in + 1] = tmp;
                }
            }
        }
        System.out.println(array + " ");
        }

//      static double[] multiply(double[][] array, double[] vector) {
//        ..   if (array.length [0] == vector.length || array.length == vector.length) {
//        }//  проверка длины вектора на совпадение с количством строк или столбцов
//        double[] resultArray = new double[vector.length];
//            for (int i = 0; i < array.length - 1; i++) {
//                double sum = 0;
//                for (int j = 0; j < array.length - 1; j++) {
//                    sum += array[i][j] * vector[j];
//                }
//                resultArray[i] = sum;
//            }

 //       System.out.println ("Длина вектора не равна количеству столбцов/строк. Умножение невозможно");
   //     return resultArray;
    //}

}
