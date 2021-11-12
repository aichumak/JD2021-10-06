package by.it.drankevich.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PrintMath {
    public static void main(String[] args) {


        Class<Math> mathClass = Math.class;

        Field[] fields = mathClass.getFields();
        for (Field field : fields) {
            StringBuilder sb = new StringBuilder(field.toString());
            Pattern pattern = Pattern.compile("java.lang.Math.");
            Matcher matcher = pattern.matcher(field.toString());
            while (matcher.find()){
                int start = matcher.start();
                int end = matcher.end();
                sb.delete(start, end);}

            System.out.println(sb);


        }

        Method[] methods = mathClass.getDeclaredMethods();

        for (Method method : methods) {
            if ((method.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC) {

                StringBuilder sb = new StringBuilder(method.toString());
                Pattern pattern = Pattern.compile("java.lang.Math.");
                Matcher matcher = pattern.matcher(method.toString());
                while (matcher.find()){
                int start = matcher.start();
                int end = matcher.end();
                sb.delete(start, end);}

                System.out.println(sb);
            }

        }

    }


}

