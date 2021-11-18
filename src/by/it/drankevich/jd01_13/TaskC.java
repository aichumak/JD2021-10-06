package by.it.drankevich.jd01_13;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskC{
    static Scanner sc;


    public static void main(String[] args) throws InterruptedException {

        sc = new Scanner(System.in);
        readData();

    }

     static void readData() throws InterruptedException {
         ArrayList<Double> arrayList=new ArrayList<>();
         int count=0;
         for (;;) {
             String s = sc.nextLine();
             if (s.equals("END")) break;
             else {
                 try {
                     double number = Double.parseDouble(s);
                     arrayList.add(number);

                 } catch (NumberFormatException e) {
                     Thread.sleep(100);

                     for (int i = arrayList.size() - 1; i >= 0; i--) {

                         System.out.print(arrayList.get(i) + " ");
                     }
                     System.out.println();
                     count++;
                     if (count == 5) {
                         throw new RuntimeException();

                     }

                 }
             }
         }

         }
    }

