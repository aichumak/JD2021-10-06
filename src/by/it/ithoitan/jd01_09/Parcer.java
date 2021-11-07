package by.it.ithoitan.jd01_09;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parcer {
    public Var evaluate(String expression) {
        expression = expression.replace(" ", "").trim();
        String[] parts = expression.split(Patterns.OPERATION, 2);
        String stringLeftVar = parts[0];
        Var leftVar = VarCreator.create(stringLeftVar);
        if (parts.length == 1) {
            return leftVar;
        }
        String stringRightVar = parts[1];
        Var rightVar = VarCreator.create(stringRightVar);
        if (!Objects.isNull(leftVar) && !Objects.isNull(rightVar)) {
            Pattern pattern = Pattern.compile(Patterns.OPERATION);
            Matcher matcher = pattern.matcher(expression);
            if (matcher.find()) {
                String operation = matcher.group();
                switch (operation) {
                    case "+":
                        return leftVar.add(rightVar);
                    case "-":
                        return leftVar.sub(rightVar);
                    case "*":
                        return leftVar.mul(rightVar);
                    case "/":
                        return leftVar.div(rightVar);
                }
            }
        }
        System.err.println("Something stupid");
        return null;
    }
}
