package by.it.fomin.jd01_04;

class InOut {
    static double[] getArray(String line) {
        //"1 5 6 45 87 645 64"
        line = line.trim();
        String[] stringValues = line.split(" ");
        double[] doubles = new double[stringValues.length];
        for (int i = 0; i < stringValues.length; i++) {
            doubles[i] = Double.parseDouble(stringValues[i]);
        }
        return doubles;
    }

    static void printArray(double[] array) {
        for (double element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    static void printArray(double[] array, String name, int quantityColumns) {
        for (int i = 0; i < array.length; i++) {
            // A[ 4 ] = 4.56458    |
            System.out.printf("%s[%- 3d]=%-10.4f ", name, i, array[i]);
            if ((i + 1) % quantityColumns == 0 || i == array.length - 1) {
                System.out.println();
            }
        }
    }
}
