package by.it.laevskiy.jd01_13;

class ExceptionInfo {
    private RuntimeException exception;
    private Class<?> currentClass;

    public ExceptionInfo(RuntimeException exception, Class<?> currentClass) {
        this.exception = exception;
        this.currentClass = currentClass;
    }

    String getInfo() {
        String currentClassName = currentClass.getName();
        StackTraceElement[] stackTrace = exception.getStackTrace();
        for (StackTraceElement stackTraceElement : stackTrace) {
            String className = stackTraceElement.getClassName();
            if (className.equals(currentClassName)) {
                Class<? extends RuntimeException> aClass = exception.getClass();
                String nameException = aClass.getName();
                int lineNumber = stackTraceElement.getLineNumber();
                return String.format(
                        "name: %s%n" +
                                "class: %s%n" +
                                "line: %d"
                        , currentClassName
                        , nameException
                        , lineNumber);
            }
        }
        throw new RuntimeException("incorrect stacktrace");
    }
}
