package by.it.chumak.jd01_13;

public class ExceptionsInfo {
    public String getExceptionInfo(RuntimeException e, String className) {
        Class<? extends RuntimeException> exceptionClass = e.getClass();
        StackTraceElement[] stackTrace = e.getStackTrace();

        for (StackTraceElement stackTraceElement : stackTrace) {
            if (stackTraceElement.getClassName().equals(className)) {
                return String.format("name: %s%n" + "class: %s%n" + "line: %s%n", exceptionClass.getName(), className, stackTraceElement.getLineNumber());
            }
        }

        throw new RuntimeException("incorrect");
    }
}
