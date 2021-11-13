package by.it.serkutsyev.jd01_09;

public class Scalar extends Var {

    private double value;



    public Scalar(double value) {
        this.value = value;
    }

    public Scalar(Scalar scalar) {
        this.value = scalar.value;
    }

    public Scalar(String strScalar) {
        this.value = Double.parseDouble(strScalar);
    }

    public double getValue() {
        return value;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar otherScalar)
        {
            return new Scalar(this.value+otherScalar.value);
        }
        return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar otherScalar)
        {
            return new Scalar(this.value-otherScalar.value);
        }
        return (other.sub(this)).mul(new Scalar(-1));
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar otherScalar)
        {
            return new Scalar(this.value*otherScalar.value);
        }
        return other.mul(this);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar otherScalar)
        {
            if (otherScalar.value==0){
                System.out.printf("Division by zero %s / %s\n",this,other);}
            else {
                return new Scalar(this.value/otherScalar.value);            }

        }
        return super.div(other);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }


}
