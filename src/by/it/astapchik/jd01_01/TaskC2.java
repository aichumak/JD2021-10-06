package by.it.astapchik.jd01_01;

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
        System.out.print("Input integers: ");

        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int s = n1+n2;

        String result1 = Integer.toBinaryString(n1);
        String result2 = Integer.toBinaryString(n2);
        String result_binary = Integer.toBinaryString(s);;

        String hex1 = Integer.toHexString(n1);
        String hex2 = Integer.toHexString(n2);
        String hex_sum = Integer.toHexString(s);

        String oct1 = Integer.toOctalString(n1);
        String oct2 = Integer.toOctalString(n2);
        String oct_sum = Integer.toOctalString(s);

        System.out.println("DEC:" + n1 + '+' + n2 + '=' + s);
        System.out.println("BIN:" + result1 +"+"+ result2 + "=" + result_binary);
        System.out.println("HEX:" + hex1 +"+"+ hex2 + "="+ hex_sum);
        System.out.println("OCT:" + oct1 +"+"+ oct2 + "="+ oct_sum);
    }

}
