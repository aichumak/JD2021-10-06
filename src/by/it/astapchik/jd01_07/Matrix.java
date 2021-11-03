package by.it.astapchik.jd01_07;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Matrix extends Var{

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
        String[] arrayOfNumbers = modifiedString.split(",");

        double[][] newArray = new double[2][2];
        int counter = 0;
        for (int i = 0; i < newArray.length; i++) {
            for (int i1 = 0; i1 < newArray[0].length; i1++) {
                newArray[i][i1] = Double.parseDouble(arrayOfNumbers[counter]);
                counter ++;
            }
        }
        this.value = newArray;
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
