package by.it.kanaplianik.jd01_07;

public class Scalar extends Var {
    public Scalar(double value){
        stringValue = Double.toString(value);
    }

    public Scalar(Scalar scalar) {
        stringValue = scalar.toString();
    }

    public Scalar (String strScalar) {
        stringValue = strScalar;
    }

    private String stringValue;

    @Override
    public String toString() {
        return stringValue;
    }

// -




}
