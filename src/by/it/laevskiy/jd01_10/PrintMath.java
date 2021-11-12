package by.it.laevskiy.jd01_10;


import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {

    public static void main(String[] args) {
        Class<Math> structMath = Math.class;
        Method[] methods = structMath.getDeclaredMethods();
        printMethod1(methods);
        printMethod2(methods);
    }

    private static void printMethod1(Method[] methods) {
        StringBuilder stringName=new StringBuilder();
        for (Method method : methods) {
            if ((method.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC) {
                if ((method.getModifiers() & Modifier.STATIC) == Modifier.STATIC) {
                    if (method.getReturnType().getSimpleName() == "float")
                        if (method.getName() == "abs")
                            System.out.println(stringName);
                }
            }
        }
    }

    private static void printMethod2(Method[] methods) {
        for (Method method : methods) {
            if ((method.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC) {
                if ((method.getModifiers() & Modifier.STATIC) == Modifier.STATIC) {
                    if (method.getReturnType().getSimpleName() == "double")
                        if (method.getName() == "pow")
                            System.out.println(method);
                }
            }
        }
    }
}
