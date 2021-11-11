package by.it.vrublevskii.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args) {
        StringBuilder output = new StringBuilder();
        Class<String> stringStructure = String.class;
        Method[] declaredStringMethods = stringStructure.getDeclaredMethods();
        for (Method declaredStringMethod : declaredStringMethods) {
            int modifiers = declaredStringMethod.getModifiers();
            if (!Modifier.isStatic(modifiers)){
                output.append(declaredStringMethod.getName()).append("\n");
            }
        }
        System.out.println(output);
    }
}
