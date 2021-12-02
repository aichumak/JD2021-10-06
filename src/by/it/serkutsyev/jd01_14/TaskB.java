package by.it.serkutsyev.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {

    public static final String POEM_TXT = "Poem.txt";
    public static final String REGEX_FOR_WORDS = "[а-яА-ЯёЁ]+";
    public static final String REGEX_FOR_PUNCTUACTION_MARKS = "[.,!?:-]+";
    public static final String RESULT_TASK_B_TXT = "resultTaskB.txt";
    public static final String FORMAT_FOR_WORDS_COUNTER = "%nwords=%d%n";
    public static final String FORMAT_FOR_PUNCTUATION_MARKS = "%npunctuation marks=%d%n";
    public static final String APPEND = " ";

    public static void main(String[] args) {
        StringBuilder stringBuilder = readPoemFromFile();
        int wordsCounter = getWordsCounter(stringBuilder);
        int punctuationMarkCounter = getPunctuationMarkCounter(stringBuilder);
        printToConsole(wordsCounter, punctuationMarkCounter);
        String txtPath = Filenames.findFilePath(RESULT_TASK_B_TXT, TaskB.class);
        printToFile(wordsCounter, punctuationMarkCounter, txtPath);
    }

    private static StringBuilder readPoemFromFile() {
        String poemPath = Filenames.findFilePath(POEM_TXT, TaskB.class);
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(poemPath))) {
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append(APPEND);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return stringBuilder;
    }

    private static int getWordsCounter(StringBuilder stringBuilder) {
        int wordsCounter = 0;
        Pattern patternForWords = Pattern.compile(REGEX_FOR_WORDS);
        Matcher matcherForWords = patternForWords.matcher(stringBuilder);
        while (matcherForWords.find()) {
            wordsCounter++;
        }
        return wordsCounter;
    }

    private static int getPunctuationMarkCounter(StringBuilder stringBuilder) {
        int punctuationMarkCounter = 0;
        Pattern patternForPunctuationMarks = Pattern.compile(REGEX_FOR_PUNCTUACTION_MARKS);
        Matcher matcherForPunctuationMarks = patternForPunctuationMarks.matcher(stringBuilder);
        while (matcherForPunctuationMarks.find()) {
            punctuationMarkCounter++;
        }
        return punctuationMarkCounter;
    }

    private static void printToConsole(int wordsCounter, int punctuationMarkCounter) {
        System.out.printf(FORMAT_FOR_WORDS_COUNTER, wordsCounter);
        System.out.printf(FORMAT_FOR_PUNCTUATION_MARKS, punctuationMarkCounter);
    }

    private static void printToFile(int wordsCounter, int punctuationMarkCounter, String txtPath) {
        try (PrintWriter printWriter = new PrintWriter(txtPath)) {
            printWriter.printf(FORMAT_FOR_WORDS_COUNTER, wordsCounter);
            printWriter.printf(FORMAT_FOR_PUNCTUATION_MARKS, punctuationMarkCounter);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
