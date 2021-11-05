package by.it.chumak.jd01_09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    public Var evaluate(String expression) {
        VarCreator varCreator = new VarCreator();
        expression = expression.replace(" ", "").trim();
        String[] arrayExpressionParts = expression.split(Patterns.OPERATION, 2);
        String stringLeftPartExpression = arrayExpressionParts[0];
        Var varLeftPartExpression = varCreator.create(stringLeftPartExpression);

        if (arrayExpressionParts.length == 1) {
            return varLeftPartExpression;
        }

        String stringRightPartExpression = arrayExpressionParts[1];
        Var varRightPartExpression = varCreator.create(stringRightPartExpression);

        if (varLeftPartExpression != null && varRightPartExpression != null) {
            Pattern pattern = Pattern.compile(Patterns.OPERATION);
            Matcher matcher = pattern.matcher(expression);
            if (matcher.find()) {
                Processor processor = new Processor(varLeftPartExpression, varRightPartExpression);
                return processor.calc(matcher.group());
            }
        }
        System.err.println("Something stupid");
        return null;
    }
}
