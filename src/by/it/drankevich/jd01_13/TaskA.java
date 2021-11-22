package by.it.drankevich.jd01_13;

import java.util.HashMap;

public class TaskA {
    public static void main(String[] args) {
        try {
            if (Math.random() > 0.5)
                new HashMap<String, String>(null);
            else
                Integer.parseInt("привет");
        }
        catch (NumberFormatException | NullPointerException e){
            Class<TaskA>currentclass=TaskA.class;
            ExceptonInfo exceptonInfo = new ExceptonInfo();
            String info=exceptonInfo.getexeption(e,currentclass);
            System.out.println(info);

            }


        }

    }


