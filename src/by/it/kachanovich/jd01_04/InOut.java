package by.it.kachanovich.jd01_04;

class InOut {
    static double[] getArray(String line) {
        line = line.trim();
        String[] arrayString = line.split(" ");
        double[] arrayDouble = new double[arrayString.length];
        for (int i = 0; i < arrayDouble.length; i++) {
            arrayDouble[i] = Double.parseDouble(arrayString[i]);
        }
        return arrayDouble;
    }

    static void printArray(double[] array) {
        for (double v : array) {
            System.out.print(v + " ");
        }
        System.out.println();
    }

    static void printArray(double[] array, String name, int columnCount) {
        for (int i = 0; i < array.length; i++) {
            if (i % columnCount == 0) {
                System.out.println();
            }
            System.out.printf("%s[%1d]=%2.2f ", name, i, array[i]);

        }
        System.out.println();
    }


}
