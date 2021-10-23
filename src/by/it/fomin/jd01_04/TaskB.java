package by.it.fomin.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        System.out.println("Введите число сотрудников:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String [] lastName = new String[n];
        System.out.println("Введите фамилии сотрудников:");
        for (int i = 0; i <n ; i++) {
            Scanner surname = new Scanner(System.in);
            lastName [i]= surname.next();
        }
        int [][] salary = new int[n][4];
        for (int i = 0; i < lastName.length-1; i++) {
            System.out.println("Введите зарплату за кварталы для " + lastName[i]);
            for (int j = 0; j < 4; j++) {
            salary[i][j]= sc.nextInt();
            }
        }

    }
}
