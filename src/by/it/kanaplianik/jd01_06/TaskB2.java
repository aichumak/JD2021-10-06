package by.it.kanaplianik.jd01_06;

public class TaskB2 {
    public static void main(String[] args) {
        String cleanedText;
        cleanedText = cleanUpText();
        String[] splitted = splitToSentences(cleanedText);
        String[] trimmed = trim(splitted);
        String[] sorted = sortByLength(trimmed);
        printSentences(sorted);
    }

    static String cleanUpText() {
        // если этот метод нужно было делать через StringBuilder - то могу переписать.
        return Poem.text
                .replaceAll(",|- |:|\\.{3}", "")
                .replaceAll("\n", " ");
    }

    static String[] splitToSentences(String text) {
        return text.split("\\.");
    }

    static String[] trim(String[] sentences) {
        String[] trimmedStrings = new String[sentences.length];
        for (int i = 0; i < sentences.length; i++) {
            String trimmed = sentences[i].trim();
            trimmedStrings[i] = trimmed;
        }
        return trimmedStrings;
    }


    static String[] sortByLength(String[] sentences) {
        for (int k = 0; k < sentences.length; k++) {
            for (int i = 0; i <= sentences.length-2-k; i++) {
                if (sentences[i].length() > sentences[i+1].length()) {
                    String temporaryValue = sentences[i];
                    sentences[i] = sentences[i+1];
                    sentences[i+1] = temporaryValue;
                }
            }
        }
        return sentences;
    }

    static void printSentences(String[] sentences) {
        for (String element : sentences) {
            System.out.println(element);
        }
        System.out.println();
    }
}
