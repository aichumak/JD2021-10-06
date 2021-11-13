package by.it.serkutsyev.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.StringJoiner;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> c = Math.class;
        StringBuilder output = new StringBuilder();
        StringBuilder outputField = new StringBuilder();
        Method[] methods = c.getDeclaredMethods();
        for (Method method : methods) {
            boolean isPublic = getMethodsModifiers(output, method);
            if (isPublic) {
                getMethodsReturnType(output, method);
                getMethodsSignature(output, method);
                output.append("\n");
            }

        }
        System.out.println(output);
        Field [] fields = c.getDeclaredFields();
        for (Field field: fields) {
            boolean isPublic = getFieldsModifiers(outputField, field);
            if (isPublic) {
                getFieldsType(outputField, field);
                getFieldsSignature(outputField, field);
                outputField.append("\n");
            }
        }
        System.out.println(outputField);
    }

    private static void getFieldsType(StringBuilder outputField, Field field) {
        Class<?> type = field.getType();
        outputField.append(type).append(" ");

    }

    private static void getFieldsSignature(StringBuilder outputField, Field field) {
        outputField.append(field.getName());
    }

    private static boolean getFieldsModifiers(StringBuilder outputField, Field field) {
        int modifiers = field.getModifiers();
        if (Modifier.isPublic(modifiers)) {
            outputField.append("public ");
        } else {
            return false;
        }
        if (Modifier.isStatic(modifiers)) {
            outputField.append("static ");
        }
        if (Modifier.isFinal(modifiers)) {
            outputField.append("final ");
        }
        return true;
    }

    private static void getMethodsSignature(StringBuilder output, Method method) {
        output.append(method.getName());
        Class<?>[] parameterTypes = method.getParameterTypes();
        StringJoiner parametres = new StringJoiner(",", "(", ")");
        for (Class<?> parameter : parameterTypes) {
            parametres.add(parameter.getName());
        }
output.append(parametres);

    }

    private static void getMethodsReturnType(StringBuilder output, Method method) {
        Class<?> returnType = method.getReturnType();
        output.append(returnType).append(" ");

    }

    private static boolean getMethodsModifiers(StringBuilder output, Method method) {
        int modifiers = method.getModifiers();
        if (Modifier.isPublic(modifiers)) {
            output.append("public ");
        } else {
            return false;
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
