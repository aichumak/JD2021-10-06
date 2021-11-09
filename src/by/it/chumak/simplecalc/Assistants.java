package by.it.chumak.simplecalc;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class Assistants {

    public static ArrayList getValues(Var varLeftPartExpression, Var varRightPartExpression) {
        ArrayList list = new ArrayList();
        Field field1 = null;
        Field field2 = null;

            try {
                field1 = varLeftPartExpression.getClass().getDeclaredField("value");
            } catch (NoSuchFieldException e) {
                try {
                    field1 = varLeftPartExpression.getClass().getDeclaredField("values");
                } catch (NoSuchFieldException e2) {
                    e2.printStackTrace();
                }
            }

            try {
                field2 = varRightPartExpression.getClass().getDeclaredField("value");
            } catch (NoSuchFieldException e) {
                try {
                    field2 = varRightPartExpression.getClass().getDeclaredField("values");
                } catch (NoSuchFieldException e2) {
                    e2.printStackTrace();
                }
            }
            field1.setAccessible(true);
            field2.setAccessible(true);

            try {
                if (varLeftPartExpression instanceof Scalar) {
                    double a = (double) field1.get(varLeftPartExpression);
                    list.add(a);
                } else if (varLeftPartExpression instanceof Vector) {
                    double[] a = (double[]) field1.get(varLeftPartExpression);
                    list.add(a);
                } else if (varLeftPartExpression instanceof Matrix) {
                    double[][] a = (double[][]) field1.get(varLeftPartExpression);
                    list.add(a);
                }
            } catch (IllegalAccessException e) {
                list.add(null);
                e.printStackTrace();
            }

            try {
                if (varRightPartExpression instanceof Scalar) {
                    double b = (double) field2.get(varRightPartExpression);
                    list.add(b);
                } else if (varRightPartExpression instanceof Vector) {
                    double[] b = (double[]) field2.get(varRightPartExpression);
                    list.add(b);
                } else if (varRightPartExpression instanceof Matrix) {
                    double[][] b = (double[][]) field2.get(varRightPartExpression);
                    list.add(b);
                }
            } catch (IllegalAccessException e) {
                list.add(null);
                e.printStackTrace();
            }
            return list;
    }
}
