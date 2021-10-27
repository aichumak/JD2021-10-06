package by.it.kanaplianik.jd01_05;

import static java.lang.Math.cbrt;
import static java.lang.Math.pow;

public class TaskC {
    public static void main (String[] args) {
        step6();
    }

    private static void step6() {
        int columnCount = 3;
        double[] arrayZ = new double[40];
        double z = 0;//new length
        double[] arrayB = new double[40];
        int j = 0;
        int h = 0; //new length for B array
        int f = 0;
        String arrayZNameA = new String("Массив А");
        String arrayZNameB = new String("Массив Б");
        for (double x = 5.33; x <=9 ; x+=0.131071429) {
            z=cbrt(pow(x,2)+4.5);
            arrayZ [j] = z;
            j++;
            }
        for (int i = 0; i < j; i++) {
            if (i % columnCount == 0)
                System.out.println();
            System.out.printf("%s[%2d]=%-10.5f ", arrayZNameA, i, arrayZ[i]);
        }
        System.out.println();
        for (int i = 0; i < arrayZ.length; i++) {
            if (arrayZ[i] > 3.5){
                arrayB[h] = arrayZ[i];
                h++;
            }
        }
        for (f = 0; f < h; f++) {
            if (f % columnCount == 0)
                System.out.println();
            System.out.printf("%s[%2d]=%-10.5f ", arrayZNameB, f, arrayB[f]);

        }
        double sum = 1;
        double geometric = 0;
        for (int i = 0; i < h; i++) {
            sum = sum*arrayB[i];

        }
        geometric = pow(sum,1.0/h);
        System.out.println("Среднее геометрическое равно " + geometric);

      /*  for (double h = 3.5; h < arrayZ.length; h++) {
            if (h % columnCount == 0)
                System.out.println();
            System.out.printf("%s[%2d]=%-10.4f ", arrayZNameA, h, arrayZ[h]);
        }

            /*
if (i % columnCount == 0)
                System.out.println();
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%s[%- 3d]=%-10.4f ", name, i, array[i]);
        }
        System.out.println();
             */
        }
    }
