package by.it.astapchik.jd01_08;

import by.it.astapchik.jd01_08.Var;

import java.util.Arrays;

class Matrix extends Var {

    private final double[ ][ ] value;

    public Matrix(double[ ][ ] value){
        this.value = Arrays.copyOf(value, value.length);
    }

    public Matrix(Matrix matrix){
        this.value = Arrays.copyOf(matrix.value, matrix.value.length);
    }

    public Matrix(String strMatrix){
        StringBuilder string = new StringBuilder(strMatrix);
        String tostring = string.toString();
        String modifiedString = tostring.replaceAll("[{}]+", "").trim();
        String[] arrayOfNumbers = modifiedString.split(", ");

        double[][] newArray = new double[0][0];
        int counter = 0;
        for (int i = 0; i < newArray.length; i++) {
            for (int i1 = 0; i1 < newArray[0].length; i1++) {
                newArray[i][i1] = Double.parseDouble(arrayOfNumbers[counter]);
                counter ++;
            }
        }
        this.value = newArray;
    }

    public double[][] getValue() { return Arrays.copyOf(value, value.length); }

    @Override
    public Var add(Var other) {
         if (other instanceof Scalar otherScalar){
             double[ ][ ] result = Arrays.copyOf(value, value.length);
             for (int i = 0; i < result.length; i++) {
                 for (int j = 0; j < result.length; j++) {
                     result[i][j] = result[i][j] + otherScalar.getValue();
                 }
             }
             return new Matrix(result);
         }

        if (other instanceof Matrix otherMatrix){
            if (value.length != otherMatrix.value.length){
                System.out.printf("%s / %s ---> Something is wrong.", this, other);
            }
            double[ ][ ] result = Arrays.copyOf(value, value.length);

            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    result[i][j] = result[i][j] + otherMatrix.value[i][j];
                }
            }
            return new Matrix(result);
        }
        return super.add(other);
    }

    @Override
    public Var mul(Var other) {
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
    public Var sub(Var other) {
        if (other instanceof Scalar otherScalar){
            double[ ][ ] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    result[i][j] = result[i][j] - otherScalar.getValue();
                }
            }
            return new Matrix(result).mul(new Scalar(-1));
        }

        if (other instanceof Matrix otherMatrix){
            if (value.length != otherMatrix.value.length){
                System.out.printf("%s / %s ---> Something is wrong.", this, other);
            }

            double[ ][ ] result = Arrays.copyOf(value, value.length);

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
    public Var div(Var other) {
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
                comma = ", ";
            }
            string.append("}");
            s = ", ";
        }
        string.append("}");

        return string.toString();
    }

}
