package by.it.drankevich.jd01_07;

public class Runner {
    public static void main(String[] args) {

        Var v1 = new Scalar(3.1415);
        System.out.println(v1);


        Var v2 = new Scalar("3.1415");
        System.out.println(v2);

        Scalar otherscalar = (Scalar) v1;
        Var v3 = new Scalar(otherscalar);
        System.out.println(v3);


        Var v4 = new Vector("{1.0, 2.0, 4.0}");
        System.out.println(v4);

        double[] array = {1.0, 2.0, 4.0};
        Var v5 = new Vector(array);
        System.out.println(v5);


        Vector othervector = (Vector) v4;
        Var v6 = new Vector(othervector);
        System.out.println(v6);


        double[][] arraym = {{1.0, 2.0}, {3.0, 4.0}};
        Var vm = new Matrix(arraym);
        System.out.println(vm);


        Matrix othermatrix=(Matrix) vm;
        Var vm1=new Matrix(othermatrix);
        System.out.println(vm1);


        Var vm2=new Matrix("{{1.0, 2.0},{3.0, 4.0}}");
         System.out.println(vm2);




        }
    }

