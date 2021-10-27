package by.it.brutski.jd01_01;

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
        int a, b;
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите первое число: ");
        a = sc.nextInt();

        System.out.print("Введите второе число: ");
        b = sc.nextInt();

        System.out.println("Sum = " + (a + b));
    }
}




