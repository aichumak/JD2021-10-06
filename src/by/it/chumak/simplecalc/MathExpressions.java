package by.it.chumak.simplecalc;

import java.util.ArrayList;

public class MathExpressions implements Operation {

    @Override
    public Var add(Var varLeftPartExpression, Var varRightPartExpression) {
        ArrayList values = Assistants.getValues(varLeftPartExpression, varRightPartExpression);

        if (varLeftPartExpression.getClass().getSimpleName() == varRightPartExpression.getClass().getSimpleName()) {
            if (varLeftPartExpression instanceof Scalar) {
                return new Scalar((double) values.get(0) + (double) values.get(1));
            } else if (varLeftPartExpression instanceof Vector) {
                return getVectorAddVector((double[]) values.get(0), (double[]) values.get(1));
            } else if (varLeftPartExpression instanceof Matrix) {
                return getMatrixAddMatrix((double[][]) values.get(0), (double[][]) values.get(1));
            }
        }

        if (varLeftPartExpression instanceof Scalar && varRightPartExpression instanceof Vector) {
            return getVectorAddScalar((double) values.get(0), (double[]) values.get(1));
        } else if (varLeftPartExpression instanceof Vector && varRightPartExpression instanceof Scalar) {
            return getVectorAddScalar((double) values.get(1), (double[]) values.get(0));
        } else if (varLeftPartExpression instanceof Scalar && varRightPartExpression instanceof Matrix) {
            return getMatrixAddScalar((double) values.get(0), (double[][]) values.get(1));
        } else if (varLeftPartExpression instanceof Matrix && varRightPartExpression instanceof Scalar) {
            return getMatrixAddScalar((double) values.get(1), (double[][]) values.get(0));
        }

        return null;
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

    private Var getMatrixAddMatrix(double[][] a, double[][] b) {
        double[][] result = new double[a.length][a[0].length];
        //TODO Throws exception Incorrect operation
        if (result.length != b.length) {
            System.out.printf("Incorrect operation");
        }
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = a[i][j] + b[i][j];
            }
        }
        return new Matrix(result);
    }

    private Var getMatrixAddScalar(double a, double[][] b) {
        double[][] result = new double[b.length][b[0].length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = b[i][j] + a;
            }
        }
        return new Matrix(result);
    }

    private Vector getVectorAddVector(double[] a, double[] b) {
        double[] result = new double[a.length];
        //TODO Throws exception Incorrect operation
        if (result.length != b.length) {
            System.out.printf("Incorrect operation");
        }
        for (int i = 0; i < result.length; i++) {
            result[i] = a[i] + b[i];
        }
        return new Vector(result);
    }

    private Vector getVectorAddScalar(double a, double[] b) {
        double[] result = new double[b.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = b[i] + a;
        }
        return new Vector(result);
    }
}
