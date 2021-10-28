package by.it._classwork_.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Var var1=new Scalar(123.456);
        System.out.println(var1);

        Scalar otherScalar = (Scalar) var1;
        Var var2=new Scalar(otherScalar);
        System.out.println(var2);

        Var var3 = new Scalar("456.789");
        System.out.println(var3);

        double[] array={1,2,3,4,6,8,0};
        Var var4 = new Vector(array);
        array[1]=11111;
        System.out.println(var4);
    }
}
