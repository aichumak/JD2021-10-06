package by.it.kanaplianik.jd01_12;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        ArrayList<Integer> elements = scanElements();
        var sortedList = sort(elements);
        System.out.println(sortedList);
    }

    static ArrayList<Integer> scanElements () {
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        while (true) {
            String line = scan.nextLine();
            if (line.equals("end")) {
                return list;
            } else {
                int a = Integer.parseInt(line);
                list.add(a);

            }
        }
    }

    static ArrayList<Integer> sort (ArrayList<Integer> el) {
        ArrayList<Integer> moreThanZero = new ArrayList<>();
        ArrayList<Integer> lessThanZero = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> zeroes = new ArrayList<>();
        for (int e : el) {
            if (e > 0) {
                moreThanZero.add(e);
            }
            else if (e < 0){
                lessThanZero.add(e);
            }
            else {
                zeroes.add(e);
            }

        }
        result.addAll(moreThanZero);
        result.addAll(zeroes);
        result.addAll(lessThanZero);
        return result;
    }


}
