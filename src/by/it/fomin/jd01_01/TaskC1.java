package by.it.fomin.jd01_01;

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
        Scanner input = new Scanner(System.in);
        // Нужно добавить проверку на количество целых чисел в при либо ограничить количество чисел
        System.out.println("Введите 2 целых числа через пробел для суммирования");
        int a = input.nextInt();
        int b = input.nextInt() + a;
        System.out.println("Sum = " + b);
        input.close();
    }


}
