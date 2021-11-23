package by.it.chumak.calc_kotlin;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Vector extends Var {

    private final double[] values;

    public Vector() {
        this.values = new double[0];
    }

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
