package by.it.vrublevskii.jd01_08;

import java.util.Arrays;

class Matrix extends Var {
    private final double[][] matrix;

    public double[][] getMatrix() {
        double[][] matrixCopy = new double[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            matrixCopy[i] = Arrays.copyOf(matrix[i], matrix[i].length);
        }
        return matrixCopy;
    }

    Matrix(double[][] value) {
        this.matrix = new double[value.length][value[0].length];
        for (int i = 0; i < matrix.length; i++) {
            this.matrix[i] = Arrays.copyOf(value[i], value.length);
        }
    }

    Matrix(Matrix otherMatrix) {
        this.matrix = otherMatrix.matrix;
    }

    Matrix(String stringMatrix) {
        String[] matrixElements;
        String[] matrixRows = stringMatrix.split("}, *\\{");
        this.matrix = initialiseMatrix(matrixRows);
        for (int i = 0; i < matrixRows.length; i++) {
            matrixRows[i] = matrixRows[i].replaceAll("[{|}]", " ");
            matrixElements = matrixRows[i].split(",");
            for (int j = 0; j < matrixElements.length; j++) {
                this.matrix[i][j] = Double.parseDouble(matrixElements[j]);
            }
        }
    }

    private double[][] initialiseMatrix(String[] matrixRows) {
        String[] matrixElements;
        matrixRows[0] = matrixRows[0].replaceAll("[{|}]", " ");
        matrixElements = matrixRows[0].split(", *");
        return new double[matrixRows.length][matrixElements.length];
    }


    @Override
    public Var add(Var other) {
        if (other instanceof Scalar otherScalar) {
            double[][] result = getCopyMatrix();
            for (int i = 0; i < this.matrix.length; i++) {
                for (int j = 0; j < this.matrix[i].length; j++) {
                    result[i][j] += otherScalar.getValue();
                }
            }
            return new Matrix(result);
        }
        if (other instanceof Matrix otherMatrix) {
            double[][] result = getCopyMatrix();
            if (this.matrix.length == otherMatrix.matrix.length && this.matrix[0].length == otherMatrix.matrix[0].length) {
                for (int i = 0; i < this.matrix.length; i++) {
                    for (int j = 0; j < this.matrix[i].length; j++) {
                        result[i][j] += otherMatrix.matrix[i][j];
                    }
                }
                return new Matrix(result);
            }
            System.out.printf("Different matrix sizes %s + %s\n", this, other);
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar otherScalar) {
            double[][] result = getCopyMatrix();
            for (int i = 0; i < this.matrix.length; i++) {
                for (int j = 0; j < this.matrix[i].length; j++) {
                    result[i][j] -= otherScalar.getValue();
                }
            }
            return new Matrix(result);
        }
        if (other instanceof Matrix otherMatrix) {
            double[][] result = getCopyMatrix();
            if (this.matrix.length == otherMatrix.matrix.length && this.matrix[0].length == otherMatrix.matrix[0].length) {
                for (int i = 0; i < this.matrix.length; i++) {
                    for (int j = 0; j < this.matrix[i].length; j++) {
                        result[i][j] -= otherMatrix.matrix[i][j];
                    }
                }
                return new Matrix(result);
            }
            System.out.printf("Different matrix sizes %s - %s\n", this, other);
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar otherScalar) {
            double[][] result = getCopyMatrix();
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    result[i][j] *= otherScalar.getValue();
                }
            }
            return new Matrix(result);
        }
        if (other instanceof Matrix otherMatrix) {
            if (this.matrix[0].length == otherMatrix.matrix.length) {
                double[][] result = new double[this.matrix.length][otherMatrix.matrix[0].length];
                for (int i1 = 0; i1 < otherMatrix.matrix[0].length; i1++) {
                    for (int i = 0; i < this.matrix.length; i++) {
                        for (int j = 0; j < this.matrix[i].length; j++) {
                            result[i][i1] += this.matrix[i][j] * otherMatrix.matrix[j][i1];
                        }
                    }
                }
                return new Matrix(result);
            }
            System.out.printf("Matrices are not equal %s - %s\n", this, other);
        }
        if (other instanceof Vector otherVector) {
            if (this.matrix[0].length == otherVector.getVector().length) {
                double[] result = new double[this.matrix.length];
                    for (int i = 0; i < this.matrix.length; i++) {
                        for (int j = 0; j < this.matrix[i].length; j++) {
                            result[i] += this.matrix[i][j] * otherVector.getVector()[j];
                        }
                    }
                return new Vector(result);
            }
            System.out.printf("Matrices are not equal %s - %s\n", this, other);
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar otherScalar) {
            if (otherScalar.getValue() == 0) {
                System.out.printf("Division by zero %s / %s\n", this, other);
            }
            double[][] result = getCopyMatrix();
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    result[i][j] /= otherScalar.getValue();
                }
            }
            return new Matrix(result);
        }
        return super.div(other);
    }

    private double[][] getCopyMatrix() {
        double[][] result = new double[this.matrix.length][];
        for (int i = 0; i < result.length; i++) {
            result[i] = Arrays.copyOf(this.matrix[i], this.matrix[i].length);
        }
        return result;
    }


    @Override
    public String toString() {
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
                stringMatrix.append(", ");
            }
        }
        stringMatrix.append("}");
        return stringMatrix.toString();
    }
}
