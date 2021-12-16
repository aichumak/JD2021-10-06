package by.it.kanaplianik.jd02_04;

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

    public double getValue() {
        return doubleValue;
    }

    @Override
    public String toString() {
        return doubleValue.toString();
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar otherScalar) {
            double result = this.getValue() + otherScalar.getValue();

            Scalar resultScalar = new Scalar(result);

            return resultScalar;
        }

        if (other instanceof Vector otherVector) {
            return otherVector.add(this);
        }

        return null;
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar otherScalar) {
            double result = this.getValue() - otherScalar.getValue();

            Scalar resultScalar = new Scalar(result);

            return resultScalar;
        }
        return null;
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar otherScalar) {
            double result = this.getValue() * otherScalar.getValue();

            Scalar resultScalar = new Scalar(result);

            return resultScalar;
        }
        return null;
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar otherScalar) {
            double result = this.getValue() / otherScalar.getValue();
            if (otherScalar.getValue() != 0) {
                Scalar resultScalar = new Scalar(result);
                return resultScalar;
            }
                else {
                return null;
            }
        }

        return null;
    }
}
