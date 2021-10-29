package by.it.ithoitan.jd01_01;

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
        int i = sc.nextInt();
        int j = sc.nextInt();
        int k = i + j;
        String arg1 = Integer.toBinaryString(i);
        String arg2 = Integer.toBinaryString(j);
        String arg3 = Integer.toBinaryString(k);
        String arg4 = Integer.toHexString(i);
        String arg5 = Integer.toHexString(j);
        String arg6 = Integer.toHexString(k);
        String arg7 = Integer.toOctalString(i);
        String arg8 = Integer.toOctalString(j);
        String arg9 = Integer.toOctalString(k);
        System.out.printf("DEC:%2d+%2d=%2d",i,j,k);
        System.out.print("\n");
        System.out.print("BIN" + ":" + arg1 + "+" + arg2 + "=" + arg3);
        System.out.print("\n");
        System.out.print("HEX" + ":" + arg4 + "+" + arg5 + "=" + arg6);
        System.out.print("\n");
        System.out.print("OCT" + ":" + arg7 + "+" + arg8 + "=" + arg9);
        System.out.print("\n");


    }


}
