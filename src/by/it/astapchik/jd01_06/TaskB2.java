//package by.it.astapchik.jd01_06;
//
//public class TaskB2 {
//
//    public static void main(String[] args) {
//        StringBuilder poem = new StringBuilder(Poem.text);
//        String sentences = poem.toString();
//        String text = sentences.replaceAll("\\.{3}", "");
//        String modify = text.replaceAll("[,:]", "");
//        String a = modify.replaceAll("[\\-]", "");
//        String[] per = a.replaceAll("\n", " ").split("[.!?]+");
//        int lengthSentences = per.length-1;
//
//
//
//        implementSorting(per, lengthSentences);
//        printResult(per, lengthSentences);
//    }
//
//    static void implementSorting(String[] s, int lengthSentences) {
//        for (int i = 1; i < lengthSentences; i++) {
//            String temp = s[i].trim();
//            int j = i - 1;
//            while (j >= 0 && temp.length() < s[j].length()) {
//                s[j + 1] = s[j];
//                j--;
//            }
//            s[j + 1] = temp;
//        }
//    }
//
//    static void printResult(String[] str, int lengthSentences) {
//        for (int i = 0; i < lengthSentences; i++) {
//            if (str[i].length() != str[i + 1].length()) {
//                System.out.println(str[i]);
//            }
//        }
//    }
//}