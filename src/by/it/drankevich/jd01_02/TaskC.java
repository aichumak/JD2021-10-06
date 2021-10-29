package by.it.drankevich.jd01_02;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] arr = step1(n);

        step2(arr);

    }


    private static int[][] step1(int n) {
        int arr[][] = new int[n][n];
        int a = 0;
        int b = 0;
        do {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = (int) (Math.random() * (n + 1 - (-n))) + (-n);
                    if (arr[i][j] == n) {
                        a = n;
                    }
                    if (arr[i][j] == -n) {
                        b = -n;
                    }
                }
            }
        }
        while (a != n | b != -n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        return arr;
    }

    private static int step2(int[][] arr) {
        int sum = 0;
        int sum1=0;
        one:
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] > 0) {
                    for (int k = j + 1; k < arr.length; k++) {
                        if (arr[i][k] < 0) {
                            sum = sum + arr[i][k];
                            if(k== arr.length-1){ sum=sum1; continue one;}
                        } else {sum1=sum; continue one;}
                    }


                }

            }

        }
        System.out.println(sum);
        return sum;
    }
    private static int [][] step3(int[][] arr) {
        int max=arr[0][0];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (max < arr[i][j]) {
                    max=arr[i][j];
                }
            }
        }
        int nstr=arr.length;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(arr[i][j]==max){ nstr=nstr-1; break;}
            }
        }
        int nst=arr.length;
        for (int j = 0; j < arr.length; j++) {
            for (int i = 0; i < arr.length; i++) {
                if(arr[i][j]==max){ nst=nst-1; break;}
            }
        }
        int[][] arr1=new int[nstr][nst];
        int a1=0;

        two: for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] == max) {
                    continue two;
                }
            }
            int d=0;
            for ( int a=a1 ; a < nstr; a++){
                for (int b = 0; b < nst; b++) {
                    three:        for (int v = 0; v < arr.length ; v++) {
                        if(arr[v][d]==max){ d=d+1; continue three;}

                    }

                    arr1[a][b] = arr[i][d];
                    d=d+1;
                    if (b == nst - 1) {
                        a1 = a1 + 1;
                        continue two;
                    }
                }
            }
        }
        for (int i = 0; i < nstr; i++) {
            for (int j = 0; j < nst; j++) {
                System.out.print(arr1[i][j]+" ");}

            System.out.println();}

        return arr1;}
}