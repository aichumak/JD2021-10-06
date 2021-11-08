package by.it.chumak.simplecalc;

import java.lang.reflect.Field;

public class MatrixMethods implements Operation{
    @Override
    public Var add(Var varLeftPartExpression, Var varRightPartExpression) {
        Field field1 = null;
        Field field2 = null;
        boolean field1IsDouble = false;
        try {
            try {
                field1 = varLeftPartExpression.getClass().getDeclaredField("values");
            } catch (NoSuchFieldException e) {
                field1 = varLeftPartExpression.getClass().getDeclaredField("value");
                field1IsDouble = true;
            }
            field2 = varRightPartExpression.getClass().getDeclaredField("values");
            field1.setAccessible(true);
            field2.setAccessible(true);
            try {
                double[][] b = (double[][]) field2.get(varRightPartExpression);
                if (field1IsDouble) {
                    double a = (double) field1.get(varLeftPartExpression);
                    return getMatrixAddScalar(a, b);
                } else {
                    double[][] a = (double[][]) field1.get(varLeftPartExpression);
                    return getMatrixAddMatrix(a, b);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
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

    @Override
    public Var sub(Var varLeftPartExpression, Var varRightPartExpression) {
//        if (other instanceof Scalar otherScalar) {
//            double[][] result = new double[this.values.length][this.values[0].length];
//
//            for (int i = 0; i < result.length; i++) {
//                for (int j = 0; j < result[i].length; j++) {
//                    result[i][j] = this.values[i][j] - otherScalar.getValue();
//                }
//            }
//            return new Matrix(result);
//        }
//        if (other instanceof Matrix otherMatrix) {
//            double[][] result = new double[this.values.length][this.values[0].length];
//
//            //TODO Throws exception Incorrect operation
//            if (result.length != otherMatrix.values.length) {
//                System.out.printf("Incorrect operation %s + %s", this, otherMatrix);
//            }
//            for (int i = 0; i < result.length; i++) {
//                for (int j = 0; j < result.length; j++) {
//                    result[i][j] = this.values[i][j] - otherMatrix.values[i][j];
//                }
//            }
//            return new Matrix(result);
//        }

        return null;
    }

    @Override
    public Var mul(Var varLeftPartExpression, Var varRightPartExpression) {
//        if (other instanceof Scalar otherScalar) {
//            double[][] result = new double[this.values.length][this.values[0].length];
//
//            for (int i = 0; i < result.length; i++) {
//                for (int j = 0; j < result[i].length; j++) {
//                    result[i][j] = this.values[i][j] * otherScalar.getValue();
//                }
//            }
//            return new Matrix(result);
//        }
//        if (other instanceof Matrix otherMatrix) {
//            double[][] result = new double[this.values.length][this.values[0].length];
//            double[][] arrayOtherMatrix = otherMatrix.getValues();
//            int verticalMatrixSize = this.values[0].length;
//            int horizontalMatrixSize = arrayOtherMatrix.length;
//
//            //TODO Throws exception Incorrect operation
//            if (verticalMatrixSize != horizontalMatrixSize) {
//                System.out.printf("Incorrect operation %s + %s", this, otherMatrix);
//                //return null;
//            }
//
//            for (int i = 0; i < verticalMatrixSize; i++) {
//                for (int j = 0; j < horizontalMatrixSize; j++) {
//                    for (int k = 0; k < result.length; k++) {
//                        result[i][j] = result[i][j] + (this.values[i][k]) * (arrayOtherMatrix[k][j]);
//                    }
//                }
//            }
//            return new Matrix(result);
//        }
        return null;
    }

    @Override
    public Var div(Var varLeftPartExpression, Var varRightPartExpression) {
//        if (other instanceof Scalar otherScalar) {
//            double[][] result = Arrays.copyOf(this.values, this.values.length);
//            for (int i = 0; i < result.length; i++) {
//                for (int j = 0; j < result[i].length; j++) {
//                    result[i][j] = result[i][j] / otherScalar.getValue();
//                }
//            }
//            return new Matrix(result);
//        }

        return null;
    }
}
