package by.it.astapchik.jd01_09;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {

    public Var evaluate(String expression) {

        expression = expression.replace(" ", "").trim();

        String[] partsOfOperations = expression.split(Patterns.OPERATIONS, 2);

        String stringLeftVar = partsOfOperations[0];

        Var leftVarValue = VarCreator.create(stringLeftVar);
        if (partsOfOperations.length == 1){
            return leftVarValue;
        }
        String stringRightVar = partsOfOperations[1];

        Var rightVarValue = VarCreator.create(stringRightVar);
        if (!Objects.isNull(leftVarValue) && !Objects.isNull(rightVarValue)){
            Pattern pattern = Pattern.compile(Patterns.OPERATIONS);
            Matcher matcher = pattern.matcher(expression);
            if (matcher.find()){
                String operation = matcher.group();
                switch (operation){
                    case "+":
                        return leftVarValue.add(rightVarValue);
                    case "-":
                        return leftVarValue.sub(rightVarValue);
                    case "/":
                        return leftVarValue.div(rightVarValue);
                    case "*":
                        return leftVarValue.mul(rightVarValue);
                }
            }
        }
        return null;
    }
}
