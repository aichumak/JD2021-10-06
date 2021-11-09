package by.it.chumak.simplecalc;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class Assistants {

    public static ArrayList<Object> getValues(Var varLeftPartExpression, Var varRightPartExpression) {
        ArrayList<Object> list = new ArrayList<>();
        Field fieldLeftPartExpression = null;
        Field fieldRightPartExpression = null;

        try {
            fieldLeftPartExpression = varLeftPartExpression.getClass().getDeclaredField("value");
        } catch (NoSuchFieldException e) {
            try {
                fieldLeftPartExpression = varLeftPartExpression.getClass().getDeclaredField("values");
            } catch (NoSuchFieldException e2) {
                e2.printStackTrace();
            }
        }

        try {
            fieldRightPartExpression = varRightPartExpression.getClass().getDeclaredField("value");
        } catch (NoSuchFieldException e) {
            try {
                fieldRightPartExpression = varRightPartExpression.getClass().getDeclaredField("values");
            } catch (NoSuchFieldException e2) {
                e2.printStackTrace();
            }
        }
        if (fieldLeftPartExpression != null && fieldRightPartExpression != null) {
            fieldLeftPartExpression.setAccessible(true);
            fieldRightPartExpression.setAccessible(true);

            try {
                if (varLeftPartExpression instanceof Scalar) {
                    double a = (double) fieldLeftPartExpression.get(varLeftPartExpression);
                    list.add(a);
                } else if (varLeftPartExpression instanceof Vector) {
                    double[] a = (double[]) fieldLeftPartExpression.get(varLeftPartExpression);
                    list.add(a);
                } else if (varLeftPartExpression instanceof Matrix) {
                    double[][] a = (double[][]) fieldLeftPartExpression.get(varLeftPartExpression);
                    list.add(a);
                }
            } catch (IllegalAccessException e) {
                list.add(null);
                e.printStackTrace();
            }

            try {
                if (varRightPartExpression instanceof Scalar) {
                    double b = (double) fieldRightPartExpression.get(varRightPartExpression);
                    list.add(b);
                } else if (varRightPartExpression instanceof Vector) {
                    double[] b = (double[]) fieldRightPartExpression.get(varRightPartExpression);
                    list.add(b);
                } else if (varRightPartExpression instanceof Matrix) {
                    double[][] b = (double[][]) fieldRightPartExpression.get(varRightPartExpression);
                    list.add(b);
                }
            } catch (IllegalAccessException e) {
                list.add(null);
                e.printStackTrace();
            }
            return list;
        }
        return null;
    }
}
