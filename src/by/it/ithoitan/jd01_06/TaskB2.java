package by.it.ithoitan.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.it.ithoitan.jd01_06.Poem.text;

public class TaskB2 {
    public static void main(String[] args) {
        String text = Poem.text;
        String withoutSumbol = text.replaceAll("[!,.;:-]"," ");
        System.out.println(withoutSumbol);
        withoutSumbol.trim();
        System.out.print(withoutSumbol);
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+]");
        Matcher matcher= pattern.matcher(text);

    }
}
