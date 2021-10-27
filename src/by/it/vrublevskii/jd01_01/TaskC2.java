package by.it.vrublevskii.jd01_01;

import java.util.Scanner;

/* Нужно написать программу, которая вводит два числа с клавиатуры
и 4 раза выводит их сумму с обозначением системы счисления на экран в
ДЕСЯТИЧНОМ ДВОИЧНОМ ШЕСТНАДЦАТИРИЧНОМ ВОСЬМИРИЧНОМ виде

Вот пример ввода с клавиатуры:
34 26

Тогда вывод ожидается такой (обратите внимание на регистр букв):
DEC:34+26=60
BIN:100010+11010=111100
HEX:22+1a=3c
OCT:42+32=74

Допускается свободное использование любых методов стандартной библиотеки
*/
class TaskC2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = a + b;
        System.out.printf("DEC:%d+%d=%d\n", a, b, c);
        String s = Integer.toBinaryString(a);
        String s1 = Integer.toBinaryString(b);
        String s2 = Integer.toBinaryString(c);
        System.out.printf("BIN:%s+%s=%s\n", s, s1, s2);
        s = Integer.toHexString(a);
        s1 = Integer.toHexString(b);
        s2 = Integer.toHexString(c);
        System.out.printf("HEX:%s+%s=%s\n", s, s1, s2);
        s = Integer.toOctalString(a);
        s1 = Integer.toOctalString(b);
        s2 = Integer.toOctalString(c);
        System.out.printf("OCT:%s+%s=%s\n", s, s1, s2);
    }
}
