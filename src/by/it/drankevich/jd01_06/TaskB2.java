package by.it.drankevich.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(Poem.text);
        Pattern pat = Pattern.compile("[\\n,:-]");
        Matcher matcher = pat.matcher(sb);
        while (matcher.find()) {
            int start = matcher.start();
            sb.setCharAt(start, ' ');
        }
        Pattern p = Pattern.compile("[\s]{2,}");
        Matcher m = p.matcher(sb);
        int start = 0;
        while (m.find(start)) {
            start = m.start();
            sb.deleteCharAt(start);
        }

        Pattern pattern1 = Pattern.compile("[.]{3}");
        Matcher matcher1 = pattern1.matcher(sb);
        int end1=0;
        while (matcher1.find(end1)) {
            int start1 = matcher1.start();
            end1 = matcher1.end();
            sb.delete(start1,end1);
        }





        Pattern pattern = Pattern.compile("[.!?]");
        String[] str = pattern.split(sb);
        for (int i = 0; i < str.length; i++) {
            str[i] = str[i].trim();
        }


        for (int i = 0; i < str.length; i++) {
            int k=i;
            for (int j = i; j < str.length; j++) {
                if (str[k].length()>str[j].length()){
                   k=j;
                }

            }
            String t=str[k];
            str[k]=str[i];
            str[i]=t;


        }

        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]);
        }




    }
}












