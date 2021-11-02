package by.it.vrublevskii.jd01_08;

import java.util.Arrays;
import java.util.StringJoiner;

class Vector extends Var {
    private final double[] vector;

    public double[] getVector() {
        return Arrays.copyOf(vector, vector.length);
    }

    Vector(double[] vector) {
        this.vector = Arrays.copyOf(vector, vector.length);
    }

    Vector(Vector otherVector) {
        this.vector = otherVector.vector;
    }

    Vector(String stringVector) {
        stringVector = stringVector.replaceAll("[{|}]", " ");
        String[] stringArray = stringVector.split(",");
        double[] vectorBuffer = new double[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            vectorBuffer[i] = Double.parseDouble(stringArray[i]);
        }
        this.vector = Arrays.copyOf(vectorBuffer, vectorBuffer.length);
    }




    @Override
    public Var add(Var other) {
        if (other instanceof Scalar otherScalar){
            double[] result = Arrays.copyOf(vector, vector.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] + otherScalar.getValue();
            }
            return new Vector(result);
        }
        if (other instanceof Vector otherVector){
            double[] result = Arrays.copyOf(vector, vector.length);
            // TODO throws exception
            if (this.vector.length != otherVector.vector.length) {
                System.out.printf("Incorrect operation %s + %s\n", this, other);
            }
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] + otherVector.vector[i];
            }
            return new Vector(result);
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar otherScalar){
            double[] result = Arrays.copyOf(vector, vector.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] - otherScalar.getValue();
            }
            return new Vector(result);
        }
        if (other instanceof Vector otherVector){
            double[] result = Arrays.copyOf(vector, vector.length);
            // TODO throws exception
            if (this.vector.length != otherVector.vector.length) {
                System.out.printf("Incorrect operation %s - %s\n", this, other);
            }
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] - otherVector.vector[i];
            }
            return new Vector(result);
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar otherScalar){
            double[] result = Arrays.copyOf(this.vector, this.vector.length);
            for (int i = 0; i < result.length; i++) {
                result[i] *= otherScalar.getValue();
            }
            return new Vector(result);
        }
        if (other instanceof Vector otherVector){
            double[] result = Arrays.copyOf(this.vector, this.vector.length);
            double finalResult = 0;
            for (int i = 0; i < this.vector.length; i++) {
                finalResult += result[i] * otherVector.vector[i];
            }
            return new Scalar(finalResult);
        }

        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar otherScalar){
            if (otherScalar.getValue() == 0) {
                System.out.printf("Division by zero %s / %s\n", this, other);
            }
            double[] result = Arrays.copyOf(this.vector, this.vector.length);
            for (int i = 0; i < result.length; i++) {
                result[i] /= otherScalar.getValue();
            }
            return new Vector(result);
        }
        return super.div(other);
    }





    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "{", "}");
        for (double vectorElement : vector) {
            joiner.add(Double.toString(vectorElement));
        }
        return joiner.toString();
    }
}
