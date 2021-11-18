package by.it._classwork_.calc;

import java.util.Arrays;

class Vector extends Var {

    private final double[] values;

    public double[] getValues() {
        return Arrays.copyOf(values, values.length);
    }

    public Vector(double[] values) {
        this.values = Arrays.copyOf(values, values.length);
    }

    public Vector(String string) {
        String[] parts = string
                .replace("{", "")
                .replace("}", "")
                .split(",");
        values = new double[parts.length];
        for (int i = 0; i < values.length; i++) {
            values[i] = Double.parseDouble(parts[i]);
        }
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar otherScalar) {
            double[] result = Arrays.copyOf(values, values.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] + otherScalar.getValue();
            }
            return new Vector(result);
        }
        if (other instanceof Vector otherVector) {
            double[] result = Arrays.copyOf(values, values.length);
            if (values.length != otherVector.values.length) {
                throw new CalcException("Incorrect operation %s / %s%n", this, other);
            }
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] + otherVector.values[i];
            }
            return new Vector(result);
        }
        return super.add(other);
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
