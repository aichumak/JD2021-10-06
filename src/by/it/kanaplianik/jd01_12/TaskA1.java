package by.it.kanaplianik.jd01_12;

import java.util.ArrayList;
import java.util.List;

public class TaskA1 {

    private static List<Integer> grades = new ArrayList<Integer>();

    public static void main (String[] args) {
        int countOfElements = 10;
        int min = 0;
        int max = 10;
        ArrayList<Integer> randomGrades = new ArrayList<Integer>();
        for (int i = 0; i < countOfElements; i++) {
            int a = min + (int) (Math.random() * max);
            Integer b = new Integer(a);
            randomGrades.add(i, b);
        }

        grades = randomGrades;

        System.out.println(grades);

        clearBad(grades);
    }

    static void clearBad(List<Integer> grades) {
        int countOfElements = 10;
        int badGrade = 4;

        ArrayList<Integer> badGrades = new ArrayList<Integer>();
        for (int i = 0; i < countOfElements; i++) {
            int k = grades.get(i);
            if (k < badGrade) {
                badGrades.add(k);
            }
        }
        grades.removeAll(badGrades);
        System.out.println(grades);
    }
}

