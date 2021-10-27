package by.it.drankevich.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
                int n= sc.nextInt();
        String[]surname=new String[n];
        for (int i = 0; i < n; i++) {
            surname[i] = sc.next();
        }

            int[][] array=new int[n][4];
            for (int i = 0; i < n; i++) {
                System.out.println("Введите зарплату для "+ surname[i]);
                for (int j = 0; j < 4; j++) {
                    array[i][j]=sc.nextInt();


                }

            }
        System.out.println("_______________________________________________________");
        System.out.printf("%-9s %-9s %-9s %-9s %-9s %-7s%n", "Фамилия", "Квартал1","Квартал2","Квартал3","Квартал4","Итого");
        System.out.println("_______________________________________________________");
        int sum;
        int sumgeneral=0;
        double average=0;
        for (int i = 0; i < n; i++) {
             sum=array[i][0]+array[i][1]+array[i][2]+array[i][3];
             sumgeneral=sumgeneral+sum;
            average=average+ (double) sum/4;

            System.out.printf("%-9s %-9s %-9s %-9s %-9s %-7s%n", surname[i],array[i][0],array[i][1],array[i][2],array[i][3],sum );

        }
        average= (double) average/n;

        System.out.println("_______________________________________________________");
        System.out.printf("%-9s %-9d%n", "Итого",sumgeneral );
        System.out.printf("%-9s %-9.4f%n", "Средняя",average );




    }
}
