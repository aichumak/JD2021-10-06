package by.it.brutski.jd01_07;

public class Scalar extends Var{
    private final double value;

    public Scalar(double value){
        this.value = value;
    }

    public Scalar(Scalar otherScalar){
        this.value = otherScalar.value;
    }

    public Scalar(String stingValue){
        this.value = Double.parseDouble(stingValue);
    }

    public String toString(){
        return Double.toString(value);
    }

}
