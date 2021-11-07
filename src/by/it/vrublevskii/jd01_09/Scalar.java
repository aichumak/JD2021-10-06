package by.it.vrublevskii.jd01_09;

class Scalar extends Var {
    private final double value;

    public double getValue() {
        return value;
    }

    Scalar(double value) {
        this.value = value;
    }

    Scalar(Scalar otherScalar) {
        this.value = otherScalar.value;
    }

    Scalar(String stringValue) {
        this.value = Double.parseDouble(stringValue);
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
            // TODO throws exception div/0
            if (otherScalar.value == 0) {
                System.out.printf("Division by zero %s / %s\n", this, other);
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
