package by.it.kanaplianik.jd01_08;

public class Matrix extends Var {
    private final double[][] matrixValue;

    public Matrix(double[][] value) {
        matrixValue = value;
    }

    public Matrix(Matrix matrix) {
        matrixValue = matrix.matrixValue;
    }

    public int getRowCount() {
        return matrixValue.length;
    }

    public int getColumnCount() {
        return matrixValue[0].length;
    }

    public double getValue(int i, int j) {
        return matrixValue[i][j];
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
        StringBuilder result = new StringBuilder("{");
        for (int i = 0; i < matrixValue.length; i++) {
            if (i < matrixValue.length - 1) {
                result.append(matrixRowToString(matrixValue[i])).append(", ");
            } else {
                result.append(matrixRowToString(matrixValue[i])).append("}");
            }
        }
        return result.toString();
    }

    public String matrixRowToString(double[] vectorValue) {
        StringBuilder result = new StringBuilder("{");
        for (int i = 0; i < vectorValue.length; i++) {
            if (i < vectorValue.length - 1) {
                result.append(vectorValue[i]).append(", ");
            } else {
                result.append(vectorValue[i]).append("}");
            }
        }
        return result.toString();
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar otherScalar) {
            double[][] result = new double[this.getRowCount()][this.getColumnCount()];
            for (int i = 0; i < this.getRowCount(); i++) {
                for (int k = 0; k < getColumnCount(); k++) {
                    result[i][k] = this.getValue(i, k) + otherScalar.getValue();
                }

            }
            return new Matrix(result);
        }

        if (other instanceof Matrix otherMatrix) {
            double[][] result = new double[this.getRowCount()][this.getColumnCount()];
            for (int i = 0; i < this.getRowCount(); i++) {
                for (int k = 0; k < getColumnCount(); k++) {
                    result[i][k] = this.getValue(i, k) + otherMatrix.getValue(i, k);
                }

            }
            return new Matrix(result);
        }
        return null;
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar otherScalar) {
            double[][] result = new double[this.getRowCount()][this.getColumnCount()];
            for (int i = 0; i < this.getRowCount(); i++) {
                for (int k = 0; k < getColumnCount(); k++) {
                    result[i][k] = this.getValue(i, k) - otherScalar.getValue();
                }

            }
            return new Matrix(result);
        }

        if (other instanceof Matrix otherMatrix) {
            double[][] result = new double[this.getRowCount()][this.getColumnCount()];
            for (int i = 0; i < this.getRowCount(); i++) {
                for (int k = 0; k < getColumnCount(); k++) {
                    result[i][k] = this.getValue(i, k) - otherMatrix.getValue(i, k);
                }

            }
            return new Matrix(result);
        }
        return null;
    }


    @Override
    public Var mul(Var other) {

        if (other instanceof Scalar otherScalar) {
            double[][] result = new double[this.getRowCount()][this.getColumnCount()];
            for (int i = 0; i < this.getRowCount(); i++) {
                for (int k = 0; k < getColumnCount(); k++) {
                    result[i][k] = this.getValue(i, k) * otherScalar.getValue();
                }

            }
            return new Matrix(result);
        }

        if (other instanceof Matrix otherMatrix) {
            int l = this.getRowCount();
            int m = this.getColumnCount();
            int k = otherMatrix.getRowCount();
            int n = otherMatrix.getColumnCount();

            if (m == k) {
                double[][] result = new double[this.getRowCount()][this.getColumnCount()];
                for (int i = 0; i < l; i++) {
                    for (int j = 0; j < n; j++) {
                        for (int o = 0; o < m; o++) {
                            result[i][j] += this.getValue(i, o) * otherMatrix.getValue(o, j);
                        }
                    }
                }
                return new Matrix(result);
            } else {
                return null;
            }
        }

        if (other instanceof Vector otherVector) {
            double[] result = new double[this.getRowCount()];
            for (int i = 0; i < this.getRowCount(); i++) {
                for (int k = 0; k < getColumnCount(); k++) {
                    result[i] = result [i] + (this.getValue(i, k) * otherVector.getValue(k));
                }

            }
            return new Vector(result);
        }

        return null;
    }

    @Override
    public Var div(Var other) {
        return null;
    }
}
