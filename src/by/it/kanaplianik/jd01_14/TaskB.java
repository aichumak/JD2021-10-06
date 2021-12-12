package by.it.kanaplianik.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {
    public static void main(String[] args) {

        StringBuilder fullPoem = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(new File(getFullPath("Poem.txt"))))) {
            String buffer;
            while ((buffer = reader.readLine()) != null) {
                fullPoem.append(buffer);
                fullPoem.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(fullPoem);

        Pattern pattern = Pattern.compile("[а-яА-яёЁ]+");
        Matcher matcher = pattern.matcher(fullPoem);
        int wordsCount = 0;
        while (matcher.find()) {
            wordsCount++;
        }
        Pattern punctuationPattern = Pattern.compile(",|- |:|!|\\.{3}|\\.");
        Matcher matcherPunctuatin = punctuationPattern.matcher(fullPoem);
        int punctuationCount = 0;
        while (matcherPunctuatin.find()) {
            punctuationCount++;
        }


        String resultWordsAndPunctuation = "words=" + wordsCount + ", punctuation marks=" + punctuationCount;
        System.out.println(resultWordsAndPunctuation);


        try (FileWriter textWriter = new FileWriter(new File(getFullPath("resultTaskB.txt")))) {
            textWriter.write(resultWordsAndPunctuation);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static double average(ArrayList<Integer> newArray) {
        int itemCount = newArray.size();
        double sum = 0;
        double avg = 0;
        for (int i = 0; i < itemCount; i++) {
            sum += newArray.get(i);
        }
        avg = sum / itemCount;
        System.out.println("avg=" + avg);
        return avg;
    }

    public static String toFormattedString(ArrayList<Integer> array) {
        StringBuilder result = new StringBuilder();
        for (Integer i : array) {
            result.append(i).append(" ");
        }
        return result.toString().trim();
    }

    public static String getFullPath(String fileName) {
        String srcProject = System.getProperty("user.dir")
                + File.separator
                + "src"
                + File.separator;
        String name = TaskB.class.getName();
        String simpleName = TaskB.class.getSimpleName();
        String relationPath = name
                .replace(simpleName, "")
                .replace(".", File.separator);
        return srcProject + relationPath + fileName;
    }


}
