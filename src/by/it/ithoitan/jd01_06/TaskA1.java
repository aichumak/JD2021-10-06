package by.it.ithoitan.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {
    public static void main(String[] args) {
        StringBuilder modyfyText = new StringBuilder(Poem.text);
        Pattern pattern=Pattern.compile("[а-яА-ЯёЁ]{4,}");
        Matcher matcher = pattern.matcher(modyfyText);
        while (matcher.find()){
            int startWordPosition = matcher.start();
            int nextSymbolPosition = matcher.end();
            int length = nextSymbolPosition - startWordPosition;
            modyfyText.setCharAt(startWordPosition+3,'#');
            if(length>=7){
                modyfyText.setCharAt(startWordPosition+6, '#');
            }

        }

        System.out.println(modyfyText);
    }
}
