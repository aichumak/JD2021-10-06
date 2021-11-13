package by.it.astapchik.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.StringJoiner;

public class PrintMath {

    private static Method method;
    private static Field field;

    public static void main(String[] args) {
        StringBuilder output = new StringBuilder();
        Class<Math> mathClass = Math.class;

        Method[] methodsMath = mathClass.getDeclaredMethods();
        Field[] fieldsMath = mathClass.getFields();

        for (Method method : methodsMath) {
            boolean isPublic = appendModifiers(output, method);
            if (isPublic){
                printType(output, method);
                printSignature(output, method);
                output.append("\n");
            }
        }

        for (Field field : fieldsMath) {
            appendModifiersField(output, field);
            printTypeField(output, field);
            printSignatureField(output, field);
            output.append("\n");
        }

        System.out.println(output);
    }

    private static void printSignatureField(StringBuilder output, Field field) {
        output.append(field.getName());
    }


    private static boolean appendModifiersField(StringBuilder output, Field field) {
        int modifierField = field.getModifiers();
        if (Modifier.isPublic(modifierField)){
            output.append("public ");
        } else {
            return false;
        }
        if (Modifier.isPrivate(modifierField)){
            output.append("private ");
        }
        if (Modifier.isProtected(modifierField)){
            output.append("protected ");
        }
        if (Modifier.isStatic(modifierField)){
            output.append("static ");
        }
        if (Modifier.isFinal(modifierField)){
            output.append("final ");
        }
        return true;
    }

    private static void printTypeField(StringBuilder output, Field field) {
        Class<?> returnType = field.getType();
        output.append(returnType.getSimpleName()).append(" ");
    }


    private static void printSignature(StringBuilder output, Method method) {
        output.append(method.getName());
        Class<?>[] parameterTypes = method.getParameterTypes();
        StringJoiner joiner = new StringJoiner(",", "(", ")");
        for (Class<?> parameterType : parameterTypes) {
            joiner.add(parameterType.getSimpleName());
        }
        output.append(joiner);
    }

    private static void printType(StringBuilder output, Method method) {
        Class<?> returnType = method.getReturnType();
        output.append(returnType.getSimpleName()).append(" ");
    }

    private static boolean appendModifiers(StringBuilder output, Method method) {
        int modifiersMethods = method.getModifiers();

        if (Modifier.isPublic(modifiersMethods)){
            output.append("public ");
        } else {
            return false;
        }
        if (Modifier.isPrivate(modifiersMethods)){
            output.append("private ");
        }
        if (Modifier.isProtected(modifiersMethods)){
            output.append("protected ");
        }
        if (Modifier.isStatic(modifiersMethods)){
            output.append("static ");
        }
        if (Modifier.isFinal(modifiersMethods)){
            output.append("final ");
        }
        return true;
    }
}
