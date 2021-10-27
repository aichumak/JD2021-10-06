package by.it.drankevich.jd01_05;

import static java.lang.Math.*;

public class TaskA {
    public static void main(String[] args) {
        result1();
        rezult2();
        rezult3();

    }


    private static void result1() {
        double a = 756.13;
        double x = 0.3;
        double part1 = cos(pow((x * x + PI / 6), 5));
        double part2 = sqrt(x * pow(a, 3));
        double part3 = log(abs((a - 1.12 * x) / 4));
        double z=part1-part2-part3;
        System.out.printf("При a=%f x=%f z=%f %n", a,x,z);
        z=cos(pow((x * x + PI / 6), 5))-sqrt(x * pow(a, 3))-log(abs((a - 1.12 * x) / 4));
        System.out.printf("При a=%f x=%f z=%f %n", a,x,z);

    }

    private static void rezult2() {
        double a=1.21;
        double b=0.371;
        double part1=tan(pow(a+b, 2));
        double part2=pow(a+1.5, 1/3.0);
        double part3=a*pow(b,5);
        double part4=b/log(a*a);
        double y=part1-part2+part3-part4;
        System.out.printf("y=%f %n",y);;
    }

    private static void rezult3() {
        double x=12.1;
        for (double a = -5; a <=12 ; a+=3.75) {
            double f=exp(a*x)-3.45*a;
            System.out.printf("При a=%f  f=%f %n", a,f);

        }

    }
}
