package by.it.brutski.jd01_07;

public class Runner {
    public static void main(String[] args) {

        Var var = new Scalar(15.15);
        System.out.println(var);

        Var var2 = new Scalar((Scalar) var);
        System.out.println(var2);

        Var var3 = new Scalar("51.51");
        System.out.println(var3);

        double[] array = {15, 56, -9, 7, 0.36};
        Var var4 = new Vector(array);
        System.out.println(var4);
    }

}
