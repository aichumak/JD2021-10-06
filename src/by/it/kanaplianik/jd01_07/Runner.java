package by.it.kanaplianik.jd01_07;

public class Runner {
    public static void main(String[] args) {

        Sum v = new Sum(3,4);
        v.print();
        Sum another = new Sum(v.getResult(), 7, 8);
        another.print();
        Sum sumSum = new Sum(v, another);
    }
}
