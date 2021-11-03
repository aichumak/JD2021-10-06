package by.it.astapchik.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {

    public static void main(String[] args) {
        StringBuilder poem = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("[a-яА-яёЁ]{4,}");
        Matcher matcher = pattern.matcher(poem);
        while (matcher.find()){
            int startWord = matcher.start();
            int endWord = matcher.end();
            int length = endWord - startWord;
            poem.setCharAt(startWord+3, '#');
            if(length>=7){
                poem.setCharAt(startWord+6, '#');
            }
        }
        System.out.println(poem);
    }

}
