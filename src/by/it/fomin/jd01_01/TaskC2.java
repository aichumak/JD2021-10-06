package by.it.fomin.jd01_01;

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

        int a, b, c, sum;
        String binary1 = "", binary2 = "", binary3 = "";
        String hex1 = "", hex2 = "", hex3 = "";
        String octal1 = "", octal2 = "", octal3 = "";
        Scanner input = new Scanner(System.in);
        // Нужно добавить проверку на количество целых чисел при вводе либо ограничить количество чисел
        System.out.println("Введите 2 целых числа через пробел" + "\n" + "для отображения их суммы в DEC, BIN, HEX, OCT счислении:");
        a = input.nextInt();
        b = input.nextInt() + a;
        c = b - a;
        sum = a + c;
        System.out.println("DEC:" + a + "+" + c + "=" + sum);
        System.out.println("BIN:" + Integer.toBinaryString(a) + "+" + Integer.toBinaryString(c) + "=" + Integer.toBinaryString(sum));
        System.out.println("HEX:" + Integer.toHexString(a) + "+" + Integer.toHexString(c) + "=" + Integer.toHexString(sum));
        System.out.println("OCT:" + Integer.toOctalString(a) + "+" + Integer.toOctalString(c) + "=" + Integer.toOctalString(sum));

        input.close();
    }

}
