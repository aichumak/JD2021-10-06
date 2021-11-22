package by.it.drankevich.jd01_13;
class ExceptonInfo {

    String getexeption(RuntimeException e, Class<?> currentclass) {

        String name = currentclass.getName();
        StackTraceElement[] stackTrace = e.getStackTrace();
        for (StackTraceElement stackTraceElement : stackTrace) {
            if (stackTraceElement.getClassName().equals(name)) {
                String nameExeption = e.getClass().getName();
                int lineNumber = stackTraceElement.getLineNumber();

                return String.format("name: %s%n" +
                                "class: %s%n" +
                                "line: %d",
                        nameExeption,name,lineNumber);

            }
        }
      throw new RuntimeException("incorrect stacktrace");

    }

}
