package by.it.ithoitan.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        double total = 0;
        Scanner scanner = new Scanner(System.in);
        int personNamber = scanner.nextInt();
        String[] personArray = new String[personNamber];
        for (int i = 0; i < personArray.length; i++) {
            personArray[i] = scanner.next();
        }
        int[][] salary = new int[personNamber][4];
        for (int i = 0; i < salary.length; i++) {
            System.out.printf("Введите зарплату для %s\n", personArray[i]);
            for (int j = 0; j < salary[i].length; j++) {
                salary[i][j] = scanner.nextInt();
                total+=salary[i][j];

            }
            System.out.println(total);


        }
        double midleSal = total / (personNamber * 4);
        System.out.println("--------------------------------------------");
        System.out.printf("%-8s%-10s%-10s%-10s%-10s%-8s\n", "Фамилия","Квартал1", "Квартал2", "квартал3", "Квартал4", "Итого");
        System.out.println("--------------------------------------------");
        for (int i = 0; i < salary.length; i++) {
            System.out.print(personArray[i]+":");
            for (int j = 0; j < salary[i].length; j++) {
                System.out.printf("%10d",salary[i][j]);
            }
            System.out.println();

        }
        System.out.println("--------------------------------------------");
        System.out.printf("\n Итого %f", total);
        System.out.printf("\n Средняя %4.4f", midleSal );
        System.out.println();





    }







}
