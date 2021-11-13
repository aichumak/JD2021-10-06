package by.it.chumak.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.StringJoiner;

public class PrintMath {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        Class<Math> mathClass = Math.class;
        Method[] arrayMethods = mathClass.getDeclaredMethods();
        for (Method method : arrayMethods) {
            if (Modifier.isPublic(method.getModifiers()) && Modifier.isStatic(method.getModifiers())) {
                stringBuilder.append("public static ");
                stringBuilder.append(getMethodSignature(method));
                stringBuilder.append("\n");
            }
        }
        Field[] arrayFields = mathClass.getDeclaredFields();
        for (Field field : arrayFields) {
            if (Modifier.isPublic(field.getModifiers())) {
                stringBuilder.append(field.getType());
                stringBuilder.append(" ");
                stringBuilder.append(field.getName());
                stringBuilder.append("\n");
            }
        }
        System.out.println(stringBuilder);
    }

    private static StringBuilder getMethodSignature(Method fieldOrMethod) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(fieldOrMethod.getReturnType().getSimpleName());
        stringBuilder.append(" ");
        stringBuilder.append(getMethodNameAndParams(fieldOrMethod));
        return stringBuilder;
    }

    private static String getMethodNameAndParams(Method fieldOrMethod) {
        StringJoiner stringJoiner = new StringJoiner(",", "(", ")");
        Class<?>[] arrayParameters = fieldOrMethod.getParameterTypes();
        for (Class<?> parameter : arrayParameters) {
            stringJoiner.add(parameter.getSimpleName());
        }
        return fieldOrMethod.getName() + stringJoiner;
    }

}
