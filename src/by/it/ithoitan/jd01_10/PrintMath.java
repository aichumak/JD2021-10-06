package by.it.ithoitan.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.StringJoiner;

public class PrintMath {
    public static void main(String[] args) {
        StringBuilder output = new StringBuilder();
        Class<Math> mathClass = Math.class;
        Method[] methods = mathClass.getDeclaredMethods();
        Field[] fields = mathClass.getDeclaredFields();
        for (Field field : fields) {
            boolean isPublic = appendFieldModifiers(output, field);
            if (isPublic) {
                appendType(output, field);
                output.append(field.getName()).append(" ");
                output.append("\n");

            }

        }
        for (Method method : methods) {
            boolean isPublic = appendModifiers(output, method);
            if (isPublic) {
                appendReturnType(output, method);
                appendSignature(output, method);
                output.append("\n");

            }
        }
        System.out.println(output);
    }

    private static void appendType(StringBuilder output, Field field) {
        Class<?> type = field.getType();
        output.append(type.getSimpleName()).append(" ");
    }

    private static boolean appendFieldModifiers(StringBuilder output, Field field) {
        int fieldModifiers = field.getModifiers();
        if (Modifier.isPublic(fieldModifiers)) {
            output.append("public ");
        } else {
            return false;
        }
        if (Modifier.isPrivate(fieldModifiers)) {
            output.append("private ");
        }
        if (Modifier.isProtected(fieldModifiers)) {
            output.append("protect ");
        }
        if (Modifier.isFinal(fieldModifiers)) {
            output.append("final ");
        }
        if (Modifier.isStatic(fieldModifiers)) {
            output.append("static ");
        }
        return true;
    }

    private static void appendSignature(StringBuilder output, Method method) {
        output.append(method.getName());
        Class<?>[] parameterTypes = method.getParameterTypes();
        StringJoiner joiner = new StringJoiner(",", "(", ")");
        for (Class<?> parameterType : parameterTypes) {
            joiner.add(parameterType.getSimpleName());
        }
        output.append(joiner);
    }

    private static void appendReturnType(StringBuilder output, Method method) {
        Class<?> returnType = method.getReturnType();
        output.append(returnType.getSimpleName()).append(" ");
    }

    private static boolean appendModifiers(StringBuilder output, Method method) {
        int modifiers = method.getModifiers();
        if (Modifier.isPublic(modifiers)) {
            output.append("public ");
        } else {
            return false;
        }
        if (Modifier.isPrivate(modifiers)) {
            output.append("private ");
        }
        if (Modifier.isProtected(modifiers)) {
            output.append("protect ");
        }
        if (Modifier.isFinal(modifiers)) {
            output.append("final ");
        }
        if (Modifier.isStatic(modifiers)) {
            output.append("static ");
        }
        return true;
    }
}
