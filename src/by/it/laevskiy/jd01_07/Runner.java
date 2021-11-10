package by.it.laevskiy.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Scalar scalar = new Scalar(3.1415);
        Var scalar1 = new Scalar(3.1415);
        Var scalar2 = new Scalar(scalar);
        Var scalar3 = new Scalar("3.1415");
        Var v2 = new Vector("{7.0, 29.0, 12.0}");
        System.out.println(scalar1 + " " + scalar2 + " " + scalar3);
        System.out.println(v2);
    }
}
//    Var v1 = new Scalar(3.1415);
//Var v2 = new Vector(new double[]{1.0, 2.0, 4.0});