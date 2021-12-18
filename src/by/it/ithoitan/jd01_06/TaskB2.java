package by.it.ithoitan.jd01_06;


public class TaskB2 {
    public static void main(String[] args) {
        String text = Poem.text;
        String s1 = text.replaceAll("[\\n]", " ");
        String s2 = s1.replace("...", "");
        String s3 = s2.replaceAll("[!.?]", "\n");
        String s = s3.replaceAll("[\\p{Punct}]", "");
        String[] a = s.split("\n");
        String[] a2 = new String[a.length];
        for (int i = 0; i < a.length; i++) {
            a2[i] = a[i].trim();
        }

        for (int j = 0; j < a2.length - 1; j++) {
            for (int i = j + 1; i < a2.length; i++) {
                if (a2[i].length() < a2[j].length()) {
                    String temp = a2[j];
                    a2[j] = a2[i];
                    a2[i] = temp;
                }
//
            }
        }
        for (String n : a2) {
            System.out.println(n);

        }


    }


}





