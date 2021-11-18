package by.it.drankevich.jd01_13;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Double.NaN;
import static java.lang.Math.*;


public class TaskB {
    public static void main(String[] args) {

        ArrayList<Double> arrayList=new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        for (;;){
        String s = sc.nextLine();
        if(s.equals("END")) break;
        else {
            try {

                double number = Double.parseDouble(s);
                arrayList.add(number);
                double value = arrayList.get(arrayList.size() - 1);
                System.out.println(value);

                System.out.println();
                double sum = 0;

                for (Double aDouble : arrayList) {
                    sum += aDouble;
                }
                Double sqrtresult = sqrt(sum);
                if(sqrtresult.equals(NaN)){
                    throw new ArithmeticException();
                }
                System.out.println(sqrtresult);
            }catch (NumberFormatException|ArithmeticException e){
                Class<TaskB>currentclass=TaskB.class;
                ExceptonInfo exceptonInfo = new ExceptonInfo();
                String info=exceptonInfo.getexeption(e,currentclass);
                System.out.println(info);


            }

            }

        }
    }

}
