package by.it.konon.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Var var = new Scalar(3.1415);
        System.out.println(var);


        Scalar scalar = (Scalar) var;
        Var var1 = new Scalar(scalar);
        System.out.println(var1);

        Var var2 = new Scalar("3.1415");
        System.out.println(var2);

        double [] array = {1.0, 2.0, 4.0};
        Var var4 = new Vector(array);
        System.out.println(var4);

        Var var5 = new Vector(array);
        System.out.println(var5);


    }
}
