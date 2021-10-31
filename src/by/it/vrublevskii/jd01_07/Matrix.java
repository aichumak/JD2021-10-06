package by.it.vrublevskii.jd01_07;

import java.util.Arrays;

public class Matrix extends Var {
    private final double[][] matrix;


    public Matrix(double[][] value) {
        this.matrix = new double[value.length][value[0].length];
        for (int i = 0; i < matrix.length; i++) {
            this.matrix[i] = Arrays.copyOf(value[i], value.length);
        }
    }

    public Matrix(Matrix otherMatrix) {
        this.matrix = otherMatrix.matrix;
    }

    public Matrix(String stringMatrix) {
        String[] matrixElements;
        String[] matrixRows = stringMatrix.split("},\\{");
        double[][] newDoubleMatrix = getArraysSize(matrixRows);
        for (int i = 0; i < matrixRows.length; i++) {
            matrixRows[i] = matrixRows[i].replaceAll("[{|}]", " ");
            matrixElements = matrixRows[i].split(",");
            for (int j = 0; j < matrixElements.length; j++) {
                newDoubleMatrix[i][j] = Double.parseDouble(matrixElements[j]);
            }
        }
        this.matrix = newDoubleMatrix;
    }

    private double[][] getArraysSize(String[] matrixRows) {
        String[] matrixElements;
        matrixRows[0] = matrixRows[0].replaceAll("[{|}]", " ");
        matrixElements = matrixRows[0].split(",");
        return new double[matrixRows.length][matrixElements.length];
    }

    @Override
        public String toString () {
            StringBuilder stringMatrix = new StringBuilder();
            stringMatrix.append("{");
            for (int j = 0; j < matrix.length; j++) {
                stringMatrix.append("{");
                for (int i = 0; i < matrix[j].length; i++) {
                    if (i != 0) {
                        stringMatrix.append(", ");
                    }
                    stringMatrix.append(matrix[j][i]);
                }
                stringMatrix.append("}");
                if (j != matrix.length - 1) {
                    stringMatrix.append(",");
                }
            }
            stringMatrix.append("}");
            return stringMatrix.toString();
        }
    }
