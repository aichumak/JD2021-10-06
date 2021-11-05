package by.it.serkutsyev.jd01_06;

import java.util.Arrays;
import java.util.Comparator;

public class TaskC1 {
    public static void main(String[] args) {
        String poemText = Poem.text;
        String[] sentences = poemText.split("[\n]+");
        String[] sentencesCopy = Arrays.copyOf(sentences, sentences.length);
        Arrays.sort(sentences, Comparator.comparingInt(String::length));
        int lengthLongestRow = sentences[sentences.length - 1].length();
        for (int i = 0; i < sentencesCopy.length; i++) {

            if (sentencesCopy[i].length() < lengthLongestRow) {
                String specialSentece = sentencesCopy[i];
                addSpacesToRow(specialSentece, lengthLongestRow);
                // System.out.println(sentencesCopy[i]);
            } else {
                System.out.println(sentencesCopy[i]);
            }
        }
    }

    private static void addSpacesToRow(String specialSentece, int lengthLongestRow) {
        specialSentece = specialSentece.trim();
        String[] words = specialSentece.split(" ");
        for (int i = 0; i < words.length - 1; i++) {
            words[i] = words[i] + " ";
        }
        int totalLenght = 0;
        for (int i = 0; i < words.length; i++) {
            totalLenght = totalLenght + words[i].length();

        }
        int difference = lengthLongestRow - totalLenght;
        int k = 0;
        while (k < difference) {
            for (int j = 0; j < words.length - 1; j++) {
                words[j] = words[j] + " ";
                k++;
                if (k==difference){
                    break;
                }
            }
        }
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            out.append(words[i]);
        }
        System.out.println(out.toString());
    }
}
