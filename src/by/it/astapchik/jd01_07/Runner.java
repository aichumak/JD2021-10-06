package by.it.astapchik.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Var var = new Scalar(3.1415);
        Var var2 = new Scalar((Scalar) var);
        Var var3 = new Scalar("223.34324");


        double[ ] vector = { 1.0, 2.0, 4.0 };
        Var var4 = new Vector(vector);
        Var var5 = new Vector(vector);
        Var var6 = new Vector("{1.0, 2.0, 4.0}");


        double[ ][ ] matrix = { { 1.0, 2.0 }, { 3.0, 4.0 } };
        Var var7 = new Matrix(matrix);
        Var var8 = new Matrix("{{1.0, 2.0}, {3.0, 4.0}}");
        System.out.println("Result: " + var8);

    }
}
