package by.it.chumak.calc.model;

public class Scalar extends Var {

    private final double value;

    public Scalar(double value) {
        this.value = value;
    }

    public Scalar() {
        this.value = 0;
    }

    public Scalar(Scalar otherScalar) {
        this.value = otherScalar.value;
    }

    public Scalar(String strScalar) {
        this.value = Double.parseDouble(strScalar);
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
