package by.it.ithoitan.calc.model;

import by.it.ithoitan.calc.ecxeption.CalcException;

public  class Scalar extends Var {
    private final double value;

    public Scalar(double value) {
        this.value = value;
    }

    public Scalar(Scalar otherScalar) {
        value=otherScalar.value;
    }

    public Scalar(String stringValue) {
        value=Double.parseDouble(stringValue);
    }

    public double getValue() {
        return value;
    }


    @Override
    public Var add(Var other) throws CalcException {
        if(other instanceof Scalar otherScalar){
            double result = this.value + otherScalar.value;
            return new Scalar(result);
        }
        return other.add(this);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if(other instanceof Scalar otherScalar){
            double result = (this.value - otherScalar.value);
            return new Scalar(result);
        }
        return other.sub(this).mul(new Scalar(-1));
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if(other instanceof Scalar otherScalar){
            double result = this.value * otherScalar.value;
            return new Scalar(result);
        }
        return other.mul(this);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if(other instanceof Scalar otherScalar){
            if (otherScalar.value == 0){
                System.out.printf("Division by zero %s / %s&n", this,other);
            }
            double result = this.value / otherScalar.value;
            return new Scalar(result);
        }
        return super.div(other);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
