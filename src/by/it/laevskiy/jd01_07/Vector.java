package by.it.laevskiy.jd01_07;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Vector extends Var {
    private final double[] values;

    Vector(double[] values) {
        this.values = Arrays.copyOf(values, values.length);
    }

    Vector(Vector vector) {
        this.values = vector.values;
    }

    Vector(String strVector) {
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";
        for (double element : values) {
            sb.append(delimiter).append(element);
            delimiter = ", ";
        }
        sb.append("}");
        return sb.toString();
    }
}