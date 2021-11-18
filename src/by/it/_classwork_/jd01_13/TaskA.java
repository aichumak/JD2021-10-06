package by.it._classwork_.jd01_13;

import java.util.HashMap;

public class TaskA {
    @SuppressWarnings({"ConstantConditions"})
    public static void main(String[] args) {
        try {
            if (Math.random() > 0.5)
                new HashMap<String, String>(null);
            else
                Integer.parseInt("привет");
        } catch (NumberFormatException | NullPointerException e) {
            Class<TaskA> currentClass = TaskA.class;
            ExceptonInfo exceptonInfo = new ExceptonInfo();
            String info = exceptonInfo.getInfo(e, currentClass);
            System.out.println(info);
        }
    }
}
