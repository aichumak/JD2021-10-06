package by.it.laevskiy.jd01_13;

import java.util.*;

public class TaskB {
    public static final String STOP_APP_COMMAND = "end";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> buffer = new ArrayList<>();
        while (true) {
            String words = scanner.nextLine();
            if (words.equalsIgnoreCase(STOP_APP_COMMAND)) {
                double lastBufferValue = buffer.isEmpty() ? 0 : buffer.get(buffer.size() -1);
                double bufferSum = buffer.stream().reduce(Double::sum).orElse(0.0);
                System.out.println("The last parsed - " + lastBufferValue);
                System.out.println("Square root of previously parsed strings including the last one " + Math.sqrt(bufferSum));
                break;
            } else {
                String[] strings = words.trim().split("[,\\.;:!?\\s]+");
                for (String string : strings) {
                    try {
                        double stringAsDouble = Double.parseDouble(string);
                        buffer.add(stringAsDouble);
                    } catch (NumberFormatException | ArithmeticException exc) {
                        System.out.println(new ExceptionInfo(exc, TaskB.class));
                    }
                }
            }
        }
    }
}
