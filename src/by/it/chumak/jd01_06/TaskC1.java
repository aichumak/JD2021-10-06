package by.it.chumak.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {
    public static void main(String[] args) {
        StringBuilder sbText = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("[^\\n]+");
        Matcher matcher = pattern.matcher(sbText);
        int maxLengthTextSentences = 0;

        while (matcher.find()) {
            if (matcher.group().length() > maxLengthTextSentences) {
                maxLengthTextSentences = matcher.group().length();
            }
        }
        matcher.reset();
        while (matcher.find()) {
            if (matcher.group().length() < maxLengthTextSentences) {
                StringBuilder bufferLine = new StringBuilder(matcher.group());
                int countSpaces = maxLengthTextSentences - matcher.group().length();
                insertSpaces(bufferLine, countSpaces);
                System.out.println(bufferLine);
            } else {
                System.out.println(matcher.group());
            }
        }
    }

    private static void insertSpaces(StringBuilder bufferLine, int countSpaces) {
        while (countSpaces != 0) {
            for (int i = 0; i < bufferLine.length(); i++) {
                if (countSpaces == 0 || i == bufferLine.length() - 1) {
                    break;
                }
                if (bufferLine.charAt(i) == ' ') {
                    if (bufferLine.charAt(i + 1) == ' ') {
                        continue;
                    }
                    bufferLine.insert(i + 1, ' ');
                    i += 2;
                    countSpaces--;
                }
            }
        }
    }
}
