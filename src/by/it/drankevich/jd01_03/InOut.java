package by.it.drankevich.jd01_03;

public class InOut {
    static double[] getArray(String line){
        line=line.trim();
        String [] arraystr = line.split(" ");
        double [] array = new double[arraystr.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Double.parseDouble(arraystr[i]);
        }

        return array;
        }
    static void printArray(double[ ] array){
        for (double elem : array) {
            System.out.print(elem+" ");

        }

    }

    static void printArray(double[] array, String name, int columcount) {
        for (int i = 0; i < array.length; i++) {

            System.out.printf("%s[ %-3d]=%-8.4f",name,i,array[i]);
            if((i+1)%columcount==0||i== array.length-1){
                System.out.println();
            }

        }
    }
}

