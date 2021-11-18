package by.it.konon.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.StringJoiner;

public class PrintMath {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        Class<Math> mathClass = Math.class;
        Method[] methods = mathClass.getDeclaredMethods();
        for (Method method : methods) {
            boolean isPublic = appendModifiers(stringBuilder, method);
            if (isPublic) {
                appendReturnType(stringBuilder, method);
                appendSignature(stringBuilder, method);
                stringBuilder.append("\n");
            }


        }
        System.out.println(stringBuilder);

        StringBuilder nextStringBuilder = new StringBuilder();


    }

    private static void appendSignature(StringBuilder stringBuilder, Method method) {
        stringBuilder.append(method.getName());
        Class<?>[] parameterTypes = method.getParameterTypes();
        StringJoiner joiner = new StringJoiner(",", "(", ")");
        for (Class<?> parameterType : parameterTypes) {
            joiner.add(parameterType.getSimpleName());
        }
        stringBuilder.append(joiner);
    }

    private static void appendReturnType(StringBuilder stringBuilder, Method method) {
        Class<?> returnType = method.getReturnType();
        stringBuilder.append(returnType.getSimpleName()).append(" ");
    }

    private static boolean appendModifiers(StringBuilder stringBuilder, Method m) {
        int modifiers = m.getModifiers();
        if (Modifier.isPublic(modifiers)) {
            stringBuilder.append("public ");
        } else {
            return false;
        }
        if (Modifier.isPrivate(modifiers)) {
            stringBuilder.append("private ");
        }
        if (Modifier.isFinal(modifiers)) {
            stringBuilder.append("final ");
        }
        if (Modifier.isProtected(modifiers)) {
            stringBuilder.append("protected ");
        }
        return true;
    }
}
