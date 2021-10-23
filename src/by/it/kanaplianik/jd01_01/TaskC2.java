package by.it.kanaplianik.jd01_01;


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

import java.util.Scanner;

class TaskC2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = a+b;
        String d = Integer.toBinaryString(a);
        String e = Integer.toBinaryString(b);
        String f = Integer.toBinaryString(c);
        String g = Integer.toHexString(a);
        String h = Integer.toHexString(b);
        String i = Integer.toHexString(c);
        String j = Integer.toOctalString(a);
        String k = Integer.toOctalString(b);
        String l = Integer.toOctalString(c);



        System.out.println("DEC:" + a + "+" + b + "=" + c);
        System.out.println("BIN:" + d + "+" + e + "=" + f);
        System.out.println("HEX:" + g + "+" + h + "=" + i);
        System.out.println("OCT:" + j + "+" + k + "=" + l);

    }


}
