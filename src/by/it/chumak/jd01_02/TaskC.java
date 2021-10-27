package by.it.chumak.jd01_02;

import java.util.Random;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] array = step1(n);
        int sum = step2(array);
        array = step3(array);
    }

    private static int[][] step3(int[][] array) {
        int[][] arrnew;
        StringBuilder sb = new StringBuilder();
        int max = 0;
        int nstr = 0;
        String nclmn = "";
        int nclmnmax = 0;
        int n1 = 0;
        int n2 = 0;
        boolean stringfound;
        boolean nextstr;
        boolean nextcolumn;

        for (int[] arrstring : array) {
            for (int element : arrstring) {
                if (element > max) {
                    max = element;
                }
            }
        }

        for (int[] arrstring : array) {
            for (int element : arrstring) {
                if (element == max) {
                    nstr = nstr + 1;
                    break;
                }
            }
        }

        for (int i = 0; i < array.length; i++) {
            for (int i1 = 0; i1 < array[i].length; i1++) {
                if (array[i][i1] == max) {
                    nclmn = nclmn + i1;
                }
            }
        }

        //String pattern = "(.)(?=(.*))(?<=(?=\\1.*?\\1\\2$).+)";
        //String result = nclmn.replaceAll(pattern, "");
        nclmn.chars().distinct().forEach(c -> sb.append((char) c));
        //nclmnmax = result.length();
        nclmnmax = sb.length();

        int[] arrstr = new int[nstr];
        int[] arrcolumns = new int[nclmn.length()];

        for (int i = 0; i < array.length; i++) {
            stringfound = false;
            for (int i1 = 0; i1 < array[i].length; i1++) {
                if (max == array[i][i1]) {
                    stringfound = true;
                    arrcolumns[n2] = i1;
                    n2 = n2 + 1;
                }
            }
            if (stringfound) {
                arrstr[n1] = i;
                n1 = n1 + 1;
            }
        }

        arrnew = new int[array.length - nstr][array[0].length - nclmnmax];
        n1 = 0;
        n2 = 0;

        for (int i = 0; i < array.length; i++) {
            nextstr = false;

            for (int arrstrelement : arrstr) {
                if (arrstrelement == i) {
                    nextstr = true;
                    break;
                }
            }
            if (nextstr) {
                continue;
            }
            n2 = 0;
            for (int i1 = 0; i1 < array[i].length; i1++) {
                nextcolumn = false;
                for (int arrcolumn : arrcolumns) {
                    if (arrcolumn == i1) {
                        nextcolumn = true;
                        break;
                    }
                }
                if (nextcolumn) {
                    continue;
                }
                arrnew[n1][n2] = array[i][i1];
                n2 = n2 + 1;
            }
            n1 = n1 + 1;
        }

        for (int[] ints : arrnew) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }

        return arrnew;
    }

    private static int step2(int[][] array) {
        int sum = 0;
        boolean start;

        for (int[] arrstring : array) {
            start = false;

            for (int element : arrstring) {
                if (element >= 0) {
                    if (start == false) {
                        start = true;
                        continue;
                    }
                    if (start) {
                        break;
                    }
                }
                if (start) {
                    sum = sum + element;
                }
            }
        }
        System.out.println(sum);
        return sum;
    }

    private static int[][] step1(int n) {
        int[][] array = new int[n][n];
        Random r = new Random();
        boolean minfound = false;
        boolean maxfound = false;
        boolean nfound = false;

        while (nfound == false) {
            nfound = false;
            minfound = false;
            maxfound = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    array[i][j] = r.nextInt(n - (-n) + 1) + (-n);
                    if (array[i][j] == -n) {
                        minfound = true;
                    }
                    if (array[i][j] == n) {
                        maxfound = true;
                    }
                }
            }
            nfound = minfound && maxfound;
        }

        for (int i = 0; i < n; i++) {
            for (int i1 = 0; i1 < n; i1++) {
                System.out.print(array[i][i1] + " ");
            }
            System.out.print('\n');
        }
        return array;
    }

}
