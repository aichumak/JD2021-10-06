package by.it.chumak.jd01_08;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Vector extends Var {

    private final double[] values;

    public Vector(double[] array) {
        this.values = Arrays.copyOf(array, array.length);
    }

    public Vector(Vector otherVector) {
        this.values = otherVector.values;
    }

    public Vector(String strVector) {
        StringBuilder inText = new StringBuilder(strVector);
        Pattern pattern = Pattern.compile("[^,{}]+");
        Matcher matcher = pattern.matcher(inText);
        double[] arrayDouble = new double[0];

        while (matcher.find()) {
            arrayDouble = Arrays.copyOf(arrayDouble, arrayDouble.length + 1);
            arrayDouble[arrayDouble.length - 1] = Double.parseDouble(matcher.group());
        }
        this.values = arrayDouble;
    }

    public double[] getValues() {
        return Arrays.copyOf(values, values.length);
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar otherScalar) {
            double[] result = Arrays.copyOf(this.values, this.values.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] + otherScalar.getValue();
            }
            return new Vector(result);
        }
        if (other instanceof Vector otherVector) {
            double[] result = Arrays.copyOf(this.values, this.values.length);
            //TODO Throws exception Incorrect operation
            if (result.length != otherVector.values.length) {
                System.out.printf("Incorrect operation %s + %s", this, otherVector);
            }
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] + otherVector.values[i];
            }
            return new Vector(result);
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar otherScalar) {
            double[] result = Arrays.copyOf(this.values, this.values.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] - otherScalar.getValue();
            }
            return new Vector(result);
        }
        if (other instanceof Vector otherVector) {
            double[] result = Arrays.copyOf(this.values, this.values.length);
            //TODO Throws exception Incorrect operation
            if (result.length != otherVector.values.length) {
                System.out.printf("Incorrect operation %s + %s", this, otherVector);
            }
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] - otherVector.values[i];
            }
            return new Vector(result);
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar otherScalar) {
            double[] result = Arrays.copyOf(this.values, this.values.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] * otherScalar.getValue();
            }
            return new Vector(result);
        }
        if (other instanceof Vector otherVector) {
            double[] result = new double[1];
            //TODO Throws exception Incorrect operation
            if (this.values.length != otherVector.values.length) {
                System.out.printf("Incorrect operation %s - %s", this, otherVector);
            }
            for (int i = 0; i < this.values.length; i++) {
                result[0] = result[0] + (this.values[i] * otherVector.values[i]);
            }
            return new Vector(result);
        }
        return super.sub(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar otherScalar) {
            double[] result = Arrays.copyOf(this.values, this.values.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] / otherScalar.getValue();
            }
            return new Vector(result);
        }
        return super.div(other);
    }

    @Override
    public String toString() {
        StringBuilder outString = new StringBuilder();
        if (this.values.length > 1) {
            String delimiter = "";
            outString.append("{");
            for (double value : values) {
                outString.append(delimiter).append(value);
                delimiter = ", ";
            }
            outString.append("}");
        } else {
            return Double.toString(this.values[0]);
        }

        return outString.toString();
    }
}
