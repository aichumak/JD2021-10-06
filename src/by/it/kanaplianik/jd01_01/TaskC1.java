package by.it.kanaplianik.jd01_01;

import java.util.Scanner;

/* Нужно написать программу, которая вводит два числа с клавиатуры
и выводит их сумму на экран в виде

Ввод (это вы вводите с клавиатуры):
34 26

Вывод (это должно появиться в консоли, обратите внимание на пробелы и слово Sum:
Sum = 60

*/

class TaskC1 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int r = x+y;
        System.out.println("Sum = " + r);

        /*  String numbers = sc.nextLine();
        String[] numspl = numbers.split("\\s");
        String str1 = numspl[0];
        String str2 = numspl[1];
        int x = Integer.parseInt(str1);
        int y = Integer.parseInt(str2);
        int r = x+y;
        System.out.println("Sum = " + r);

         */

    }




}
