package by.it.chumak.simplecalc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    public Var evaluate(String expression, VarRepository varRepository) {
        VarCreator varCreator = new VarCreator(varRepository);
        CalcProcessor calcProcessor = new CalcProcessor();
        expression = expression.replace(" ", "").trim();
        String[] arrayExpressionParts = expression.split(Patterns.OPERATION, 2);

        if (arrayExpressionParts.length == 1) {
            return varCreator.create(arrayExpressionParts[0]);
        }

        Var varRightPartExpression = varCreator.create(arrayExpressionParts[1]);

        if(expression.contains("=")){
            varRepository.save(arrayExpressionParts[0], varRightPartExpression);
            return varRightPartExpression;
        }

        Var varLeftPartExpression = varCreator.create(arrayExpressionParts[0]);

        if (varLeftPartExpression != null && varRightPartExpression != null) {
            Pattern pattern = Pattern.compile(Patterns.OPERATION);
            Matcher matcher = pattern.matcher(expression);
            if (matcher.find()) {
                return calcProcessor.calc(matcher.group(), varLeftPartExpression, varRightPartExpression);
            }
        }

        System.err.println("Incorrect expression");
        return null;
    }
}
