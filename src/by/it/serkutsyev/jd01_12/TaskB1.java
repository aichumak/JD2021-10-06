package by.it.serkutsyev.jd01_12;


import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args) {
        HashMap<String, Integer> words = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        outerloop:
        for (; ; ) {
            String content = scanner.next();
            StringBuilder poemText = new StringBuilder(content);
            Pattern patternForPoem = Pattern.compile("[a-zA-Z']+");
            Matcher matcherForPoem = patternForPoem.matcher(poemText);
            while (matcherForPoem.find()) {
                int indexOfFirstElement = matcherForPoem.start();
                int indexOfLastElement = matcherForPoem.end();
                String word = poemText.substring(indexOfFirstElement, indexOfLastElement);

                if (word.equals("end")) {
                    break outerloop;
                }
                if (words.containsKey(word)) {
                    Integer counter = words.get(word);
                    words.put(word,counter+1);
                }
                else {
                    words.put(word, 1);
                }


            }
        }
        System.out.println(words);
    }
}


