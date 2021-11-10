package by.it.drankevich.jd01_10;

import java.lang.reflect.Method;

public class BeanTester {
    public static void main(String[] args) throws Exception {
        Class<Bean> beanClass = Bean.class;
        Bean bean1 = beanClass.getDeclaredConstructor().newInstance();



        Method[] methods = beanClass.getDeclaredMethods();
        for (Method method : methods) {

            if (method.isAnnotationPresent(Param.class)) {
                Param annotation = method.getAnnotation(Param.class);
                int avalue = annotation.a();
                int bvalue = annotation.b();

                System.out.println(method.getName() + " " + method.invoke(bean1, avalue, bvalue));

            }


        }

    }
}
