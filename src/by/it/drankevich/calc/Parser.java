package by.it.drankevich.calc;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private Map<String,Integer> map=Map.of(
            "=",0,
            "+",1,
            "-",1,
            "*",2,
            "/",2
    );
    private final VarRepository varRepository;
    private final Varcreator varcreator;

    public Parser(VarRepository varRepository, Varcreator varcreator) {
        this.varRepository = varRepository; this.varcreator = varcreator;
    }

    public Var evaluate(String expression) throws CalcExeption {

        expression = expression
                .replace(" ", "")
                .trim();
       while (expression.contains("(")) {
           expression= bracket(expression);
        }

        List<String> operands = new ArrayList<>(List.of(expression.split(Patterns.OPERATION)));
        List<String> operations = new ArrayList<>();
        Matcher matcher = Pattern.compile(Patterns.OPERATION).matcher(expression);
        while (matcher.find()) {
            operations.add(matcher.group());
        }
        while (operations.size() > 0) {
            int index = getIndex(operations);
            String operation = operations.remove(index);
            String left = operands.remove(index);
            String right = operands.remove(index);
            Var var = oneOperation(left, operation, right);
            operands.add(index,var.toString());
        }
        return varcreator.create(operands.get(0));
    }




    private Var oneOperation(String stingLeftVar, String operation, String stingRightVar) throws CalcExeption {

        Var right = varcreator.create(stingRightVar);
        if (operation.equals("=")) {
            varRepository.save(stingLeftVar, right);
            return right;
        }

        Var left = varcreator.create(stingLeftVar);
        switch (operation) {
            case "+":
                return left.add(right);
            case "-":
                return left.sub(right);
            case "*":
                return left.mul(right);
            case "/":
                return left.div(right);
        }
        throw new CalcExeption(ResourceManager.get("massage.Stupid"));
    }


    private int getIndex(List<String> operation) {
        int index=-1;
        int pr=-1;
        for (int i = 0; i < operation.size(); i++) {
            String currentOperation = operation.get(i);
            Integer currentPriority = map.get(currentOperation);
            if (pr<currentPriority){
                index=i;
                pr=currentPriority;
            }
        }
        return index;
    }



    private String bracket(String expression) throws CalcExeption {
        Pattern pattern = Pattern.compile("(\\(([}{,0-9a-zA-Z-+*/.]+)\\))");
        Matcher matcher = pattern.matcher(expression);
        if(matcher.find()){
            String expressionPart=matcher.group();
           String expressionPart1=expressionPart.replace("(","").replace(")","");
            String newExpressionPart=evaluate(expressionPart1).toString();
            expression=expression.replace(expressionPart,newExpressionPart);

        }
        return expression;

    }
}
