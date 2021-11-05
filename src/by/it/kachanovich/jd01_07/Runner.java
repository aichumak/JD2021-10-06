package by.it.kachanovich.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Var var = new Scalar(123.456);
        Scalar otherScalar=(Scalar) var;
        Var var1 = new Scalar(otherScalar);
        System.out.println(var1);
        Var var2 = new Scalar("456.789");
        Var[] arrayVar1 = new Vector[5];
    }
}
