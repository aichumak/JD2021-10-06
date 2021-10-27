package by.it.drankevich.jd01_05;
import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        rezult4();
        rezult5();
    }


    private static void rezult4() {

        for (double a = 0; a <=2 ; a+=0.2){
            double y=0;
            for (int x = 1; x <=6 ; x++){
                y=y+(pow(7,a)-cos(x));

            }
            System.out.printf("При а=%f y=%f %n", a, y);

        }
    }
    private static void rezult5() {
        double α;
        double β;


        for (double x = -5.5; x <2 ; x+=0.5) {

            if(-2<x/2 & x/2<=-1) {
                β=sin(x*x);
                α=log10(abs(β+2.74));
                System.out.printf("При x/2= %.2f α=%g %n", x/2,α);
            }
            else
            if(-1<x/2 & x/2<0.2) {
                β=cos(x*x);
                α=log10(abs(β+2.74));
                System.out.printf("При x/2= %.2f α=%g %n", x/2,α);}
            else
            if(x/2==0.2) {
                β=1/tan(x*x);
                α=log10(abs(β+2.74));
                System.out.printf("При x/2= %.2f α=%g %n", x/2,α);}
            else
                System.out.printf("При x/2= %.2f вычисление не возможно %n", x/2);




        }

    }

}


