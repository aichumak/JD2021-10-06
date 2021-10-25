package by.it.drankevich.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {
    public static void main(String[] args) {


        Pattern pattern = Pattern.compile("[\\n]");
        String[] str = pattern.split(Poem.text);
        for (int i = 0; i < str.length; i++) {
            str[i] = str[i].trim();
        }

        int max = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[max].length() < str[i].length()) {
                max = i;
            }

        }

        Pattern pat = Pattern.compile("[\\s]+");
        for (String s: str) {
            StringBuilder sb = new StringBuilder(s);

            Matcher matcher = pat.matcher(sb);
            do {
                int end = 0;
                while (matcher.find(end + 1)) {
                    int start = matcher.start();
                    end = matcher.end();
                    if (sb.length() < str[max].length()) {
                        sb.insert(start, ' ');
                    }

                }
            }
            while (sb.length() < str[max].length());
            System.out.println(sb);
        }


    }

}







