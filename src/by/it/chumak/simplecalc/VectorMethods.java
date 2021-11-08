package by.it.chumak.simplecalc;

import java.lang.reflect.Field;

public class VectorMethods implements Operation {

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
                double[] b = (double[]) field2.get(varRightPartExpression);
                if (field1IsDouble) {
                    double a = (double) field1.get(varLeftPartExpression);
                    return getVectorAddScalar(a, b);
                } else {
                    double[] a = (double[]) field1.get(varLeftPartExpression);
                    return getVectorAddVector(a, b);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return null;
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

    @Override
    public Var sub(Var varLeftPartExpression, Var varRightPartExpression) {
        return null;
//        if (other instanceof Scalar otherScalar) {
//            double[] result = new double[this.values.length];
//
//            for (int i = 0; i < result.length; i++) {
//                result[i] = this.values[i] - otherScalar.getValue();
//            }
//            return new Vector(result);
//        }
//        if (other instanceof Vector otherVector) {
//            double[] result = new double[this.values.length];
//
//            //TODO Throws exception Incorrect operation
//            if (result.length != otherVector.values.length) {
//                System.out.printf("Incorrect operation %s + %s", this, otherVector);
//            }
//            for (int i = 0; i < result.length; i++) {
//                result[i] = this.values[i] - otherVector.values[i];
//            }
//            return new Vector(result);
//        }
//
//        return super.sub(other);
    }

    @Override
    public Var mul(Var varLeftPartExpression, Var varRightPartExpression) {
        return null;
//        if (other instanceof Scalar otherScalar) {
//            double[] result = new double[this.values.length];
//
//            for (int i = 0; i < result.length; i++) {
//                result[i] = this.values[i] * otherScalar.getValue();
//            }
//            return new Vector(result);
//        }
//        if (other instanceof Vector otherVector) {
//            double[] result = new double[1];
//            //TODO Throws exception Incorrect operation
//            if (this.values.length != otherVector.values.length) {
//                System.out.printf("Incorrect operation %s - %s", this, otherVector);
//            }
//            for (int i = 0; i < this.values.length; i++) {
//                result[0] = result[0] + (this.values[i] * otherVector.values[i]);
//            }
//            return new Vector(result);
//        }
//        if (other instanceof Matrix otherMatrix) {
//            double[] result = new double[this.values.length];
//            double[][] arrayOtherMatrix = otherMatrix.getValues();
//            int verticalVectorSize = arrayOtherMatrix[0].length;
//            int horizontalVectorSize = this.values.length;
//
//            //TODO Throws exception Incorrect operation
//            if (verticalVectorSize != horizontalVectorSize) {
//                System.out.printf("Incorrect operation %s + %s", this, otherMatrix);
//                //return null;
//            }
//            for (int i = 0; i < horizontalVectorSize; i++) {
//                for (int j = 0; j < result.length; j++) {
//                    result[i] = result[i] + (arrayOtherMatrix[i][j]) * (this.values[j]);
//                }
//            }
//            return new Vector(result);
//        }
//
//        return super.sub(other);
    }

    @Override
    public Var div(Var varLeftPartExpression, Var varRightPartExpression) {
        return null;
//        if (other instanceof Scalar otherScalar) {
//            double[] result = new double[this.values.length];
//
//            for (int i = 0; i < result.length; i++) {
//                result[i] = this.values[i] / otherScalar.getValue();
//            }
//            return new Vector(result);
//        }
//
//        return super.div(other);
    }

}
