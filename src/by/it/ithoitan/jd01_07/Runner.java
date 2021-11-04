package by.it.ithoitan.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Var var = new Scalar(123);
        Scalar otherScalar = (Scalar) var;
        Var var2 = new Scalar(otherScalar);
        Var var3 = new Scalar("456.256");
        double[] array = {1,2,3,4,5};
        double[][] mas = {{1,2,4,6},{3,4,7,8}};
        Var var7 = new Matrix(mas);
        Var var5 = new Vector(array);
        Var var6 = new Vector("{1,2,3,4}");
        Var var8 = new Matrix("{{1,2,3},{3,4,7}}");
        System.out.println(var8);
    }
}
