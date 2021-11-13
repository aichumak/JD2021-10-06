package by.it.astapchik.jd01_08;


import by.it.astapchik.jd01_08.Var;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Vector extends Var {

    private final double[] value;

    public Vector(double[] value){
        this.value = Arrays.copyOf(value, value.length);
    }

    public Vector(Vector vector){
        this.value = Arrays.copyOf(vector.value, vector.value.length);
    }

    public Vector(String strVector){
        StringBuilder string = new StringBuilder(strVector);
        Pattern pattern = Pattern.compile("[^,{}]+");
        Matcher matcher = pattern.matcher(string);

        double[] newArray = new double[0];

        while (matcher.find()){
            newArray = Arrays.copyOf(newArray, newArray.length+1);
            newArray[newArray.length-1] = Double.parseDouble(matcher.group());
        }

        this.value = newArray;
    }

    public double[] getValue() { return Arrays.copyOf(value, value.length); }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar otherScalar){
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] + otherScalar.getValue();
            }
            return new Vector(result);
        }
        if (other instanceof Vector otherVector){
            if (value.length != otherVector.value.length){
                System.out.printf("%s / %s ---> Something is wrong.", this, other);
            }

            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] + otherVector.value[i];
            }
            return new Vector(result);
        }
        return super.add(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar otherScalar){
            double[ ] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] * otherScalar.getValue();
            }
            return new Vector(result);
        }
        if (other instanceof Vector otherVector){
            double temp = 0;
            if (value.length != otherVector.value.length){
                System.out.printf("%s / %s ---> Something is wrong.", this, other);
            }

            double[] result = Arrays.copyOf(value, value.length);

            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] * otherVector.value[i];
                temp += result[i];
            }
            return new Scalar(temp);
        }
        return super.mul(other);
    }

    @Override
    public Var sub(Var other) {

        if (other instanceof Scalar otherScalar){
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] - otherScalar.getValue();
            }
            return new Vector(result);
        }

        if (other instanceof Vector otherVector){
            if (value.length != otherVector.value.length){
                System.out.printf("%s / %s ---> Something is wrong.", this, other);
            }

            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] - otherVector.value[i];
            }
            return new Vector(result);
        }
        return super.sub(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar otherScalar){
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] / otherScalar.getValue();
            }
            return new Vector(result);
        }

        return super.div(other);
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("{");
        String comma = "";
        for (double v : value) {
            string.append(comma).append(v);
            comma = ", ";
        }
        string.append("}");

        return string.toString();
    }
}
