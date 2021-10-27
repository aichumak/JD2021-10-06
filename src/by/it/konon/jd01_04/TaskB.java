package by.it.konon.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pplCount = scanner.nextInt();
        String [] sureName = new String[pplCount];
        for (int i = 0; i < sureName.length; i++) {
            sureName[i] = scanner.next();
        }
        int n =sureName.length;
        int [][] salary = new int[n][4];
        for (int i = 0; i < sureName.length; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.println("Введите зарплату для "+ sureName[i]+ ":");
                salary[i][j] = scanner.nextInt();
            }

        }
        int sumStr=0;
        int sum=0;
        double average=0.0;
        System.out.printf("%-7s:\t\t%-7s:%-8d%-7s:%-8d%-7s:%-8d%-7s:%-8d%-5s:\n","Фамилия","Квартал",1,"Квартал",2,"Квартал",3,"Квартал",4,"Итого");
        System.out.println("___________________________________________________________________________________________________________");
        for(int i=0;i< sureName.length;i++){
            System.out.printf("%-2s:\t\t\t\t",sureName[i]);
            sumStr=0;
            for (int j = 0; j < 4; j++) {
                sumStr+=salary[i][j];
                sum+=salary[i][j];
                System.out.printf("%-15d",salary[i][j]);
            }
            System.out.print(sumStr);
            System.out.println();

        }
        System.out.print("___________________________________________________________________________________________________________"+ "\n");
        System.out.printf("%-5s:%-5d","Итого",sum);
        average=(double)sum/(n*4);
        System.out.printf("%-7s:%-2.6f","Cредняя",average);



    }



}

  /*  B1. Введите с консоли число людей n (nextInt() в сканере).
         Затем введите одномерный массив их фамилий (next() в сканере).
         Введите двумерный массив их зарплат за 4 квартала (N строк и 4 столбца).
         Зарплаты имеют тип int.
         Нужно для каждой фамилии выводить подсказку
         После подсказки можно через пробел вводить с консоли 4 цифры зарплат по кварталам (nextInt() в
        сканере).

         Постройте в консоли таблицу доходов людей по кварталам с фамилиями и
        итогом за год в последней колонке.*/