package by.it.serkutsyev.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Var var = new Scalar(3.1415);
        Var varScalar = new Scalar((Scalar) var);
        Var stringScalar = new Scalar("3.1415");
        System.out.println(var);
        System.out.println(varScalar);
        System.out.println(stringScalar);
        double[] arrayVector = {1, 2, 4};
        Var vector1 = new Vector(arrayVector);
        System.out.println(vector1);
        Var vector2 = new Vector((Vector) vector1);
        System.out.println(vector2);
        Var vector3 = new Vector("{1.0, 2.0, 4.0}");
        System.out.println(vector3);
        double[][] arrayMatrix = {{1, 2}, {3, 4}};
        Var matrix1 = new Matrix(arrayMatrix);
        System.out.println(matrix1);
        Var matrix2 = new Matrix((Matrix) matrix1);
        System.out.println(matrix2);
        Var matrix3 = new Matrix("{ { 1.0, 2.0 }, { 3.0, 4.0 } }");
    }
}
