package by.it.serkutsyev.jd01_15;

import by.it.serkutsyev.jd01_14.Filenames;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
/**
 * JavaDoc comment
 */


//1 line comment 1

//1 line comment 2

/* multiline comment 1*/

/* multiline comment 2*/
public class TaskB {
    public static void main(String[] args) {
        String fileName = "TaskB.txt";
        String javaFileName = "TaskB.java";
        String textFilePath = Filenames.findFilePath(fileName, TaskB.class);
        String javaFilePath = Filenames.findFilePath(javaFileName, TaskB.class);
        StringBuilder fullJavaFileText = readFromFile(javaFilePath);
        String javaTextWithoutComments = deleteCommentsFromFileText(fullJavaFileText);
        printToFile(javaTextWithoutComments, textFilePath);
        printToConsole(javaTextWithoutComments);
    }

    private static StringBuilder readFromFile(String javaFilePath) {
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(javaFilePath))) {
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return stringBuilder;
    }

    private static String deleteCommentsFromFileText(StringBuilder fullJavaFileText) {
        String fileTextAsString = fullJavaFileText.toString();
        char[] fileTextAsArray = fileTextAsString.toCharArray();
        StringBuilder textAfterDeletingComments = new StringBuilder();
        for (int i = 0; i < fileTextAsArray.length; i++) {
            if ((fileTextAsArray[i] == '/') && (fileTextAsArray[i + 1] == '/')) {
                while (fileTextAsArray[i] != '\n') {
                    i++;
                }
            } else if ((fileTextAsArray[i] == '/') && (fileTextAsArray[i + 1] == '*')) {
                i = i + 2;
                while ((fileTextAsArray[i] != '*') || (fileTextAsArray[i + 1] != '/')) {
                    i++;
                }
                i = i + 2;
            }


            textAfterDeletingComments.append(fileTextAsArray[i]);
        }
        return textAfterDeletingComments.toString().trim();
    }

    private static void printToFile(String javaTextWithoutComments, String textFilePath) {
        try (PrintWriter printWriter = new PrintWriter(textFilePath)) {
            printWriter.println(javaTextWithoutComments);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void printToConsole(String javaTextWithoutComments) {
        System.out.println(javaTextWithoutComments);
    }
}