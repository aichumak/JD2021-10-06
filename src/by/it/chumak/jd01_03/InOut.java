package by.it.chumak.jd01_03;

public class InOut {
    static double[] getArray(String line) {
        line = line.trim();
        String[] arrayStrings = line.split(" ");
        int countArrayRows = arrayStrings.length;
        double[] arrayDoubleNumbers = new double[countArrayRows];

        for (int i = 0; i < arrayStrings.length; i++) {
            arrayDoubleNumbers[i] = Double.parseDouble(arrayStrings[i]);
        }
        return arrayDoubleNumbers;
    }

    static void printArray(double[] arrayDoubleNumbers) {
        for (double element : arrayDoubleNumbers) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    static void printArray(double[] arrayDoubleNumbers, String name, int columnCount) {
        for (int i = 0; i < arrayDoubleNumbers.length; i++) {
            System.out.printf("%s[%- 3d]=%-10.4f", name, i, arrayDoubleNumbers[i]);
            if ((i + 1) % columnCount == 0 || i == arrayDoubleNumbers.length - 1) {
                System.out.println();
            }
        }
    }
}