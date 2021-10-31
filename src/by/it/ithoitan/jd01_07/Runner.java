package by.it.ithoitan.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Var var = new Scalar(123);
        Scalar otherScalar = (Scalar) var;
        Var var2 = new Scalar(otherScalar);
        Var var3 = new Scalar("456.256");
        double[] array = {1,2,3,4,5};
        Var var5 = new Vector(array);
        Var var6 = new Vector("{1,2,3,4}");
        System.out.println(var6);
    }
}
