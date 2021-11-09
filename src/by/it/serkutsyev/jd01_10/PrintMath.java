package by.it.serkutsyev.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class PrintMath {
    public static void main(String[] args) {
        Class<?> c = Math.class;
        for (Method method: c.getMethods()) {
            String methodName = c.getSimpleName();
            System.out.println(method);

        }
        for (Field field: c.getFields()) {
            System.out.println(field);
            
        }
       // System.out.println(c.getMethods());
    }
}
