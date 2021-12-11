package by.it.serkutsyev.jd01_13;

import java.util.HashMap;

public class TaskA {
    public static void main(String[] args) {
        try {
            if (Math.random() > 0.5)
                new HashMap<String, String>(null);
            else
                Integer.parseInt("привет");
        } catch (NumberFormatException | NullPointerException e) {
            Class<TaskA> taskAClass = TaskA.class;
            String name = taskAClass.getName();

            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement stackTraceElement : stackTrace) {
                String className = stackTraceElement.getClassName();
                if (className.equals(name)) {
                    Class<? extends RuntimeException> aClass = e.getClass();
                    String exceptionName = aClass.getName();
                    System.out.println("name:" + exceptionName);
                    int lineNumber = stackTraceElement.getLineNumber();
                    System.out.println("class:" + name);
                    System.out.println("line:" + lineNumber);
                    break;
                }

            }
        }
    }

}
