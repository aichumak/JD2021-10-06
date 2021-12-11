package by.it.astapchik.calculator;

class Scalar extends Var {

    private final double value;

    public Scalar(double value){
        this.value = value;
    }

    public Scalar(Scalar scalar){
        this.value = scalar.value;
    }

    public Scalar(String strScalar){
        this.value = Double.parseDouble(strScalar);
    }


    public double getValue(){
        return value;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar otherValue){
            double result = this.value + otherValue.value;
            return new Scalar(result);
        }
        return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar otherValue){
            double result = this.value - otherValue.value;
            return new Scalar(result);
        }
        return other.sub(this).mul(new Scalar(-1));
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar otherValue){
            return new Scalar(this.value * otherValue.value);
        }
        return other.mul(this);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar otherValue){
            if (otherValue.value == 0){
                System.out.printf("%s / %s ---> Division by zero is impossible.", this, other);
            }
            double result = this.value / otherValue.value;
            return new Scalar(result);
        }
        return other.div(this);
    }



    @Override
    public String toString() {
        return Double.toString(value);
    }


}
