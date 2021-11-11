package by.it._classwork_.jd01_08;

public class Matrix extends Var {

    private double[][] matrix;

    public Matrix(String stringValues) {
        super();
    }

    public double[][] getMatrix() {
        double[][] clone = matrix.clone();
        for (int i = 0; i < clone.length; i++) {
            clone[i] = matrix[i].clone();
        }
        return clone;
    }

    @Override
    public String toString() {
        return "Matrix{}";
    }
}
