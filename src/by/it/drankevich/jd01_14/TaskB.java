package by.it.drankevich.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {
    public static void main(String[] args) {
        Class<TaskB> taskBClass = TaskB.class;
        String filename = Filenames.getFullPath(taskBClass, "Poem.txt");
        String text = getText(filename);

        int countPunctuations = countPunctuations(text);
        int countWords = countWord(text);
        System.out.printf("words=%d, punctuation marks=%d", countWords, countPunctuations);
        String filenameText = Filenames.getFullPath(taskBClass, "resultTaskB.txt");
        printToFile(countPunctuations, countWords, filenameText);

    }


    private static String getText(String filename) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {

            String s;
            while ((s = bufferedReader.readLine()) != null) {

                stringBuilder.append(s).append("\n");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }


    private static int countWord(String text) {
        Pattern pattern = Pattern.compile("[а-яА-яёЁ]+");
        Matcher matcher = pattern.matcher(text);
        int count = 0;
        while (matcher.find()) {
            count++;

        }
        return count;
    }


    private static int countPunctuations(String text) {
        Pattern pattern = Pattern.compile("[\\,\\.\\;\\?\\!\\-:]+");

        Matcher matcher = pattern.matcher(text);
        int count = 0;
        while (matcher.find()) {
            count++;

        }
        return count;
    }


    private static void printToFile(int countPunctuations, int countWords, String filenameText) {

        try (PrintWriter printWriter = new PrintWriter(filenameText)) {
            printWriter.printf("words=%d, punctuation marks=%d", countWords, countPunctuations);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
