package by.it.laevskiy.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args) {
        Class<String> structString = String.class;
        Method[] methods = structString.getDeclaredMethods();
        printStringMethods(methods);
    }


    private static void printStringMethods(Method[] methods) {
        for (Method method : methods) {
                if ((method.getModifiers() & Modifier.STATIC) != Modifier.STATIC) {
                            System.out.println(method.getName());
                }
            }
        }
    }

