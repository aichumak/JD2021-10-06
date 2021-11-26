package by.it.chumak.jd01_15;

import java.util.Arrays;

public class ExceptionsInfo extends Exception {

    public ExceptionsInfo() {

    }

    @SuppressWarnings("unused")
    public String getExceptionInfo(Exception e, String className) {
        Class<? extends Exception> exceptionClass = e.getClass();

        return String.format("ERROR: %s%n" + "in class: %s%n" + "stack: %s%n", exceptionClass.getName(), className, Arrays.toString(e.getStackTrace()));
    }
}
