package by.it.brutski.jd01_13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskB {
    public static final String STOP = "end";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> list = new ArrayList<>();

        while (true){
            String word = scanner.nextLine();
            if(word.equals(STOP)){
                double list_value = list.isEmpty() ? 0 : list.get(list.size() - 1);
                double list_sum = list.stream().reduce(Double::sum).orElse(0.0);

                System.out.println("Last " + list_value);
                System.out.println("Square root " + Math.sqrt(list_sum));
                break;
            }else {
                String[] strings = word.trim().split("[,\\.:;?!\\s]");
                for (String string : strings){
                    try {
                        double a = Double.parseDouble(string);
                        list.add(a);
                    }catch (NumberFormatException | ArithmeticException e){
                        System.out.println(new ExceptonInfo(e, TaskB.class));
                    }
                }
            }
        }
    }
}
