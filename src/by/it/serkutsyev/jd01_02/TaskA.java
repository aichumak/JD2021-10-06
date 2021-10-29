package by.it.serkutsyev.jd01_02;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = new int[10];
        //   for (int x : array) {
        //    array[x] = sc.nextInt();

        for (int i = 0; i < 10; i++) {
            arr[i] = sc.nextInt();
        }

        // for (int i = 0; i < 10; i++) {
        //     System.out.println(" " + arr[i]);

        //  }

        step1(arr);
        step2(arr);
        step3(arr);


    }


    static void step1(int[] arr) {

        int minimal = arr[0];

        for (int i : arr) {
            if (minimal > i) {
                minimal = i;
            }

        }
        System.out.print(minimal + " ");


        int largest = arr[0];

        for (int i : arr) {

            //  } (int i = 0; i < 10; i++) ;
            // {
            if (largest < i) {
                largest = i;
            }
        }

        System.out.println(largest);

        // int largest1 = arr[0];

        //  for (int i: arr) {
        //     if (largest1 > i) {
        //         largest1 = i;
        //    }

        //}
        //       System.out.println("Наименьшее значение " + largest1);
    }

    private static void step2(int[] arr) {

        double sum = 0;

        for (int i : arr) {

            sum = sum + i;

        }
        double arifmetic = (sum / arr.length);

        //System.out.println(sum);
        System.out.println(arifmetic);


        for (int i : arr) {
            if (i < arifmetic) {
                System.out.print(i + " ");

            }
        }
        System.out.println(" ");
    }


    private static void step3(int[] arr) {

        //  int arrMin[] = new int[10];

        int minimal1 = arr[0];

        int indexMin = 0;

        int indexMin1 = arr[0];

        for (int i : arr) {
            if (minimal1 > i) {
                minimal1 = i;

            }

        }

        for (int i = arr.length - 1; i >= 0  ; i--) {
            if (minimal1 == arr[i]) {
                indexMin = i;
                indexMin1 = arr[i];
                System.out.print(indexMin + " ");
           //     System.out.println(indexMin1);
                //         Arrays.copyOfRange(arrMin)
            }
        }
        // System.out.print(arrMin);

    }

    //    System.out.println(index);
    //}

}
