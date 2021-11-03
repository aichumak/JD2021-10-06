package by.it.astapchik.jd01_05;
import static java.lang.Math.*;

public class TaskC {

    public static void main(String[] args) {
        task1();
    }

    private static void task1() {
        double[ ] arrayA = new double[40];
        String a = "А";
        String b = "B";
        double x = 1;

        for (int i = 0; i < arrayA.length; i++) {
                double z = pow(pow(x, 2) + 4.5, 1 / 3.0);
                System.out.printf("%s[% -3d]=%-10.5f\n", a, i, z);
        }
    }
}


//System.out.printf("%s[%- 3d]=%-10.4f ", name, i, array[i]);