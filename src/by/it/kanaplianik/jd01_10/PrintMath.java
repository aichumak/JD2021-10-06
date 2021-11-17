package by.it.kanaplianik.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) {
        Class <Math> mathClass = Math.class;
        Field[] fields = mathClass.getFields();
        String nameMath = mathClass.getName();
        for (Field field : fields) {
            String stringField = field.toString();
            String formattedWithoutDot = clean(stringField,nameMath);
            System.out.println(formattedWithoutDot);
        }

        Method[] methods = mathClass.getDeclaredMethods();
        for (Method method : methods) {
            boolean isPublic = Modifier.isPublic(method.getModifiers());
            if (isPublic) {
                String methodString = method.toString();
                String formattedWithoutDot = clean(methodString, nameMath);
                System.out.println(formattedWithoutDot);
            }
        }
    }
    public static String clean (String value, String nameMath) {
        String formatted = value.replaceAll(nameMath, "");
        String formattedWithoutDot = formatted.replaceAll("\\.", "");
        return formattedWithoutDot;
    }
}