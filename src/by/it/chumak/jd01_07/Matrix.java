package by.it.chumak.jd01_07;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Matrix extends Var {

    private final double[][] values;

    public Matrix(double[][] value) {
        this.values = Arrays.copyOf(value, value.length);
    }

    public Matrix(Matrix matrix) {
        this.values = matrix.values;
    }

    public Matrix(String strMatrix) {
        StringBuilder str = new StringBuilder(strMatrix);
        Pattern pattern = Pattern.compile("[\\d.]+");
        Matcher matcher = pattern.matcher(str);
        double[][] bufferArray;
        int firstIndex = 0;
        int secondIndex = 0;
        int countIndex = 0;

        while (matcher.find()) {
            countIndex++;
        }

        countIndex = countIndex / 2;
        bufferArray = new double[countIndex][countIndex];
        matcher.reset();

        while (matcher.find()) {
            bufferArray[firstIndex][secondIndex] = Double.parseDouble(matcher.group());
            secondIndex++;
            matcher.find();
            bufferArray[firstIndex][secondIndex] = Double.parseDouble(matcher.group());
            firstIndex++;
            secondIndex = 0;
        }
        this.values = bufferArray;
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
