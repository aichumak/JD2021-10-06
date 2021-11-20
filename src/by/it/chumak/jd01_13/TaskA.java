package by.it.chumak.jd01_13;

import java.util.HashMap;

public class TaskA {
    @SuppressWarnings({"ConstantConditions"})
    public static void main(String[] args) {
        try {
            if (Math.random() > 0.5)
                new HashMap<String, String>(null);
            else
                Integer.parseInt("привет");
        } catch (NullPointerException | NumberFormatException e) {
            ExceptionsInfo exceptionsInfo = new ExceptionsInfo();
            System.out.println(exceptionsInfo.getExceptionInfo(e, TaskA.class.getName()));
        }
    }
}
