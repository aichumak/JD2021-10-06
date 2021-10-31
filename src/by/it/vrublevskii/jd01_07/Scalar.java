package by.it.vrublevskii.jd01_07;

class Scalar extends Var {
    private final double value;

    Scalar(double value) {
        this.value = value;
    }

    Scalar(Scalar otherScalar) {
        this.value = otherScalar.value;
    }

    Scalar(String stringValue) {
        this.value=Double.parseDouble(stringValue);
    }

    @Override
    public String toString() {
        return Double.toString(value);

    }
}
