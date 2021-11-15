package by.it._classwork_.calc;

class Scalar extends Var {

    private final double value;

    public Scalar(double value) {
        this.value = value;
    }

    public Scalar(Scalar otherScalar) {
        this.value = otherScalar.value;
    }

    public Scalar(String stringValue) {
        value = Double.parseDouble(stringValue);
    }

    public double getValue() {
        return value;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar otherScalar) {
            return new Scalar(this.value + otherScalar.value);
        }
        return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar otherScalar) {
            return new Scalar(this.value - otherScalar.value);
        }
        return other.sub(this).mul(new Scalar(-1));
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar otherScalar) {
            return new Scalar(this.value * otherScalar.value);
        }
        return other.mul(this);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar otherScalar) {
            //TODO throw Exception div by zero
            if (otherScalar.value == 0) {
                System.out.printf("Division by zero %s / %s%n", this, other);
            }
            return new Scalar(this.value / otherScalar.value);
        }
        return super.div(other);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
