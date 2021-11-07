package by.it.vrublevskii.jd01_09;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser implements Patterns {


    Var evaluate(String expression) {
//        2+2 {1,2}+5 1.223+5.654
        expression = expression
                .replaceAll(" ", "")
                .trim();
        String[] parts = expression.split(Patterns.OPERATION, 2);
        String stringLeftVar = parts[0];
        Var leftVar = VarCreator.create(stringLeftVar);
        if (parts.length == 1) {
            return leftVar;
        }
        String stringRightVar = parts[1];
        Var rightVar = VarCreator.create(stringRightVar);
        if (!Objects.isNull(rightVar) && !Objects.isNull(leftVar)) {
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

        return null;
    }
}
