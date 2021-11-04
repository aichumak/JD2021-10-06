package by.it.astapchik.jd01_01;

import java.util.Scanner;

/* Нужно написать программу, которая вводит два числа с клавиатуры
и выводит их сумму на экран в виде

Ввод (это вы вводите с клавиатуры):
34 26

Вывод (это должно появиться в консоли, обратите внимание на пробелы и слово Sum:
Sum = 60

*/
class TaskC1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input integer: ");
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int s = n1 + n2;
        System.out.println("Sum = " + s);
    }
}