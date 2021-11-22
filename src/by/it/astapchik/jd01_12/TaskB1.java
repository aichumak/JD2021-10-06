package by.it.astapchik.jd01_12;

import java.util.*;

class TaskB1 {

    private static final String STOP = "end";
    private static final String PATTERN = "[\\s,.?!:;]+";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> text = new ArrayList<>();
        HashSet<String> resultSet = new HashSet<>();


        scanText(input, text);
        findFrequency(text, resultSet);
        printResult(resultSet);
    }

    private static void scanText(Scanner input, ArrayList<String> text) {
        for( ; ; ){
            String words = input.nextLine();
            if (words.equals(STOP)){
                break;
            }
            else {
                String[] arrayOfText = words.trim().split(PATTERN);
                for (int i = 0; i < arrayOfText.length; i++) { text.add(arrayOfText[i]); }
            }
        }
    }

    private static void findFrequency(ArrayList<String> text, HashSet<String> resultSet) {
        Iterator<String> iterator = text.iterator();
        while (iterator.hasNext()){
            String word = iterator.next();
            int n = Collections.frequency(text, word);
            resultSet.add(word + "=" +n);
        }
    }

    private static void printResult(HashSet<String> resultSet) {
        System.out.println(resultSet);
    }

}
