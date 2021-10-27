package by.it.chumak.jd01_03;

public class Runner {
    public static void main(String[] args) {
        String line = "1 22 33 55 44 77 88 55 11 22 33";
        String name = "arrayDoubleNumbers";
        double min = 0;
        double max = 0;

        double[] arrayDoubleNumbers = InOut.getArray(line);
        InOut.printArray(arrayDoubleNumbers);
        InOut.printArray(arrayDoubleNumbers, name, arrayDoubleNumbers.length);

        min = Helper.findMin(arrayDoubleNumbers);
        max = Helper.findMax(arrayDoubleNumbers);

        Helper.sort(arrayDoubleNumbers);

    }
}