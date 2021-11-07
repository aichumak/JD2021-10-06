package by.it._classwork_.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.StringJoiner;

public class PrintMath {
    public static void main(String[] args) {
        StringBuilder output = new StringBuilder();
        Class<Math> mathClass = Math.class;
        Method[] methods = mathClass.getDeclaredMethods();
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
        //00000000000000000000000000001001 //DEC = 9
        //00000000000000000000000000000001 //DEC = 1
        //&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
        //00000000000000000000000000000001
        if (Modifier.isPublic(modifiers)) {
            output.append("public ");
        } else {
            return false;
        }
        if (Modifier.isPrivate(modifiers)) {
            output.append("private ");
        }
        if (Modifier.isProtected(modifiers)) {
            output.append("protected ");
        }
        if (Modifier.isStatic(modifiers)) {
            output.append("static ");
        }
        if (Modifier.isFinal(modifiers)) {
            output.append("final ");
        }
        return true;
    }
}
