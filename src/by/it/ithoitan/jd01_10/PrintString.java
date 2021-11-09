package by.it.ithoitan.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args) {
        StringBuilder output = new StringBuilder();
        Class<?> c = String.class;
        Method[] methods = c.getDeclaredMethods();
        for (Method method : methods) {
            appendName(output, method);

        }
    }

    private static void appendName(StringBuilder output, Method method) {
        int modifiers = method.getModifiers();
        if (!Modifier.isStatic(modifiers)) {
            output.append(method.getName());
            System.out.println(method.getName());
        }
    }

}
