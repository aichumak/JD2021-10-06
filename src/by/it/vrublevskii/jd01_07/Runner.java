package by.it.vrublevskii.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Var var = new Scalar(156.254);
        Var var2 = new Scalar((Scalar) var);
        Var var3 = new Scalar("23.365");
        System.out.println(var);
        System.out.println(var2);
        System.out.println(var3);
        double[] array = {12.52, 65.45, 87.12, 32.32};
        Var var4 = new Vector(array);
        Var var5 = new Vector((Vector) var4);
        Var var6 = new Vector("{1, 2, 4}");
        System.out.println(var4);
        System.out.println(var5);
        System.out.println(var6);
        double[][] matrix = {{2d, 3d}, {3d, 4d}};
        Var var7 = new Matrix(matrix);
        Var var8 = new Matrix((Matrix)var7);
        Var var9 = new Matrix("{{1,2},{2,3}}");
        System.out.println(var7);
        System.out.println(var8);
        System.out.println(var9);
    }
}
