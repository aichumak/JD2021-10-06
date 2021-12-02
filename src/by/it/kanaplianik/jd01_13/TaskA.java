package by.it.kanaplianik.jd01_13;

import java.util.HashMap;

public class TaskA {
    public static void main(String[] args) {

        try {
            if (Math.random() > 0.5)
                new HashMap<String, String>(null);
            else
                Integer.parseInt("привет");
        } catch (Exception e) {
            printException(e);
        }
    }

    public static void printException(Exception e) {
        System.out.printf("name: %s\nclass: %s\nline: %d\n", getExceptionName(e), getExceptionClass(e), getLineNumber(e));
    }

    public static String getExceptionName(Exception ex) {
        return ex.getClass().getName();
    }

    public static String getExceptionClass(Exception ex) {
        for (StackTraceElement stackTraceElement : ex.getStackTrace()) {
            if (stackTraceElement.getClassName().equals(TaskA.class.getName())) {
                return stackTraceElement.getClassName();
            }
        }
        return "undefined";
    }

    public static int getLineNumber(Exception ex) {
        for (StackTraceElement stackTraceElement : ex.getStackTrace()) {
            if (stackTraceElement.getClassName().equals(TaskA.class.getName())) {
                return stackTraceElement.getLineNumber();
            }
        }
        return -1;
    }
}
