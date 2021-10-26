package by.it.serkutsyev.jd01_06;

import java.util.Arrays;
import java.util.Comparator;

public class TaskB2 {
    public static void main(String[] args) {
        String poemText = Poem.text;
        poemText = poemText.replace("...","");
        poemText = poemText.replace(",","");
        poemText = poemText.replace("\n"," ");
        poemText = poemText.replace(" -","");
        poemText = poemText.replace(":","");
        String [] sentences = poemText.split("[.!]+");
        for (int i = 0; i < sentences.length; i++) {
            sentences[i].replace(".","");
            sentences[i].replace("!","");
            sentences[i]=sentences[i].trim();
        }
        Arrays.sort(sentences, Comparator.comparingInt(String::length));
        for (int i = 0; i < sentences.length; i++) {
            System.out.println(sentences[i]);
        }
    }
}
