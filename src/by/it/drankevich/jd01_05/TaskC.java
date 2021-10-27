package by.it.drankevich.jd01_05;

import static java.lang.Math.pow;
import static java.lang.Math.random;

public class TaskC {
    public static void main(String[] args) {
       task6();
        
    }

    private static void task6() {
        int n=(int)(random()*21+20);
        double[] array=new double[n];
        double a=(9-5.33)/(n-1);
        double x=5.33;
        System.out.printf("Массив A[]%n");
        for (int i = 0; i < array.length; i++) {
            array[i]=(double)pow(x*x+4.5,1/3.0);
            x=x+a;
            System.out.printf("A[ %2d ] = %.5f  ", i, array[i]);
            if((i+1)%5==0||i==array.length-1) {
                System.out.println();}
        }
        System.out.println("Массив B[] из элементов массива A > 3.5");
        int c=0;
        for (int i = 0; i <array.length ; i++) {
            if (array[i] > 3.5) {
                c = c + 1;
            }
        }
            double[]arrayB=new double[c];
            for (int j = 0, i=0; j <arrayB.length ; j++) {

                if(array[i]>3.5){
                    arrayB[j]=array[i];}
                else {
                    do{ i=i+1;}
                    while (array[i]<3.5);
                    arrayB[j]=array[i];}
                i=i+1;

                System.out.printf("B[ %2d ] = %.5f  ", j, arrayB[j]);
                if((j+1)%5==0||j==arrayB.length-1) {
                    System.out.println();}
            }
            double y=1;
        for (int i = 0; i < arrayB.length; i++) {
            y=y*arrayB[i];}
        double z=pow(y,1.0/arrayB.length);
        System.out.printf("Среднее геометрическое = %f", z);

            }

        }





