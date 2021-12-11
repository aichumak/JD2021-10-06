package by.it.astapchik.jd01_14;


import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class TaskB {
    public static void main(String[] args) {
        String fileName = FileNames.getFullPath( "Poem.txt", TaskB.class);
        String poem = scanText(fileName);

        int words = calculateWords(poem);
        int signs = calculateSign(poem);
        System.out.printf("words=%d, marks=%d", words,signs);
        String resultTask = FileNames.getFullPath( "resultTaskB.txt", TaskB.class);
        writeInFile(resultTask, words, signs);
    }

    private static void writeInFile(String resultTask, int words, int signs) {
        try (PrintWriter printWriter = new PrintWriter(resultTask)){
            printWriter.printf("words=%d, marks=%d", words, signs);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String scanText(String fileName) {
        StringBuilder text = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))){
            String row;
            while ((row = bufferedReader.readLine()) != null) {
                text.append(row).append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return text.toString();
    }

    private static int calculateSign(String poem) {
        Pattern patternSigns = Pattern.compile("[...?!,:-]+");
        Matcher matcherSigns = patternSigns.matcher(poem);
        int countSigns = 0;
        while (matcherSigns.find()){
            countSigns++;
        }
        return countSigns;
    }

    private static int calculateWords(String poem) {
        Pattern patternWords = Pattern.compile("[a-яА-яёЁ]+");
        Matcher matcherWords = patternWords.matcher(poem);
        int countWords = 0;
        while (matcherWords.find()){
            countWords++;
        }
        return countWords;
    }

}
