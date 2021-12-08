package by.it.konon.jd01_15;

import by.it.konon.jd01_14.FileNames;

import java.io.*;

public class TaskB {
    // Hello World!
    // Hello Java!

    /* Multi-line comment */
    /* its just a comment*/

    /**
     * Java-doc comment
     */

    public static void main(String[] args) {

        String fileName = FileNames.getFullPath("TaskB.java", TaskB.class);
        String File = ConvertFile(fileName);
        String filterComment = filter(File);
        String text = FileNames.getFullPath("TaskB.txt", TaskB.class);
        writeToFile(filterComment, text);
        System.out.println(filterComment);


    }

    private static String ConvertFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        String lineSeparator = System.lineSeparator();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {

            String str;
            while ((str = bufferedReader.readLine()) != null) {
                stringBuilder.append(str).append(lineSeparator);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    private static String filter(String file) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] array = file.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == '/' && array[i + 1] == '/') {
                do {
                    i++;
                }
                while (array[i] != '\n');
            }
            if (array[i] == '/' && array[i + 1] == '*') {
                i++;
                do {
                    i++;
                } while (!(array[i] == '*' & array[i + 1] == '/'));
                if (i + 2 < array.length - i) {
                    i = i+2;
                }
            }
            stringBuilder.append(array[i]);
        }
        return stringBuilder.toString();

    }

    private static void writeToFile(String filterComment, String text) {
        try (PrintWriter printWriter = new PrintWriter(text)) {

            printWriter.println(filterComment);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
