package by.it.chumak.simplecalc;

import java.lang.reflect.Field;

class ScalarMethods implements Operation {

    @Override
    public Var add(Var varLeftPartExpression, Var varRightPartExpression) {
        Field field1 = null;
        Field field2 = null;
        try {
            field1 = varLeftPartExpression.getClass().getDeclaredField("value");
            field2 = varRightPartExpression.getClass().getDeclaredField("value");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        field1.setAccessible(true);
        field2.setAccessible(true);
        try {
            double a = (double) field1.get(varLeftPartExpression);
            double b = (double) field2.get(varLeftPartExpression);
            return new Scalar(a + b);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return new Scalar(1);
    }

    @Override
    public Var sub(Var varLeftPartExpression, Var varRightPartExpression) {
        return null;
    }

    @Override
    public Var mul(Var varLeftPartExpression, Var varRightPartExpression) {
        return null;
    }

    @Override
    public Var div(Var varLeftPartExpression, Var varRightPartExpression) {
        return null;
    }
}
