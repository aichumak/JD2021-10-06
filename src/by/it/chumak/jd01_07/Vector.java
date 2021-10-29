package by.it.chumak.jd01_07;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Vector extends Var {

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

    @Override
    public String toString() {
        StringBuilder outString = new StringBuilder();
        String delimiter = "";
        outString.append("{");
        for (double value : values) {
            outString.append(delimiter).append(value);
            delimiter = ", ";
        }
        outString.append("}");

        return outString.toString();
    }
}
