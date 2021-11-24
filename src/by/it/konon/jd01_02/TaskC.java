package by.it.konon.jd01_02;


import java.util.Scanner;

public class TaskC {

    public static void main(String[] args) {
        System.out.println("Введите размер массива: ");
        int n = new Scanner(System.in).nextInt();
        int m = new Scanner(System.in).nextInt();
        int[][] arr = new int[n][m];
        System.out.println(arr.length);


        step1(n);
        step2(arr);
        step3(arr);
    }


    private static int[][] step1(int n) {
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
                arr[i][i] = (int) ((Math.random() * n) - (n / 2));

                    System.out.println(arr[i][i]);
                    break;
                }



        return arr;
        }







    private static int step2(int[][] arr) {


        return -1;
    }


    private static int[][] step3(int[][] arr) {
        int max = Integer.MIN_VALUE;
        for (int[] row : arr){
            for (int element :row){
                if( element>max){
                    max =element;
                }
            }
        }
        boolean [] delRow = new boolean[arr.length];
        boolean [] delCol = new boolean[arr[0].length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == max){
                    delRow[i] = true;
                    delCol[j] = true;
                }
            }
            
        }
        int countRowResult = 0;
        int countColResult = 0;

        for (boolean p : delCol){
            if(!p){
                countColResult++;
            }
        }
        for (boolean p: delRow){
            if(!p){
                countRowResult++;
            }
        }
        int[][] result = new int[countRowResult][countColResult];
        for (int i = 0,  ir = 0; i < arr.length; i++) {
            if(!delCol[i]){
                for (int j = 0, jr = 0; j < arr[i].length; j++) {
                    if(!delCol[j]){
                        result[ir][jr++] = arr[i][j];

                    }
                }
                ir++;
            }

        }


        return result;
    }

}





