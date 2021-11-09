package by.it.chumak.simplecalc;

import java.lang.reflect.Field;
import java.util.ArrayList;

class ScalarMethods implements Operation {

    @Override
    public Var add(Var varLeftPartExpression, Var varRightPartExpression) {
        ArrayList values = Assistants.getValues(varLeftPartExpression, varRightPartExpression);
//        Field field1 = null;
//        Field field2 = null;
//        try {
//            field1 = varLeftPartExpression.getClass().getDeclaredField("value");
//            field2 = varRightPartExpression.getClass().getDeclaredField("value");
//            field1.setAccessible(true);
//            field2.setAccessible(true);
//            try {
//                double a = (double) field1.get(varLeftPartExpression);
//                double b = (double) field2.get(varRightPartExpression);
//                return new Scalar(a + b);
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            }
//        } catch (NoSuchFieldException e) {
//            e.printStackTrace();
//        }
            if (values.get(0) != null && values.get(1) != null) {
                return new Scalar((double) values.get(0) + (double) values.get(1));
            }
        return null;
    }

    @Override
    public Var sub(Var varLeftPartExpression, Var varRightPartExpression) {
//        Field field1 = null;
//        Field field2 = null;
//
//        if (other instanceof Scalar otherScalar) {
//            return new Scalar(this.value - otherScalar.value);
//        }
//
//        return other.sub(this).mul(new Scalar(-1));

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
