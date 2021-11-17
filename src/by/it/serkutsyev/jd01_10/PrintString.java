package by.it.serkutsyev.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args) {
        Class<String> c = String.class;
        StringBuilder output = new StringBuilder();
        Method[] methods = c.getDeclaredMethods();
        for (Method method : methods) {
            boolean isNonStatic = isMethodNonStatic(method);
            if (isNonStatic) {
                getMethodName(output, method);
                output.append("\n");
            }

        }
        System.out.println(output);
    }

    private static void getMethodName(StringBuilder output, Method method) {
        output.append(method.getName());
    }

    private static boolean isMethodNonStatic(Method method) {
        int modifiers = method.getModifiers();
        if (Modifier.isStatic(modifiers)) {
            return false;
        } else {
            return true;
        }
    }
}
