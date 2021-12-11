package by.it.brutski.jd01_07;

import java.util.Arrays;

public class Vector extends Var {
    private final double[] value;

    public Vector(double[] values) {
        this.value = Arrays.copyOf(values, values.length);
    }

    public Vector(Vector otherVector) {
        value = otherVector.value;
    }

    public Vector(String strValues) {
        String[] str = strValues.replaceAll("[\\p{Punct}]+", " ").trim().split(" ");
        double[] num_str = new double[str.length];
        for (int i = 0; i < str.length; i++) {
            num_str[i] = Double.parseDouble(str[i]);
        }
        value = num_str;


    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("{");
        for (int i = 0; i < value.length; i++) {
            if (i < value.length - 1)
                result.append(value[i]).append(", ");
            else
                result.append(value[i]).append("}");
        }
        return result.toString();
    }
}
