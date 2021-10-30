package by.it.kanaplianik.jd01_07;

public class Matrix extends Var {
    private final double [][] matrixValue;

    public Matrix(double[][] value) {
        matrixValue = value;
    }

    public Matrix(Matrix matrix) {
        matrixValue = matrix.matrixValue;
    }

    public Matrix(String value) {
        // "{ { 1.0, 2.0 }, { 3.0, 4.0 } }"
        String[] matrixSplitted = value.split("},");
        double[][] valueM = new double[matrixSplitted.length][];
        for (int i = 0; i < matrixSplitted.length; i++) {
            Vector vectorM = new Vector(matrixSplitted[i]);
            valueM[i] = vectorM.getValue();
        }
        matrixValue = valueM;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("{ ");
        for (int i = 0; i < matrixValue.length; i++) {
            if (i < matrixValue.length - 1) {
                result.append(matrixRowToString(matrixValue[i])).append(", ");
            }
            else {
                result.append(matrixRowToString(matrixValue[i])).append(" }");
            }
        }
        return result.toString();
    }

    public String matrixRowToString(double[] vectorValue) {
        StringBuilder result = new StringBuilder("{ ");
        for (int i = 0; i < vectorValue.length; i++) {
            if (i < vectorValue.length - 1) {
                result.append(vectorValue[i]).append(", ");
            }
            else {
                result.append(vectorValue[i]).append(" }");
            }
        }
        return result.toString();
    }
}
