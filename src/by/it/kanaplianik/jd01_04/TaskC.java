package by.it.kanaplianik.jd01_04;

public class TaskC {
    public static void main(String[] args){

    }
    static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        double firstValue = array[0];
        double lastValue = array[array.length - 1];
        InOut.printArray(array, "V", 5);
        Helper.sort(array);
        InOut.printArray(array, "V", 4);
        int firstValueIndex = binarySearch(array,firstValue);
        int lastValueIndex = binarySearch(array,lastValue);
        System.out.println("Index of first element=" + firstValueIndex);
        System.out.println("Index of last element=" + lastValueIndex);

    }

    static int binarySearch ( double[] a, double v) {
        //this algorithm working only with values that are presented in array
        int leftIndex = 0;
        int rightIndex = a.length - 1;
        int middleIndex = 0;
        do {
            middleIndex = (leftIndex + rightIndex) / 2;
            if (a[middleIndex] < v) {
                leftIndex = middleIndex + 1;
            } else {
                rightIndex = middleIndex - 1;
            }

        } while (a[middleIndex] != v);
        return middleIndex;
    }
}
