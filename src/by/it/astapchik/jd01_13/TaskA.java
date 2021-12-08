package by.it.astapchik.jd01_13;

import java.util.HashMap;

class TaskA {
    @SuppressWarnings({"ConstantConditions"})
    public static void main(String[] args) {
        try {
            if (Math.random()>0.5)
                new HashMap<String, String>(null);
            else
                Integer.parseInt("привет");
        } catch (NumberFormatException | NullPointerException e){

            Class<TaskA> currentClass = TaskA.class;
            String currentClassName = currentClass.getName();
            StackTraceElement[] stackTrace = e.getStackTrace();

            for (StackTraceElement stackTraceElement : stackTrace) {
                String className = stackTraceElement.getClassName();
                if (className.equals(currentClassName)){
                    Class<? extends RuntimeException> aClassException = e.getClass();
                    String nameException = aClassException.getName();
                    int lineNumber = stackTraceElement.getLineNumber();
                    System.out.printf(" name: %s%n class: %s%n line: %d%n",
                            nameException, currentClassName, lineNumber
                    );
                    break;
                }
            }
        }

    }
}
