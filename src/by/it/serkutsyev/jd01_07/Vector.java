package by.it.serkutsyev.jd01_07;

import java.util.Arrays;

public class Vector extends Var {

    public double[] value;

    public Vector(double[] value) {
this.value=Arrays.copyOf(value,value.length);
        }

    public Vector(Vector vector) {
        this.value=vector.value;
    }

    public Vector(String strVector) {
        strVector = strVector.replace("{","");
        strVector = strVector.replace("}","");
        strVector = strVector.replace(".0","");
        strVector = strVector.trim();
        String[] elementString = strVector.split(",");
        double[] arrayFromString = new double[elementString.length];
        for (int i = 0; i < elementString.length; i++) {
            arrayFromString[i] = Double.parseDouble(elementString[i]);
        }
        this.value=Arrays.copyOf(arrayFromString,arrayFromString.length);
    }


    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append("{");
        String delimeter = "";
        for (double i: value) {
            out.append(delimeter).append(i);
            delimeter = ", ";

        }
        out.append("}");
        return out.toString();

    }
}

