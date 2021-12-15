package by.it.drankevich.calc.model;

import by.it.drankevich.calc.ResourceManager;
import by.it.drankevich.calc.exeption.CalcExeption;

public class Scalar extends Var {
    private final double value;

    public Scalar(double value) {
        this.value = value;
    }

    public Scalar(Scalar  scalar) {
        this.value = scalar.value;
    }

    public Scalar(String strScalar) {
        this.value = Double.parseDouble(strScalar);
    }

    public double getValue() {
        return value;
    }

    @Override
    public Var add(Var other) throws CalcExeption {
        if (other instanceof Scalar ) {
            double sum = this.value + ((Scalar) other).value;
            return new Scalar(sum);
        } else
            return other.add(this);
    }

    @Override
    public Var sub(Var other) throws CalcExeption {
        if (other instanceof Scalar) {
            double sub = this.value - ((Scalar) other).value;
            return new Scalar(sub);
        } else
            return new Scalar(-1).mul(other).add(this);
    }


    @Override
    public Var mul(Var other) throws CalcExeption {
        if (other instanceof Scalar) {
            double mul = this.value * ((Scalar) other).value;
            return new Scalar(mul);
        } else
            return other.mul(this);
    }


    @Override
    public Var div(Var other) throws CalcExeption {

        if (other instanceof Scalar) {

            if (((Scalar) other).value == 0) {
                throw new CalcExeption(ResourceManager.get("massage.ErrorDivZero"), this, other);
            }
            double div = this.value / ((Scalar) other).value;
            return new Scalar(div);
        } else
            return super.div(other);
    }



    @Override
    public String toString() {
        return Double.toString(value);
    }
}
