package by.it.brutski.jd01_08;

public class Runner {
    private static void print(Var var) {
        if (var != null) {
            System.out.println(var);
        }
    }

    public static void main(String[] args) {
        Var s = new Scalar(3.0);

        print(s.add(s));
        print(s.sub(s));
        print(s.mul(s));
        print(s.div(s));
    }

}
