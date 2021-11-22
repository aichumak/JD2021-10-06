package by.it.chumak.jd01_14;

import java.io.IOException;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {
    private static final String FILENAME_TASK_A1 = "Poem.txt";
    private static final String FILENAME_TASK_A2 = "resultTaskB.txt";
    private static final String WORDS = "words=";
    private static final String PUNCTUATION_MARKS = "punctuation marks=";

    public static void main(String[] args) {
        Class<?> structureClass = TaskA.class;
        GetPathMethod getPathMethod = new GetPathMethod();
        String path = getPathMethod.getFilePath(structureClass, FILENAME_TASK_A1);
        String pathResult = getPathMethod.getFilePath(structureClass, FILENAME_TASK_A2);
        StringBuilder stringBuilder = new StringBuilder();

        try {
            readFile(path, stringBuilder);
            printResults(pathResult, calculateNumberPunctuationMarksAndWords(stringBuilder));
        } catch (IOException e) {
            ExceptionsInfo exceptionsInfo = new ExceptionsInfo();
            System.out.println(exceptionsInfo.getExceptionInfo(e, TaskB.class.getName()));
        }
    }

    private static void readFile(String path, StringBuilder stringBuilder) throws IOException {
        ReadFile readFile = new ReadFile();
        readFile.readFile(path, stringBuilder);
    }

    private static String calculateNumberPunctuationMarksAndWords(StringBuilder stringBuilder) {
        StringJoiner joiner = new StringJoiner(", ");
        joiner.add(calculateNumberSymbols(stringBuilder, "[а-яА-ЯёЁ]+", WORDS));
        joiner.add(calculateNumberSymbols(stringBuilder, "[...!,-?:;]+", PUNCTUATION_MARKS));

        return joiner.toString();
    }

    private static String calculateNumberSymbols(StringBuilder stringBuilder, String regEx, String title) {
        int count = 0;
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(stringBuilder);

        while (matcher.find()) {
            count++;
        }

        return title + count;
    }

    private static void printResults(String path, String textLine) throws IOException {
        PrintToFile printToFile = new PrintToFile();
        System.out.println(textLine);
        printToFile.printStringToFile(path, textLine);
    }
}
