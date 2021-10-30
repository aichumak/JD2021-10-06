package by.it.chumak.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Var a1 = new Scalar(3.1415);
        Var a2 = new Scalar("3.1415");
        Var a3 = (Scalar) a2;
        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);

        double[] array1 = {1.0, 2.0, 4.0};

        Var b1 = new Vector(array1);
        Var b2 = (Vector) b1;
        Var b3 = new Vector("1.0,2.0,4.0");
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);

        double array2[][] = {{1.0, 2.0}, {3.0, 4.0}};
        Var c1 = new Matrix(array2);
        Var c2 = (Matrix) c1;
        Var c3 = new Matrix("{{1.0,2.0}, {3.0,4.0}}");
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);

    }
}
