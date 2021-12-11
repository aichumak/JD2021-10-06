package by.it.konon.jd01_13;

class ExceptionInfo {
    String getInfo(RuntimeException e, Class<TaskA> currentClass) {
        String currentClassName = currentClass.getName();
        StackTraceElement[] stackTrace = e.getStackTrace();
        for (StackTraceElement stackTraceElement : stackTrace) {
            String className = stackTraceElement.getClassName();
            if (className.equals(currentClassName)) {
                Class<? extends RuntimeException> aClass = e.getClass();
                String nameException = aClass.getName();
                int lineNumber = stackTraceElement.getLineNumber();

                return String.format("" +
                                " name: %s%n" +
                                " class: %s%n" +
                                " line: %d%n"
                        , nameException
                        , currentClass
                        , lineNumber);


            }


        }
        throw new RuntimeException("incorrect stacktrace");
    }

}
