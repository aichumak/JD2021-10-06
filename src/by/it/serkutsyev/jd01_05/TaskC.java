package by.it.serkutsyev.jd01_05;
import static java.lang.Math.*;

public class TaskC {
    public static void main(String[] args) {
        step1();
    }

    static void step1() {
        int countOfElements = (int) ((Math.random() * (40 - 20)) + 20);
        System.out.println(countOfElements);
        double originalArray[] = new double[countOfElements];
        double delta = (9 - 5.33) / (countOfElements-1);
        System.out.println(delta);
        String name = "A";
        int index = 0;
        System.out.println("Массив A[]");
        int columnCount = 5;
        for (double x = 5.33; x <= 9 && index < countOfElements; x += delta) {
            double z = pow((pow(x,2) + 4.5), 1.0 / 3);
            originalArray[index] = z;
            System.out.printf("%2$s[%1$ -3d]=%3$f", index, name, originalArray[index]);
            index++;
            if (index % columnCount == 0){
                System.out.println();
            }
        }

        System.out.println(" ");
        int numberOfLargeElements = 0;
        for (int i = 0; i < originalArray.length; i++) {
            if (originalArray[i]>3.5){
                numberOfLargeElements++;
            }
        }
        double [] newArray = new double[numberOfLargeElements];
        int indexNewArray = 0;
        System.out.println("Массив B[] из элементов массива A > 3.5");
        String nameNew = "B";
        for (int i = 0; i < originalArray.length; i++) {
            if (originalArray[i]>3.5){
                newArray[indexNewArray]= originalArray[i];
               // indexNewArray++;
                System.out.printf("%2$s[%1$ -3d]=%3$f", indexNewArray, nameNew, newArray[indexNewArray]);
                indexNewArray++;
                if (indexNewArray % columnCount == 0) {
                    System.out.println();
                }
            }
        }
        System.out.println(" ");
        double multiply = 1;
        for (int i = 0; i < newArray.length; i++) {
            multiply = multiply * newArray[i];
        }
        double averageGeometrical = pow(multiply, 1.0 / newArray.length);
        System.out.println(averageGeometrical);
    }
}
