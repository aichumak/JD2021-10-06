package by.it.ithoitan.jd01_07;

import java.util.Arrays;


class Matrix extends Var {
    private final double[][] values;

    public Matrix(double[][] values) {
        this.values = Arrays.copyOf(values, values.length);
    }

    public Matrix(Matrix otherMatrix) {
        values=otherMatrix.values;
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
