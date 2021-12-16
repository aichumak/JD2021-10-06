package by.it.brutski.jd01_13;

public class ExceptonInfo {
    private RuntimeException exception;
    private Class<?> currentClass;

    public ExceptonInfo(RuntimeException exception, Class<?> currentClass) {
        this.exception = exception;
        this.currentClass = currentClass;
    }

    String getInfo(){
        String currentClassName = currentClass.getName();
        StackTraceElement[] stackTrace = exception.getStackTrace();

        for(StackTraceElement stackTraceElement : stackTrace){
            String className = stackTraceElement.getClassName();
            if(className.equals(currentClassName)){
                Class<? extends RuntimeException> a_Class = exception.getClass();
                String nameException = a_Class.getName();
                int lineNumber = stackTraceElement.getLineNumber();
                return String.format("" + " name: %s%n" + "class: %s%n" + " line: %d%n", nameException, currentClassName, lineNumber);
            }
        }
        throw new RuntimeException("incorrect stacktrace");
    }
}
