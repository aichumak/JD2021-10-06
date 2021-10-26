package by.it.vrublevskii.jd01_05;

import static java.lang.Math.*;

class TaskB {
    public static void main(String[] args) {
        step4();
        step5();
    }


    static void step4() {
        double sum = 0;
        double a;
        for (a = 0; a <= 2; a += 0.2) {
            for (int x = 1; x <= 6; x++) {
                sum += pow(7, a) - cos(x);
            }
            System.out.printf("При а = %.2f Сумма у = %e\n", a, sum);
        }
    }

    static void step5(){
        double b;
        for (double x = -6+0.5; x < 2; x += 0.5) {
            if(x/2 > -2 && x/2 <= -1){
                b = sin(pow(x, 2));
                countA(b, x);
            }else if(x/2 > -1 && x/2 < 0.2){
                b = cos(pow(x, 2));
                countA(b, x);
            }else if (x/2 == 0.2){
                b = 1/tan(pow(x, 2));
                countA(b, x);
            }else{
                System.out.printf("Для x/2=%.2f вычисления не определены\n", x/2);
            }
        }
    }

    static void countA(double b, double x){
        double a = log10(abs(b + 2.74));
        System.out.printf("При х/2=%.2f a=%e\n", x/2, a);
    }
}
