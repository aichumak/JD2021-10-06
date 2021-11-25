package by.it.laevskiy.jd01_13;

import java.util.HashMap;

public class TaskA {
    @SuppressWarnings({"ConstantConditions", "ResultOfMethodCallIgnored"})
    public static void main(String[] args) {
        try {
            if (Math.random() > 0.5)
                new HashMap<String, String>(null);
            else
                Integer.parseInt("привет");
        } catch (NumberFormatException | NullPointerException e) {
            ExceptionInfo exceptionInfo = new ExceptionInfo(e, TaskA.class);
            System.out.println(exceptionInfo.getInfo());
        }
    }
}
