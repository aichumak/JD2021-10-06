package by.it.konon.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {

        step1();
        step2();
    }

    private static void step1() {
        double y = 0.0;
        for(double a=0.0;a<=2.0;a+=0.2){
            for(int x=1;x<=6;x++){
                y += pow(7, a) - cos(x);
            }
            System.out.println("При a= "+a+" Сумма y="+y);
        }
        System.out.println(y);
    }

    private static void step2() {
        double a = 0.0;
        for (double x = -5.5; x <2 ; x+=0.5) {
            if((x/2)>-2 && (x/2)<= -1){
                double b = sin(pow(x, 2));
                a = log10(abs(b+2.74));
                System.out.println("При х/2="+ x/2 +" a = "+a);
            }else if ((x/2)>-1 && (x/2)<0.2){
                double b = cos(pow(x, 2));
                a = log10(abs(b+2.74));
                System.out.println("При х/2="+ x/2 +" a = "+a);
            } else if ((x/2) == 0.2){
                double b = atan(pow(x, 2));
                a = log10(abs(b+2.74));
                System.out.println("При х/2="+ x/2 +" a = "+a);

            }else{
                System.out.println("При х/2="+ x/2 +" значения не определены");
            }

        }

    }
}











