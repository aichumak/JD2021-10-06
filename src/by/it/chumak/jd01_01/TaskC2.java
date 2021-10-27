package by.it.chumak.jd01_01;

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
        String[]  arrstrings = TaskC2.convert(a, b);

        for (int i = 0; i < 4; i++){
            System.out.println(arrstrings[i]);
        }
    }

    public static String[] convert(int a, int b) {
        String[] arrayofstrings = new String[4];
        arrayofstrings[0] = "DEC:" + a + "+" + b + "=" + (a+b);
        arrayofstrings[1] = "BIN:" + Integer.toBinaryString(a)+"+"+ Integer.toBinaryString(b)+"="+ Integer.toBinaryString(a+b);
        arrayofstrings[2] = "HEX:" + Integer.toHexString(a) + "+" + Integer.toHexString(b) + "=" + Integer.toHexString(a+b);
        arrayofstrings[3] = "OCT:" + Integer.toOctalString(a) + "+" + Integer.toOctalString(b) + "=" + Integer.toOctalString(a+b);
        return arrayofstrings;
    }
}
