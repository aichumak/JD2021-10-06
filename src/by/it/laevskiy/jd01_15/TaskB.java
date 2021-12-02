package by.it.laevskiy.jd01_15;


import java.io.*;
import java.util.Random;

/**
 * Класс для создания массива и заполнения массива с последующим вывода его в файл и консоль
 * Выполнил Дмитрий Лаевский
 */
public class TaskB {
    //формат вывода значений
    public static final String PRINT_FORMAT = "%3d ";
    //формат разделения строк
    public static final String LINE_SEPARATOR = "line.separator";
    public static final String NAME_FILE = "TaskB.java";

    public static void main(String[] args) throws IOException {
        /*
        задаем исходные данные для генерации массива с заданным диапазоном чисел
         */
        int[][] array = generateArray(6, 4, -15, 15);
        String fileName = FileName.getFullPath(NAME_FILE, TaskB.class);
        StringBuilder javaToConsole = getStringBuilder(fileName);
        System.out.println(javaToConsole);

    }

    @SuppressWarnings("SameParameterValue")
    private static int[][] generateArray(int rowCount, int colCount, int min, int max) {
        int[][] array = new int[rowCount][colCount];
        final Random random = new Random();
        for (int[] row : array) {
            for (int i = 0; i < row.length; i++) {
                row[i] = min + random.nextInt(max - min + 1);
            }
        }
        return array;
    }

    /*
    метод для вывода информации в файл
     */
    private static void printToFile(int[][] array, String fileMatrixName) {
        try (PrintWriter printWriter = new PrintWriter(fileMatrixName)) {
            for (int[] row : array) {
                for (int element : row) {
                    printWriter.printf(PRINT_FORMAT, element);
                }
                printWriter.println();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static StringBuilder getStringBuilder(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        StringBuilder text = new StringBuilder();
        String ls = System.getProperty(LINE_SEPARATOR);
        while (null != (line = reader.readLine())) {
            text.append(line);
            text.append(ls);
        }
        text.deleteCharAt(text.length() - 1);
        return text;
    }

}

