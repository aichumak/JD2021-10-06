package by.it.kanaplianik.jd01_01;

import java.util.Scanner;

/*
Ускорение свободного падения на Земле и Марсе таково:
Марс   3.86
Земля   9.81

С клавиатуры вводится вес человека в килограммах.
Рассчитайте вес человека на Марсе и выведите
округлив его до сотых килограмма (2 знака)

Создайте для этих целей метод getWeight(int weight)

Требования:
1.  Метод getWeight(int weight) должен быть статическим.
2.  Метод getWeight должен возвращать значение типа double.
3.  Метод getWeight должен ОБЯЗАТЕЛЬНО округлять до сотых возвращаемое значение
    типа double внутри самого метода.
4.  Метод getWeight не должен ничего выводить на экран.
5.  Метод getWeight должен правильно переводить вес тела в килограммах на Земле
    в вес этого же тела на Марсе, и возвращать это значение.
6.  Если получится, то пока не используйте в getWeight методы стандартной библиотеки
    (round, ceil, printf, format, и т.п). Возможностей самого языка вполне достаточно.

Пример:

Ввод:
75

Вывод:
29.51

*/
class TaskC3 {
    public static void main (String[] args) {
        Scanner sca = new Scanner(System.in);
                int w = sca.nextInt();
                System.out.println(getWeight(w));
    }
    public static double getWeight(int weight) {
        double earthW = weight/9.81*3.86;
        double d = earthW*100;
        int almostEarthW = (int) d;
        double afterZeroValues = d-almostEarthW;
        if (afterZeroValues>=0.5) {
            almostEarthW = almostEarthW+1;
            double totalEarthW = (int) almostEarthW;
            totalEarthW = totalEarthW/100;
            return totalEarthW;
        }
        else {
            earthW = (int) d;
            earthW = earthW/100;
            return earthW;
        }
    }

}
