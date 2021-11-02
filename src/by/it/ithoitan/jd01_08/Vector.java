package by.it.ithoitan.jd01_08;

import java.util.Arrays;

class Vector extends Var {
    private final double[] values;

    public double[] getValues() {
        return Arrays.copyOf(values, values.length);
    }

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
        values = numStringArr;


    }

    @Override
    public Var add(Var other) {
        if(other instanceof Scalar oterScalar){
           double[] result = Arrays.copyOf(values,values.length);
            for (int i = 0; i < result.length; i++) {
                result[i]=result[i]+oterScalar.getValue();
            }
            return new Vector(result);
        }
        if(other instanceof Vector oterVector){
            double[] result = Arrays.copyOf(values,values.length);
            if (this.values.length!=oterVector.values.length){
                System.out.printf("Incorrect operation %s + %s&n", this,other);
            }
            for (int i = 0; i < result.length; i++) {
                result[i]=result[i]+oterVector.values[i];
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
