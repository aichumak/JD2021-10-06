package by.it.astapchik.jd01_04;

class InOut {

    static double[] getArray(String line) {
        line = line.trim();
        String[] stringValues = line.split(" ");
        double[] valuesDoubles = new double[stringValues.length];
        for (int i = 0; i < stringValues.length; i++) {
            valuesDoubles[i] = Double.parseDouble(stringValues[i]);
        }
        return valuesDoubles;
    }

    static void printArray(double[] array){
        for (double el : array) {
            System.out.print(el);
        }
        System.out.println();
    }
    static void printArray(double[] array, String name, int columnCount) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%s[%- 3d]=%-10.4f ", name, i, array[i]);
            if((i+1)%columnCount==0 || i==array.length-1){
                System.out.println();
            }
        }
    }



}
