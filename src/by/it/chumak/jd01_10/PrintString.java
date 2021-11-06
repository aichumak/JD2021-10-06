package by.it.chumak.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        Class<String> stringClass = String.class;
        Method[] arrayMethods = stringClass.getDeclaredMethods();

        for (Method method : arrayMethods) {
            if(!Modifier.isStatic(method.getModifiers())){
               stringBuilder.append(method.getName());
               stringBuilder.append("\n");
            }
        }
        System.out.println(stringBuilder);
    }
}
