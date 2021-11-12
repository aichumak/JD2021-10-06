package by.it.drankevich.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PrintString {
    public static void main(String[] args) {


        Class<String> stringClass = String.class;
        Method[] methods = stringClass.getDeclaredMethods();
        for (Method method : methods) {
            if ((method.getModifiers() & Modifier.STATIC) != Modifier.STATIC) {
                StringBuilder sb = new StringBuilder();
                Pattern pattern = Pattern.compile("\\.[a-zA-Z]+\\(");
                Matcher matcher = pattern.matcher(method.toString());
                while (matcher.find()) {
                    int start = matcher.start();
                    int end = matcher.end();
                    sb.append(method.toString(), start + 1, end - 1);
                }

                System.out.println(sb);


            }

        }
    }
}

