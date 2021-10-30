package by.it._classwork_.jd01_07;

import java.util.Arrays;

class Vector extends Var{

    private final double[] values;

    public Vector(double[] values) {
        this.values = Arrays.copyOf(values,values.length);
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append("{");
        String delimiter="";
        for (double value : values) {
            out.append(delimiter).append(value);
            delimiter=", ";
        }
        out.append("}");
        return out.toString();
    }
}
