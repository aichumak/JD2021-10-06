package by.it.laevskiy.jd01_12;

import java.util.*;

public class TaskB1 {
    public static final String STOP_APP_COMMAND = "end";
    public static void main(String[] args) {
        List<String> text = new ArrayList<>();
        HashSet<String> result = new HashSet<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String words = scanner.nextLine();
            if (words.equals(STOP_APP_COMMAND)) {
                break;
            } else {
                String[] strings = words.trim().split("[!?:;,\\.\\s]+");
                text.addAll(Arrays.asList(strings));
            }
        }
        Iterator<String> iterator = text.iterator();
        while (iterator.hasNext()) {
            String word = iterator.next();
            int count = Collections.frequency(text,word);
            result.add(word+"="+count);
        }
        System.out.println(result);
    }
}

