package by.it.chumak.jd01_14;

import java.io.IOException;
import java.util.Arrays;

public class ExceptionsInfo {
    public String getExceptionInfo(IOException e, String className) {
        Class<? extends IOException> exceptionClass = e.getClass();

        return String.format("ERROR: %s%n" + "in class: %s%n" + "stack: %s%n", exceptionClass.getName(), className, Arrays.toString(e.getStackTrace()));
    }
}
