package by.it.kanaplianik.jd01_07;

public class Scalar extends Var {
    private final Double doubleValue;

    public Scalar(double value) {
        doubleValue = value;
    }

    public Scalar(Scalar scalar) {
        doubleValue = scalar.doubleValue;
    }

    public Scalar(String strScalar) {
        doubleValue = Double.parseDouble(strScalar);
    }

    @Override
    public String toString() {
        return doubleValue.toString();
    }
}
