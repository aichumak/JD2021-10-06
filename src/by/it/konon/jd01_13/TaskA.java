package by.it.konon.jd01_13;

import java.util.HashMap;

public class TaskA {
    @SuppressWarnings("ConstantConditions")
    public static void main(String[] args) {
        try {

            if (Math.random() > 0.5) {
                new HashMap<String, String>(null);
            } else {
                Integer.parseInt("привет");
            }
        } catch (NullPointerException | NumberFormatException e) {
            Class<TaskA> currentClass = TaskA.class;
            ExceptionInfo exceptionInfo = new ExceptionInfo();
            String info = exceptionInfo.getInfo(e, currentClass);
            System.out.println(info);



        }


    }



}





