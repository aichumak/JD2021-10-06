package by.it._tasks_.kachanovich.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class TaskA1 {
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("[а-яЁёА-Я]{4,}");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()){
            int start = matcher.start();
            int end = matcher.end();
            str.setCharAt(start+3,'#');
            if(matcher.group().length()>=7){
                str.setCharAt(start+6,'#');
            }
        }
        System.out.println(str);
    }
}
