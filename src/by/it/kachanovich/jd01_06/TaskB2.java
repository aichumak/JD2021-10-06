package by.it.kachanovich.jd01_06;



import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {


    static void printArray(String[] array) {
        for (String s : arrayText) {
            System.out.println(s);
        }
    }

    static String[] arrayText;

    public static void main(String[] args) {
        String text = Poem.text;
        arrayText = text.split("\\.\\n");
        Pattern pattern = Pattern.compile("[^а-яА-ЯЁё]{1,4}");
        for (int i = 0; i < arrayText.length; i++) {
            Matcher matcher = pattern.matcher(arrayText[i]);
            arrayText[i] = matcher.replaceAll(" ");
        }
        Pattern pattern1 = Pattern.compile("\\.$");
        for (int i = 0; i < arrayText.length; i++) {
            Matcher matcher1 = pattern1.matcher(arrayText[i]);
            arrayText[i] = matcher1.replaceAll("");
        }
        String strMin;
        for (int i = 0; i < arrayText.length; i++) {
            arrayText[i].trim();
            for (int j = 0; j < arrayText.length; j++) {
                if (arrayText[i].length() < arrayText[j].length()) {
                    strMin = arrayText[i];
                    arrayText[i] = arrayText[j];
                    arrayText[j] = strMin;
                }
            }
        }
        printArray(arrayText);
    }
}
