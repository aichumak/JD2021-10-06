package by.it.serkutsyev.jd01_01;

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
        int a = sc.nextInt();
        int sum = i + a;
        //int x = getStrtingRadix1(i);
        System.out.println("DEC:" + i + "+" + a + "=" + sum);
        System.out.println("BIN:" + Integer.toString(i, 2) + "+" + Integer.toString(a, 2) + "=" + Integer.toString(sum, 2));
        System.out.println("HEX:" + Integer.toString(i, 16) + "+" + Integer.toString(a, 16) + "=" + Integer.toString(sum, 16));
        System.out.println("OCT:" + Integer.toString(i, 8) + "+" + Integer.toString(a, 8) + "=" + Integer.toString(sum, 8));
        //int new1 = getStrtingRadix1(i, 2);
        //int new2 = getStrtingRadix1(i, 8);

        // System.out.println(new1);
        //System.out.println(new2);


    }


    //public static int getStrtingRadix1(int r, int j) {
    //return Integer.parseInt(Integer.toString(r, j));

}
//   System.out.println("BIN " + Integer.toString(i, 2));
//   System.out.println("Octal eqivalent of 100 = " + Integer.toString(100, 8));
// System.out.println("Decimal eqivalent of 100 = " + Integer.toString(100, 10));
//  System.out.println("Hexadecimal eqivalent of 100 = " + Integer.toString(100, 16));
//  return 1;
//}
//}

/*
public class TaskC2 {

    public static void main(String[] args) {
        int x = getNumber();
        printNumber(x);
    }

    public static int getNumber() {
        int x = 5;
        return x;
    }

    public static void printNumber(int x) {
        System.out.println(x);
    }
}
*/