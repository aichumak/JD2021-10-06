package by.it.chumak.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class BeanTester {
    public static void main(String[] args) throws Exception {
        Class<?> beanClass = Bean.class;
        Method[] arrayMethods = beanClass.getDeclaredMethods();
        Param annParam;
        double result;

        for (Method method : arrayMethods) {
            if (method.isAnnotationPresent(Param.class)) {
                if (Modifier.isStatic(method.getModifiers())) {
                    annParam = method.getAnnotation(Param.class);
                    result = (double) method.invoke(beanClass, annParam.a(), annParam.b());
                } else {
                    Object instanceClass = beanClass.newInstance();
                    annParam = method.getAnnotation(Param.class);
                    result = (double) method.invoke(instanceClass, annParam.a(), annParam.b());
                }
                System.out.println(method.getName() + " " + result);
            }
        }
    }
}
