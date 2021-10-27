package by.it.kachanovich.jd01_04;

class TaskC {
    static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        double first = array[0];
        double last = array[array.length - 1];
        InOut.printArray(array, "V", 5);
        array = Helper.sort(array);
        InOut.printArray(array, "V", 4);
        for (int i = 0; i < array.length; i++) {
            if (array[i] == first) {
                System.out.printf("Index of first element=%1d", i);
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] == last) {
                System.out.printf("Index of last element=%1d", i);
            }
        }
    }

    static void mergeSort(double[] array) {
        if (array.length <= 1) {
            return;
        }
        double[] arrayLeft = new double[array.length / 2];
        double[] arrayRight = new double[(array.length - (array.length / 2))];
        for (int i = 0; i < array.length; i++) {
            if (i < arrayLeft.length) {
                arrayLeft[i] = array[i];
            }
            if (i >= arrayLeft.length) {
                arrayRight[i - arrayLeft.length] = array[i];
            }
        }
        mergeSort(arrayLeft);
        if (arrayRight.length > 1) {
            mergeSort(arrayRight);
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < arrayRight.length; j++) {
                if (i == (array.length - 1)) {
                    array[i] = arrayRight[arrayRight.length - 1];
                    return;
                }
                if (i < arrayLeft.length) {
                    if (arrayLeft[i] <= arrayRight[j]) {
                        array[i] = arrayLeft[i];
                    } else {
                        array[i] = arrayRight[j];
                        arrayRight[j] = arrayLeft[i];
                        arrayLeft[i] = array[i];
                    }
                } else {

                    if (i - arrayLeft.length == j) {
                        mergeSort(arrayRight);
                        if (j + 1 == arrayRight.length) {
                            array[array.length - 1] = arrayRight[j];
                            return;
                        }
                        if (arrayRight[j] > arrayRight[j + 1]) {
                            array[i] = arrayRight[j + 1];
                            arrayRight[j + 1] = arrayRight[j];
                            arrayRight[j] = array[i];
                            i++;
                        } else {
                            array[i] = arrayRight[j];
                        }
                    }
                }
            }
        }
    }


    static int binarySearch(double[] array, double value) {
        int l = 0, r = array.length - 1;
        int middle;
        while (l <= r) {
            middle = (l + r) / 2;
            if (array[middle] == value) {
                return middle;
            } else if (array[middle] > value) {
                r = middle - 1;
            } else {
                l = middle + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        double[] array = {6, 5, 8, 1, 9, 7, 3, 4, 2};
        mergeSort(array);
    }
}
