package by.it.drankevich.jd01_10;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class BeanTester {
    public static void main(String[] args) throws Exception {
        Class<Bean> beanClass = Bean.class;
        Bean bean1 = beanClass.getDeclaredConstructor().newInstance();
        Class<Param> paramClass = Param.class;
        Method a = paramClass.getMethod("a");
        Method b = paramClass.getMethod("b");


        Method[] methods = beanClass.getDeclaredMethods();
        for (Method method : methods) {

            if (method.isAnnotationPresent(paramClass)) {
                Annotation annotation = method.getAnnotation(paramClass);
                int avalue = (int) a.invoke(annotation);
                int bvalue = (int) b.invoke(annotation);

                System.out.println(method.getName() + " " + method.invoke(bean1, avalue, bvalue));

            }


        }

    }
}
