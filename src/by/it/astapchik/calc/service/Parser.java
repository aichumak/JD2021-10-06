package by.it.astapchik.calc.service;

import by.it.astapchik.calc.constant.Patterns;
import by.it.astapchik.calc.exception.CalcException;
import by.it.astapchik.calc.model.Var;
import by.it.astapchik.calc.repository.VarRepository;

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
    private final VarCreator varCreator;
    private String BRACKETSPATTERN = "(\\(([}{,0-9a-zA-Z-+*/.]+)\\))";

    public Parser(VarRepository varRepository, VarCreator varCreator) {
        this.varRepository = varRepository;
        this.varCreator = varCreator;
    }

    public Var evaluate(String expression) throws CalcException {
        //2+2 {1,3}*5
        //C=B+(A*2)
        //D=((C-0.15)-20)/(7-5)
        //E={2,3}*(D/2)
        expression = expression
                .replace(" ", "")
                .trim();

        while (expression.contains("(")){
            expression=getExpressionWithBracket(expression);
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
        return varCreator.create(operands.get(0));
    }

    private String getExpressionWithBracket(String expression) throws CalcException {
        Pattern pattern = Pattern.compile(BRACKETSPATTERN);
        Matcher matcher = pattern.matcher(expression);
        if(matcher.find()){
            String receivedParts = matcher.group();
            String one = receivedParts.replace("(","").replace(")","");
            String evaluatedParts = evaluate(one).toString();
            expression = expression.replace(receivedParts, evaluatedParts);
        }
        return expression;
    }
    private Var oneOperation(String stingLeftVar, String operation, String stingRightVar) throws CalcException {
        Var right = varCreator.create(stingRightVar);
        if (operation.equals("=")) {
            varRepository.save(stingLeftVar, right);
            return right;
        }
        Var left = varCreator.create(stingLeftVar);
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
        throw new CalcException("Something stupid");
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

}
