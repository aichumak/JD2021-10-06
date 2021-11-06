package by.it._classwork_.jd01_10;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class BeanTester {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<Bean> beanClass = Bean.class;
        Constructor<Bean> constructor = beanClass.getConstructor();
        Bean bean = constructor.newInstance();
        //and so on

    }
}
