package by.it.drankevich.jd01_15;

import by.it.drankevich.jd01_14.Filenames;

import java.io.*;

/**
 * @author drankevich
 */

public class TaskB {


//Первый однострочный комментарий

//Второй однострочный комментарий

    public static void main(String[] args) {
        String filename = Filenames.getFullPath(TaskB.class, "TaskB.java");
        String allFileTaskBJavaToString = fileJavaToString(filename);
        String formattedFileTaskBJavaToString = formattedString(allFileTaskBJavaToString);
        System.out.println(formattedFileTaskBJavaToString);
        String txtFilename = Filenames.getFullPath(TaskB.class, "TaskB.txt");
        printToTaskBtxt(formattedFileTaskBJavaToString, txtFilename);
    }



  /*Первый
        многострочный комментарий
        * */

         /*Второй
        многострочный комментарий
         */


    private static String fileJavaToString(String filename) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader
                (new FileInputStream(filename)))) {
            while (bufferedReader.ready()) {

                stringBuilder.append((char) bufferedReader.read());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }


    private static String formattedString(String allFileTaskBJavaToString) {
        char[] charArray = allFileTaskBJavaToString.toCharArray();

        StringBuilder resultStringBuilder = new StringBuilder();
        for (int i = 0; i < charArray.length; i++) {

            if (charArray[i] == '/' && charArray[i + 1] == '/') {

                do {
                    i++;
                }
                while (charArray[i] != '\n');

            }

            if (charArray[i] == '/' && charArray[i + 1] == '*') {
                i++;

                do {
                    i++;
                }
                while (!(charArray[i] == '*' & charArray[i + 1] == '/'));
                if (i + 2 < charArray.length - 1) {
                    i = i + 2;
                }

            }

            resultStringBuilder.append(charArray[i]);

        }
        return resultStringBuilder.toString();
    }


    private static void printToTaskBtxt(String formattedFileTaskBJavaToString, String txtFilename) {

        try (PrintWriter printWriter = new PrintWriter(txtFilename)) {

            printWriter.print(formattedFileTaskBJavaToString);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}




