package by.it.brutski.jd01_02;
import java.util.Random;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];

        arr = step1(n);
        int sum = step2(arr);
    }

    static int[][] step1(int n){
        Random random = new Random();
        int[][] array = new int[n][n];
        boolean flag_n = false;
        boolean flag_mn = false;

        while (!flag_n || !flag_mn){
            flag_n = false;
            flag_mn = false;

            for(int i = 0; i < array.length; i++){
                for(int j = 0; j < array.length; j++){
                    array[i][j] = (int) (Math.random() * (2 * n + 2) - n - 1);

                    if(array[i][j] == n){
                        flag_n = true;
                    }
                    if(array[i][j] == (-1) * n){
                        flag_mn = true;
                    }
                }
            }
        }

        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array.length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.print("\n");
        }
        return array;
    }

    static int step2(int[][] arr){
        boolean flag = false;
        int sum_m = 0;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum = 0;
            flag = false;
            for (int j = 0; j < arr[0].length; j++) {
                if (flag == true && arr[i][j] > 0) {
                    flag = false;
                    break;
                }
                if (arr[i][j] > 0) {
                    flag = true;
                }
                if (flag == true && arr[i][j] < 0) {
                    sum = sum + arr[i][j];
                }
            }
            if (flag == true) {
                sum = 0;
            }
            sum_m = sum_m + sum;
        }

        System.out.println(sum_m);
        return sum_m;
    }
}
