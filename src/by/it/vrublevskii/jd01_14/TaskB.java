package by.it.vrublevskii.jd01_14;

import jdk.swing.interop.SwingInterOpUtils;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {

    public static final String FILE_TXT = "Poem.txt";
    public static final String RESULT_FILE_TXT = "resultTaskB.txt";
    //    public static final String PUNCTUATION_AND_WORDS = "([а-яА-ЯёЁ]+)|(,|\\.\\.\\.|\\.|:|-|!)";
    public static final String REGEX_WORDS = "[а-яА-ЯёЁ]+";
    public static final String REGEX_PUNCTUATION = ",|\\.\\.\\.|\\.|:|-|!";

    public static void main(String[] args) {
        String fullPathIn = FileNames.getFullPath(FILE_TXT, TaskB.class);
        String text = readTextFromFile(fullPathIn);
        int words = countElements(text, REGEX_WORDS);
        int punctuationMarks = countElements(text, REGEX_PUNCTUATION);
        System.out.println("words=" + words + " punctuation marks=" + punctuationMarks);
        String fullPathOut = FileNames.getFullPath(RESULT_FILE_TXT, TaskB.class);
        printToFile(words, punctuationMarks, fullPathOut);
    }

//        int words = 0;
//        int punctuationMarks = 0;
//        Pattern pattern = Pattern.compile(PUNCTUATION_AND_WORDS);
//        Matcher matcher = pattern.matcher(text);
//        while (matcher.find()){
//            if (matcher.group(1) != null){
//                words++;
//            }
//            if (matcher.group(2) != null){
//                punctuationMarks++;
//            }
//        }

    private static String readTextFromFile(String fullPath) {
        StringBuilder stringBuilder = new StringBuilder();
        try (FileReader reader = new FileReader(fullPath)) {
            int symbol;
            while ((symbol = reader.read()) != -1) {
                stringBuilder.append((char) symbol);
            }
        } catch (IOException e) {
            throw new RuntimeException(fullPath);
        }
        return String.valueOf(stringBuilder);
    }

    private static int countElements(String text, String regex) {
        int counter = 0;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            counter++;
        }
        return counter;
    }

    private static void printToFile(int words, int punctuationMarks, String fullPathOut) {
        try (PrintWriter printWriter = new PrintWriter(fullPathOut)) {
            printWriter.printf("words=%d punctuation marks=%d", words, punctuationMarks);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}


