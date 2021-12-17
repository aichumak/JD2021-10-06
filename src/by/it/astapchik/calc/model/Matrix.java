package by.it.astapchik.calc.model;

import by.it.astapchik.calc.exception.CalcException;

import java.util.Arrays;

public class Matrix extends Var {

    private final double[ ][ ] value;

    public Matrix(double[ ][ ] value){ this.value = Arrays.copyOf(value, value.length); }

    public Matrix(Matrix matrix){ this.value = matrix.value; }

    public Matrix(String strMatrix){
        String str = strMatrix.replace('{', ' ');
        String modifiedString1 = str.replace('}', ' ');
        String modifiedString2 = modifiedString1.trim();
        String[] array = modifiedString2.split("[,\\s]+");

        double[][] result = new double[2][2];
        int k = 0;
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = Double.parseDouble(array[k]);
                k++;
            }
        }
        this.value = result;
    }

    public double[ ][ ] getCloneValues() {
        double[ ][ ] clone = new double[this.value.length][];
        for (int i = 0; i < clone.length; i++) {
            clone[i] = Arrays.copyOf(this.value[i], this.value[i].length);
        }
        return clone;
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar otherScalar){
            double[ ][ ] result = getCloneValues();
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[i].length; j++) {
                    result[i][j] = result[i][j] + otherScalar.getValue();
                }
            }
            return new Matrix(result);
        }

        if (other instanceof Matrix otherMatrix){
            if (value.length != otherMatrix.value.length){
                System.out.printf("%s / %s ---> Something is wrong.", this, other);
            }

            double[ ][ ] result = getCloneValues();

            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    result[i][j] = result[i][j] + otherMatrix.value[i][j];
                }
            }
            return new Matrix(result);
        }

        return super.add(other);
    }


    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar otherScalar){
            double[ ][ ] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    result[i][j] = result[i][j] * otherScalar.getValue();
                }
            }
            return new Matrix(result);
        }

        if (other instanceof Matrix otherMatrix){
            if (value.length != otherMatrix.value.length){
                System.out.printf("%s / %s ---> Something is wrong.", this, other);
            }
            double[ ][ ] firstMatrix = Arrays.copyOf(value, value.length);
            double[ ][ ] secondMatrix = Arrays.copyOf(otherMatrix.value, otherMatrix.value.length);

            double[ ][ ] result = new double[firstMatrix.length][secondMatrix.length];

            for (int i = 0; i < firstMatrix.length; i++) {
                for (int j = 0; j < secondMatrix[0].length; j++) {
                    for (int k = 0; k < secondMatrix.length; k++) {
                        result[i][j] = result[i][j] + firstMatrix[i][k] * secondMatrix[k][j];
                    }
                }
            }
            return new Matrix(result);
        }

        if (other instanceof Vector otherVector){
            double[] result = new double[this.value.length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < otherVector.getValue().length; j++) {
                    result[i] = result[i] + this.value[i][j] * otherVector.getValue()[j];
                }
            }
            return new Vector(result);
        }

        return super.mul(other);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar otherScalar){
            double[ ][ ] result = getCloneValues();
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    result[i][j] = result[i][j] - otherScalar.getValue();
                }
            }
            return new Matrix(result);
        }

        if (other instanceof Matrix otherMatrix){
            if (value.length != otherMatrix.value.length){
                System.out.printf("%s / %s ---> Something is wrong.", this, other);
            }

            double[ ][ ] result = getCloneValues();

            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    result[i][j] = result[i][j] - otherMatrix.value[i][j];
                }
            }
            return new Matrix(result);
        }
        return super.sub(other);
    }

    @Override
    public Var div(Var other) throws CalcException {
        return super.div(other);
    }


    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("{");
        String comma = "";
        String s = "";
        for (double [] row : value) {
            string.append(s);
            string.append("{");
            comma = "";
            for (double v : row) {
                string.append(comma).append(v);
                comma = ",";
            }
            string.append("}");
            s = ",";
        }
        string.append("}");

        return string.toString();
    }

}
