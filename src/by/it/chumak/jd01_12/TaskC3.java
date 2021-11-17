package by.it.chumak.jd01_12;

import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC3 {
    public static void main(String[] args) {
        StringBuilder stringBuilder = getStringBuilder();
        String[] array = stringBuilder.toString().split("");

        System.out.println(checkExpression(array));
    }

    private static StringBuilder getStringBuilder() {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        StringBuilder stringBuilder = new StringBuilder();
        Pattern pattern = Pattern.compile("[{\\[(}\\])]+");
        Matcher matcher = pattern.matcher(line);

        while (matcher.find()) {
            stringBuilder.append(matcher.group());
        }

        return stringBuilder;
    }

    private static boolean checkExpression(String[] array) {
        if (array.length % 2 > 0 || array.length < 1) {
            return false;
        }

        Stack<String> stack = new Stack<>();
        for (String element : array) {
            if (openingBrackets(element)) {
                stack.push(element);
            } else {
                if (matchingBrackets(element, stack.peek())) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean openingBrackets(String element) {
        return element.equals("{") || element.equals("[") || element.equals("(");
    }

    private static boolean matchingBrackets(String element, String stackPeek) {
        return switch (stackPeek) {
            case "{" -> element.equals("}");
            case "[" -> element.equals("]");
            case "(" -> element.equals(")");
            default -> false;
        };
    }

}
