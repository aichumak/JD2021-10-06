package by.it.ithoitan.jd01_08;

import java.util.Arrays;


class Matrix extends Var {
    private final double[][] values;

    public Matrix(double[][] values) {
        this.values = Arrays.copyOf(values, values.length);
    }

    public Matrix(Matrix otherMatrix) {
        values = otherMatrix.values;
    }

    public Matrix(String stringValues) {
        String s = stringValues.replace("{{", "").replace("}}", "").replace("{", "").replace(",", " ");
        String trim = s.trim();
        String[] arr1 = trim.split("}");
        int columns = arr1[0].split(" ").length;
        String s2 = stringValues.replaceAll("[\\W]+", " ").trim();
        String[] arr3 = s2.split(" ");
        double[][] matrix = new double[arr1.length][columns];
        int k = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = Double.parseDouble(arr3[k]);
                k++;
            }
        }
        values = matrix;

    }

    @Override
    public Var add(Var other) {
        if(other instanceof Scalar otherScalar){
            double[][] result = Arrays.copyOf(values,values.length);
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    result[i][j] = result[i][j]+otherScalar.getValue();
                }
            }
            return new Matrix(result);
        }
        if(other instanceof Matrix otherMatrix){
            double[][] result = Arrays.copyOf(values,values.length);
            if (this.values[0].length!=otherMatrix.values[0].length && this.values.length!=otherMatrix.values.length){
                System.out.printf("Incorrect operation %s + %s&n", this,other);
            }
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    result[i][j] = result[i][j] + otherMatrix.values[i][j];
                }
            }
            return new Matrix(result);
        }

        return super.add(other);
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        String delimiter = "";
        for (int i = 0; i < values.length; i++) {
            if (i == 0) {
                out.append("{");
            } else {
                out.append("}, ");
            }

            for (int j = 0; j < values[i].length; j++) {

                if (j == 0) {
                    delimiter = "";
                    out.append("{").append(delimiter).append(values[i][j]);
                } else {
                    out.append(delimiter).append(values[i][j]);
                }
                delimiter = ",";
            }
        }
        out.append("}}");
        return out.toString();
    }
}
