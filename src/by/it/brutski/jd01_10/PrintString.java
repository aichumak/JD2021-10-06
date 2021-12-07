package by.it.brutski.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();
        Class<?> a = String.class;

        Method[] methods = a.getDeclaredMethods();
        for (Method method : methods) {
            Name(result, method);
        }
    }

    private static void Name(StringBuilder result, Method method) {
        int modifiers = method.getModifiers();
        if (!Modifier.isStatic(modifiers)) {
            result.append(method.getName());
            System.out.println(method.getName());
        }
    }

}
