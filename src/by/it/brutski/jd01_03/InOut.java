package by.it.brutski.jd01_03;

import java.util.Arrays;

class InOut {
    static double [] getArray(String line){
        //Удаляем пробелы в начале и конце:
        line = line.trim();
        //Преобразование строки в массив:
        String[] strings = line.split(" ");
        //Создаем массив array:
        double[] array = new double[strings.length];

        //Воспользуемся циклом for:
        for (int i = 0; i < strings.length; i++) {
            //Заполняем массив и возвращаем тип double инициализированым значением strings[i]:
            array[i] = Double.parseDouble(strings[i]);
        }
        return array;
    }

    static void printArray(double[ ] array){
        for (double elements : array) {
            System.out.print(Arrays.toString(new double[]{elements}));
        }
        System.out.println();
    }

    public static void printArray(double[] array, String name, int columnCount) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%s[%-1d] = %-3.2f ", name, i, array[i]);

            if(i == array.length - 1 || 0 == i % columnCount){
                System.out.println();
            }
        }
    }
}
