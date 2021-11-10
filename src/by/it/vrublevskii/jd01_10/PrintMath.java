package by.it.vrublevskii.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.StringJoiner;

public class PrintMath {
    public static void main(String[] args) {
        StringBuilder output = new StringBuilder();
        Class<Math> mathStructure = Math.class;
        Method[] declaredMathMethods = mathStructure.getDeclaredMethods();
        for (Method declaredMathMethod : declaredMathMethods) {
            boolean isPublic = appendModifiers(output, declaredMathMethod);
            if (isPublic) {
                appendReturnType(output, declaredMathMethod);
                output.append(declaredMathMethod.getName());
                appendSignature(output, declaredMathMethod);
                output.append("\n");
            }
        }

        Field[] declaredMathFields = mathStructure.getDeclaredFields();
        for (Field declaredMathField : declaredMathFields) {
            boolean isPublic = appendFieldModifiers(output, declaredMathField);
            if (isPublic) {
                getType(output, declaredMathField);
                output.append(declaredMathField.getName());
                output.append("\n");
            }
        }


        System.out.println(output);
    }

    private static void getType(StringBuilder output, Field declaredMathField) {
        Class<?> type = declaredMathField.getType();
        output.append(type.getSimpleName()).append(" ");
    }

    private static void appendSignature(StringBuilder output, Method declaredMathMethod) {
        Class<?>[] parameterTypes = declaredMathMethod.getParameterTypes();
        StringJoiner stringJoiner = new StringJoiner(",", "(", ")");
        for (Class<?> parameterType : parameterTypes) {
            stringJoiner.add(parameterType.getSimpleName());
        }
        output.append(stringJoiner);
    }

    private static void appendReturnType(StringBuilder output, Method declaredMathMethod) {
        Class<?> returnType = declaredMathMethod.getReturnType();
        output.append(returnType.getSimpleName()).append(" ");
    }

    private static boolean appendModifiers(StringBuilder output, Method declaredMathMethod) {
        int modifiers = declaredMathMethod.getModifiers();
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

    private static boolean appendFieldModifiers(StringBuilder output, Field declaredMathField) {
        int modifiers = declaredMathField.getModifiers();
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
