package by.it.ithoitan.jd01_07;

import java.util.Arrays;

public class Vector extends Var {
    private final double[] values;

    public Vector(double[] values) {
        this.values = Arrays.copyOf(values, values.length);
    }

    public Vector(Vector otherVector) {
        values = otherVector.values;
    }

    public Vector(String stringValues) {
        String s = stringValues.replaceAll("[\\p{Punct}]+", " ");
        String trim = s.trim();
        String[] stringArr = trim.split(" ");
        double[] numStringArr = new double[stringArr.length];
        for (int i = 0; i < stringArr.length; i++) {
            numStringArr[i] = Double.parseDouble(stringArr[i]);
        }
        values=numStringArr;




    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append("{");
        String delimiter = "";
        for (double value : values) {
            out.append(delimiter).append(value);
            delimiter = ", ";
        }
        out.append("}");

        return out.toString();
    }
}
