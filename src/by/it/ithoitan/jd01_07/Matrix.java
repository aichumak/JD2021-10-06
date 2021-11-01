package by.it.ithoitan.jd01_07;

import java.util.Arrays;

public class Matrix extends Var {
    private final double[][] values;

    public Matrix(double[][] values) {
        this.values = Arrays.copyOf(values, values.length);
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append("{");
        String delimiter = "";
        for (double[] value : values) {
            out.append(delimiter).append(Arrays.toString(values));
            delimiter = ", ";
        }

        out.append("}");


        return out.toString();
    }
}
