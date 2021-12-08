package by.it.laevskiy.jd01_14;


import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {

    public static final String RESULT_TXT = "resultTaskB.txt";
    public static final String PATTERN_FOR_WORDS = "[а-яА-ЯёЁ]+";
    public static final String PATTERN_FOR_PUNCTUATION = "[.{1,3}!,-?:;]+";
    public static final String NAME_FILE = "Poem.txt";
    public static final String LINE_SEPARATOR = "line.separator";
    public static final String PRINT_FORMAT = "words=%d, punctuation marks=%d%n";

    public static void main(String[] args) throws IOException {
        String fileName = FileName.getFullPath(NAME_FILE, TaskB.class);
        StringBuilder text = getStringBuilder(fileName);
        int countWords = getCountWords(text);
        int countPunctuation = getCountPunctuation(text);
        System.out.printf(PRINT_FORMAT, countWords, countPunctuation);
        String txtOut = FileName.getFullPath(RESULT_TXT, TaskA.class);
        printToFile(countWords, countPunctuation, txtOut);
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

    private static int getCountWords(StringBuilder text) {
        Pattern words = Pattern.compile(PATTERN_FOR_WORDS);
        Matcher findWords = words.matcher(text);
        int countWords = 0;
        while (findWords.find()) {
            countWords++;
        }
        return countWords;
    }

    private static int getCountPunctuation(StringBuilder text) {
        Pattern punctuation = Pattern.compile(PATTERN_FOR_PUNCTUATION);
        Matcher findPunctuation = punctuation.matcher(text);
        int countPunctuation = 0;
        while (findPunctuation.find()) {
            countPunctuation++;
        }
        return countPunctuation;
    }

    private static void printToFile(int countWords, int countPunctuation, String txtOut) {

        try (PrintWriter printWriter = new PrintWriter(txtOut)) {
            printWriter.printf(PRINT_FORMAT, countWords, countPunctuation);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}



