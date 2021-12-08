package by.it.brutski.jd01_13;

import jdk.jfr.StackTrace;

public class ExceptonInfo {
    String getInfo(RuntimeException exc, Class<TaskA> currentClass){
        String currentClassName = currentClass.getName();
        StackTraceElement[] stackTrace = exc.getStackTrace();

        for(StackTraceElement stackTraceElement : stackTrace){
            String className = stackTraceElement.getClassName();
            if(className.equals(currentClassName)){
                Class<? extends RuntimeException> a_Class = exc.getClass();
                String nameException = a_Class.getName();
                int lineNumber = stackTraceElement.getLineNumber();
                return String.format("" + " name: %s%n" + "class: %s%n" + " line: %d%n", nameException, currentClassName, lineNumber);
            }
        }
        throw new RuntimeException("incorrect stacktrace");
    }
}
