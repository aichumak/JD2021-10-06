package by.it.astapchik.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {

    private static Method method;

    public static void main(String[] args) {
        StringBuilder output = new StringBuilder();
        Class<String> stringClass = String.class;
        Method[] stringMethods = stringClass.getDeclaredMethods();


        for (Method stringMethod : stringMethods) {
            int modifier = stringMethod.getModifiers();
            if(!Modifier.isStatic(modifier)){
                printName(output, stringMethod);
                output.append("\n");
            }
        }
        System.out.println(output);
    }

    private static void printName(StringBuilder output, Method stringMethod) {
        output.append(stringMethod.getName());
    }

}
