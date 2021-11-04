package by.it.chumak.jd01_08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Matrix extends Var {

    private final double[][] values;

    public Matrix(double[][] value) {
        this.values = Arrays.copyOf(value, value.length);
    }

    public Matrix(Matrix matrix) {
        this.values = matrix.values;
    }

    public Matrix(String strMatrix) {
        double[][] resultArray;
        ArrayList<String[]> allStringArrays = new ArrayList<>();
        int countRows = 0;
        int maxCountSubstrings = 0;
        strMatrix = strMatrix.replaceAll(" ", "");
        StringBuilder str = new StringBuilder(strMatrix);
        Pattern pattern = Pattern.compile("[0-9,]+[^\\{|^\\}]");
        Matcher matcher = pattern.matcher(str);

        while (matcher.find()) {
            countRows++;
            String[] tempStringArray = matcher.group().trim().split(",");
            allStringArrays.add(tempStringArray);
            if (maxCountSubstrings < tempStringArray.length) {
                maxCountSubstrings = tempStringArray.length;
            }
        }

        resultArray = new double[countRows][maxCountSubstrings];

        for (int i = 0; i < resultArray.length; i++) {
            String[] tempArray = allStringArrays.get(i);
            for (int j = 0; j < tempArray.length; j++) {
                resultArray[i][j] = Double.parseDouble(tempArray[j]);
            }
        }
        this.values = resultArray;
    }

    public double[][] getValues() {
        return Arrays.copyOf(values, values.length);
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar otherScalar) {
            double[][] result = new double[this.values.length][this.values[0].length];

            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    result[i][j] = this.values[i][j] + otherScalar.getValue();
                }
            }
            return new Matrix(result);
        }
        if (other instanceof Matrix otherMatrix) {
            double[][] result = new double[this.values.length][this.values[0].length];
            double[][] otherMatrixCopy = otherMatrix.getValues();
            //TODO Throws exception Incorrect operation
            if (result.length != otherMatrixCopy.length) {
                System.out.printf("Incorrect operation %s + %s", this, otherMatrix);
            }
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    result[i][j] = this.values[i][j] + otherMatrixCopy[i][j];
                }
            }
            return new Matrix(result);
        }

        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar otherScalar) {
            double[][] result = new double[this.values.length][this.values[0].length];

            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    result[i][j] = this.values[i][j] - otherScalar.getValue();
                }
            }
            return new Matrix(result);
        }
        if (other instanceof Matrix otherMatrix) {
            double[][] result = new double[this.values.length][this.values[0].length];

            //TODO Throws exception Incorrect operation
            if (result.length != otherMatrix.values.length) {
                System.out.printf("Incorrect operation %s + %s", this, otherMatrix);
            }
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    result[i][j] = this.values[i][j] - otherMatrix.values[i][j];
                }
            }
            return new Matrix(result);
        }

        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar otherScalar) {
            double[][] result = new double[this.values.length][this.values[0].length];

            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    result[i][j] = this.values[i][j] * otherScalar.getValue();
                }
            }
            return new Matrix(result);
        }
        if (other instanceof Matrix otherMatrix) {
            double[][] result = new double[this.values.length][this.values[0].length];
            double[][] arrayOtherMatrix = otherMatrix.getValues();
            int verticalMatrixSize = this.values[0].length;
            int horizontalMatrixSize = arrayOtherMatrix.length;

            //TODO Throws exception Incorrect operation
            if (verticalMatrixSize != horizontalMatrixSize) {
                System.out.printf("Incorrect operation %s + %s", this, otherMatrix);
                //return null;
            }

            for (int i = 0; i < verticalMatrixSize; i++) {
                for (int j = 0; j < horizontalMatrixSize; j++) {
                    for (int k = 0; k < result.length; k++) {
                        result[i][j] = result[i][j] + (this.values[i][k]) * (arrayOtherMatrix[k][j]);
                    }
                }
            }
            return new Matrix(result);
        }

        return other.mul(this);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar otherScalar) {
            double[][] result = Arrays.copyOf(this.values, this.values.length);
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    result[i][j] = result[i][j] / otherScalar.getValue();
                }
            }
            return new Matrix(result);
        }

        return super.div(other);
    }

    @Override
    public String toString() {
        StringBuilder stringLine = new StringBuilder();
        stringLine.append("{");
        String delimiter;

        for (int i = 0; i < values.length; i++) {
            stringLine.append("{");
            delimiter = "";

            for (int j = 0; j < values[i].length; j++) {
                if (j == values[i].length - 1) {
                    stringLine.append(delimiter);
                    stringLine.append(values[i][j]);
                    break;
                }
                stringLine.append(delimiter);
                stringLine.append(values[i][j]);
                delimiter = ", ";
            }
            if (i < values.length - 1) {
                stringLine.append("}, ");
            } else {
                stringLine.append("}");
            }
        }

        stringLine.append("}");
        return stringLine.toString();
    }
}
