package by.it.serkutsyev.jd01_09;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    public Var calc(String expression) {
        // 2+2*2-2/2
        expression = expression.replace(" ", "").trim();
        String[] partsOfExpression = expression.split(Patterns.SEPARATOR, 2);
        String stringLeftPart = partsOfExpression[0];
        Var varLeftPart = VarCreator.create(stringLeftPart);
        if (partsOfExpression.length == 1) {
            return varLeftPart;
        }
        String stringRightPart = partsOfExpression[1];
        Var varRightPart = VarCreator.create(stringRightPart);
        if (!Objects.isNull(varLeftPart) && !Objects.isNull(varRightPart)) {
            Pattern pattern = Pattern.compile(Patterns.SEPARATOR);
            Matcher matcher = pattern.matcher(expression);
            if (matcher.find()) {
                String operation = matcher.group();
                switch (operation) {
                    case "+":
                        return varLeftPart.add(varRightPart);
                    case "-":
                        return varLeftPart.sub(varRightPart);
                    case "*":
                        return varLeftPart.mul(varRightPart);
                    case "/":
                        return varLeftPart.div(varRightPart);
                }
            }
        }

         return null;
    }
}
