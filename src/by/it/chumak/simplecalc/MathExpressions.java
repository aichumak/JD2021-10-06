package by.it.chumak.simplecalc;

import java.util.ArrayList;
import java.util.Arrays;

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
        ArrayList values = Assistants.getValues(varLeftPartExpression, varRightPartExpression);

        if (varLeftPartExpression.getClass().getSimpleName() == varRightPartExpression.getClass().getSimpleName()) {
            if (varLeftPartExpression instanceof Scalar) {
                return new Scalar((double) values.get(0) - (double) values.get(1));
            } else if (varLeftPartExpression instanceof Vector) {
                return getVectorSubVector((double[]) values.get(0), (double[]) values.get(1));
            } else if (varLeftPartExpression instanceof Matrix) {
                return getMatrixSubMatrix((double[][]) values.get(0), (double[][]) values.get(1));
            }
        }

        if (varLeftPartExpression instanceof Scalar && varRightPartExpression instanceof Vector) {
            return getVectorSubScalar((double) values.get(0), (double[]) values.get(1));
        } else if (varLeftPartExpression instanceof Vector && varRightPartExpression instanceof Scalar) {
            return getVectorSubScalar((double) values.get(1), (double[]) values.get(0));
        } else if (varLeftPartExpression instanceof Scalar && varRightPartExpression instanceof Matrix) {
            return getMatrixSubScalar((double) values.get(0), (double[][]) values.get(1));
        } else if (varLeftPartExpression instanceof Matrix && varRightPartExpression instanceof Scalar) {
            return getMatrixSubScalar((double) values.get(1), (double[][]) values.get(0));
        }
        return null;

    }

    @Override
    public Var mul(Var varLeftPartExpression, Var varRightPartExpression) {
        ArrayList values = Assistants.getValues(varLeftPartExpression, varRightPartExpression);

        if (varLeftPartExpression.getClass().getSimpleName() == varRightPartExpression.getClass().getSimpleName()) {
            if (varLeftPartExpression instanceof Scalar) {
                return new Scalar((double) values.get(0) * (double) values.get(1));
            } else if (varLeftPartExpression instanceof Vector) {
                return getVectorMulVector((double[]) values.get(0), (double[]) values.get(1));
            } else if (varLeftPartExpression instanceof Matrix) {
                return getMatrixMulMatrix((double[][]) values.get(0), (double[][]) values.get(1));
            }
        }

        if (varLeftPartExpression instanceof Scalar && varRightPartExpression instanceof Vector) {
            return getVectorMulScalar((double) values.get(0), (double[]) values.get(1));
        } else if (varLeftPartExpression instanceof Vector && varRightPartExpression instanceof Scalar) {
            return getVectorMulScalar((double) values.get(1), (double[]) values.get(0));
        } else if (varLeftPartExpression instanceof Scalar && varRightPartExpression instanceof Matrix) {
            return getMatrixMulScalar((double) values.get(0), (double[][]) values.get(1));
        } else if (varLeftPartExpression instanceof Matrix && varRightPartExpression instanceof Scalar) {
            return getMatrixMulScalar((double) values.get(1), (double[][]) values.get(0));
        } else if (varLeftPartExpression instanceof Vector && varRightPartExpression instanceof Matrix) {
            return getVectorMulMatrix((double[]) values.get(0), (double[][]) values.get(1));
        } else if (varLeftPartExpression instanceof Matrix && varRightPartExpression instanceof Vector) {
            return getVectorMulMatrix((double[]) values.get(1), (double[][]) values.get(0));
        }

        return null;
    }

    @Override
    public Var div(Var varLeftPartExpression, Var varRightPartExpression) {
        ArrayList values = Assistants.getValues(varLeftPartExpression, varRightPartExpression);

        if (varLeftPartExpression.getClass().getSimpleName() == varRightPartExpression.getClass().getSimpleName()) {
            if (varLeftPartExpression instanceof Scalar) {
                return new Scalar((double) values.get(0) / (double) values.get(1));
            }
        }

        if (varLeftPartExpression instanceof Scalar && varRightPartExpression instanceof Vector) {
            return getVectorDivScalar((double) values.get(0), (double[]) values.get(1));
        } else if (varLeftPartExpression instanceof Vector && varRightPartExpression instanceof Scalar) {
            return getVectorDivScalar((double) values.get(1), (double[]) values.get(0));
        } else if (varLeftPartExpression instanceof Scalar && varRightPartExpression instanceof Matrix) {
            return getMatrixDivScalar((double) values.get(0), (double[][]) values.get(1));
        } else if (varLeftPartExpression instanceof Matrix && varRightPartExpression instanceof Scalar) {
            return getMatrixDivScalar((double) values.get(1), (double[][]) values.get(0));
        }

        return null;
    }

    private Var getMatrixSubScalar(double a, double[][] b) {
        double[][] result = new double[b.length][b[0].length];

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = b[i][j] - a;
            }
        }
        return new Matrix(result);
    }

    private Var getVectorSubScalar(double a, double[] b) {
        double[] result = new double[b.length];

        for (int i = 0; i < result.length; i++) {
            result[i] = b[i] - a;
        }
        return new Vector(result);
    }

    private Var getMatrixSubMatrix(double[][] a, double[][] b) {
        double[][] result = new double[a.length][a[0].length];

        //TODO Throws exception Incorrect operation
        if (result.length != b.length) {
            System.out.printf("Incorrect operation");
        }
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result.length; j++) {
                result[i][j] = a[i][j] - b[i][j];
            }
        }
        return new Matrix(result);
    }

    private Var getVectorSubVector(double[] a, double[] b) {
        double[] result = new double[a.length];

        //TODO Throws exception Incorrect operation
        if (result.length != b.length) {
            System.out.printf("Incorrect operation");
        }
        for (int i = 0; i < result.length; i++) {
            result[i] = a[i] - b[i];
        }
        return new Vector(result);
    }

    private Var getVectorMulMatrix(double[] a, double[][] b) {
        double[] result = new double[a.length];
        double[][] arrayOtherMatrix = b;
        int verticalVectorSize = arrayOtherMatrix[0].length;
        int horizontalVectorSize = a.length;

        //TODO Throws exception Incorrect operation
        if (verticalVectorSize != horizontalVectorSize) {
            System.out.printf("Incorrect operation");
            //return null;
        }
        for (int i = 0; i < horizontalVectorSize; i++) {
            for (int j = 0; j < result.length; j++) {
                result[i] = result[i] + (arrayOtherMatrix[i][j]) * (a[j]);
            }
        }
        return new Vector(result);

    }

    private Var getMatrixMulScalar(double a, double[][] b) {
        double[][] result = new double[b.length][b[0].length];

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = b[i][j] * a;
            }
        }
        return new Matrix(result);
    }

    private Var getVectorMulScalar(double a, double[] b) {
        double[] result = new double[b.length];

        for (int i = 0; i < result.length; i++) {
            result[i] = b[i] * a;
        }
        return new Vector(result);
    }

    private Var getMatrixMulMatrix(double[][] a, double[][] b) {
        double[][] result = new double[a.length][a[0].length];
        double[][] arrayOtherMatrix = b;
        int verticalMatrixSize = a[0].length;
        int horizontalMatrixSize = arrayOtherMatrix.length;

        //TODO Throws exception Incorrect operation
        if (verticalMatrixSize != horizontalMatrixSize) {
            System.out.printf("Incorrect operation");
        }

        for (int i = 0; i < verticalMatrixSize; i++) {
            for (int j = 0; j < horizontalMatrixSize; j++) {
                for (int k = 0; k < result.length; k++) {
                    result[i][j] = result[i][j] + (a[i][k]) * (arrayOtherMatrix[k][j]);
                }
            }
        }
        return new Matrix(result);
    }

    private Var getVectorMulVector(double[] a, double[] b) {
        double[] result = new double[1];
        //TODO Throws exception Incorrect operation
        if (a.length != b.length) {
            System.out.printf("Incorrect operation");
        }
        for (int i = 0; i < a.length; i++) {
            result[0] = result[0] + (a[i] * b[i]);
        }
        return new Vector(result);
    }

    private Var getMatrixDivScalar(double a, double[][] b) {
        double[][] result = Arrays.copyOf(b, b.length);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = result[i][j] / a;
            }
        }
        return new Matrix(result);
    }

    private Var getVectorDivScalar(double a, double[] b) {
        double[] result = new double[b.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = b[i] / a;
        }
        return new Vector(result);
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
