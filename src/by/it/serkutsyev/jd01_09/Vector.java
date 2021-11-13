package by.it.serkutsyev.jd01_09;

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

    public double[] getValue() {
        return Arrays.copyOf(value,value.length);
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar otherScalar)
        {
            double [] arrayCopy = Arrays.copyOf(this.value,value.length);
            for (int i = 0; i < arrayCopy.length; i++) {
                arrayCopy[i]=arrayCopy[i]+otherScalar.getValue();
            }
            return new Vector(arrayCopy);
        }
        if (other instanceof Vector otherVector)
        {
            double [] arrayCopy = Arrays.copyOf(this.value,value.length);
            if (arrayCopy.length!=otherVector.value.length)
            {
                System.out.printf("Vectors of different size %s and %s", this, otherVector);
            }
           // double [] copyOfVector = Arrays.copyOf(otherVector.value,otherVector.value.length);
            for (int i = 0; i < arrayCopy.length; i++) {
                arrayCopy[i]=arrayCopy[i]+otherVector.value[i];
            }
            return new Vector(arrayCopy);
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar otherScalar)
        {
            double [] arrayCopy = Arrays.copyOf(this.value,value.length);
            for (int i = 0; i < arrayCopy.length; i++) {
                arrayCopy[i]=arrayCopy[i]-otherScalar.getValue();
            }
            return new Vector(arrayCopy);
        }
        if (other instanceof Vector otherVector)
        {
            double [] arrayCopy = Arrays.copyOf(this.value,value.length);
            if (arrayCopy.length!=otherVector.value.length)
            {
                System.out.printf("Vectors of different size %s and %s", this, otherVector);
            }
            // double [] copyOfVector = Arrays.copyOf(otherVector.value,otherVector.value.length);
            for (int i = 0; i < arrayCopy.length; i++) {
                arrayCopy[i]=arrayCopy[i]-otherVector.value[i];
            }
            return new Vector(arrayCopy);
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar otherScalar)
        {
            double [] arrayCopy = Arrays.copyOf(this.value,value.length);
            for (int i = 0; i < arrayCopy.length; i++) {
                arrayCopy[i]=arrayCopy[i]*otherScalar.getValue();
            }
            return new Vector(arrayCopy);
        }
        if (other instanceof Vector otherVector)
        {
            double [] arrayCopy = Arrays.copyOf(this.value,value.length);
            if (arrayCopy.length!=otherVector.value.length)
            {
                System.out.printf("Vectors of different size %s and %s", this, otherVector);
            }
            // double [] copyOfVector = Arrays.copyOf(otherVector.value,otherVector.value.length);
            for (int i = 0; i < arrayCopy.length; i++) {
                arrayCopy[i]=arrayCopy[i]*otherVector.value[i];
            }
            double total = 0;
            for (int i = 0; i < arrayCopy.length; i++) {
                total=total+arrayCopy[i];
            }
            return new Scalar(total);
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar otherScalar)
        {
            if (otherScalar.getValue()==0){
                System.out.printf("Division by zero %s and %s\n", this, otherScalar);
            }
            double [] arrayCopy = Arrays.copyOf(this.value,value.length);
            for (int i = 0; i < arrayCopy.length; i++) {
                arrayCopy[i]=arrayCopy[i]/otherScalar.getValue();
            }
            return new Vector(arrayCopy);
        }
        return super.div(other);
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

