package by.it.vrublevskii.jd01_10;

import java.lang.reflect.Method;

public class BeanTester {
    public static void main(String[] args) throws Exception {
        Class<Bean> cls = Bean.class;
        Method[] declaredMethods = cls.getDeclaredMethods();
        Object o;
        Param ann;
        double result;
        o = cls.getDeclaredConstructor().newInstance();
        for (Method declaredMethod : declaredMethods) {
            if (declaredMethod.isAnnotationPresent(Param.class)){
                ann = declaredMethod.getAnnotation(Param.class);
                result = (double)declaredMethod.invoke(o, ann.a(), ann.b());
                System.out.println(declaredMethod.getName() + ": " + result);
            }
        }
    }
}