package by.it.kanaplianik.jd01_03;

class InOut {
    static double[] getArray(String line) {
        //" 1 2 66 88 91  "
        line = line.trim();
        String[] stringValues = line.split(" ");
        double[] doubleValues = new double [stringValues.length];
        for (int i = 0; i < stringValues.length; i++) {
            doubleValues[i] = Double.parseDouble(stringValues[i]);
        }
        return doubleValues;
    }

    static void printArray(double[] array) {
        for (double element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
    static void printArray(double[ ] array, String name, int columnCount) {
        System.out.printf("%s%n", name);
        for (int i = 0; i < array.length; i++) {
            if (i % columnCount == 0)
                System.out.println();
            System.out.printf("%s[%- 3d]=%-10.4f ", name, i, array[i]);
        }
        System.out.println();
    }
}
