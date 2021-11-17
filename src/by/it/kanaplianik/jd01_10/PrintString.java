package by.it.kanaplianik.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args) {
        Class <String> stringClass = String.class;
        Method[] methods = stringClass.getDeclaredMethods();
        for (Method method : methods) {
            boolean isStatic = Modifier.isStatic(method.getModifiers());
            if (!isStatic) {
                String name = method.getName();

               // String formattedWithoutDot = clean(methodString, nameMath);
                System.out.println(name);
            }
        }
    }
}
