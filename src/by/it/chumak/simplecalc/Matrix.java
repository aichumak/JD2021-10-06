package by.it.chumak.simplecalc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Matrix extends Var {

    private final double[][] values;

    public Matrix() {
        this.values = new double[0][0];
    }

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
