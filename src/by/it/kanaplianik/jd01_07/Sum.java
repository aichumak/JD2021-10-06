package by.it.kanaplianik.jd01_07;

public class Sum {
    public Sum (int a, int b) {
        result = a + b;
    }
     private int result;

    public int getResult () {
        return result;
    }

    public Sum (int a, int b, int c) {
        result = a + b + c;
    }

    public Sum (int[] arr) {
        int summ = 0;
        for (int i = 0; i < arr.length; i++) {
            summ = summ + arr[i];
        }
        result = summ;
    }
    public void print () {
        System.out.println(result);
    }

    public Sum (Sum a, Sum b) {
        result = a.getResult()+b.getResult();
    }

    @Override
    public String toString() {
        return Integer.toString(result);
    }
}
