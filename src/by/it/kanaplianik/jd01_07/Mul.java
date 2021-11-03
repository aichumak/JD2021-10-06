package by.it.kanaplianik.jd01_07;

public class Mul {
    private int intResult;

    public Mul (Sum a, Sum b) {
        intResult = a.getResult() * b.getResult();
    }

    public Mul (Sum u, int x) {
        intResult = u.getResult() * x;
    }
}
