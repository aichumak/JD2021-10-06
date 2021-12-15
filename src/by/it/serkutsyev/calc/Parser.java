package by.it.serkutsyev.calc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private Map<String, Integer> map = Map.of(
            "=", 0,
            "+", 1,
            "-", 2,
            "*", 3,
            "/", 4
            );


    private VarRepository varRepository;

    private VarCreator varCreator;

    public Parser(VarRepository varRepository) {
        this.varRepository = varRepository;
    }

    public Parser(VarRepository varRepository, VarCreator varCreator) {
        this.varRepository = varRepository;
        this.varCreator = varCreator;
    }

    public Var calc(String expression) {
        // 2+2*2-2/2
        expression = expression.replace(" ", "").trim();
        List<String> operands = new ArrayList<>(List.of(expression.split(Patterns.SEPARATOR)));
        ArrayList<String> operations = new ArrayList<>();
        Matcher matcher = Pattern.compile(by.it._classwork_.calc.constant.Patterns.OPERATION).matcher(expression);
        while (matcher.find()) {
            operations.add(matcher.group());
        }

        while (operations.size() > 0) {
            int index = getIndex(operations);
            String operation = operations.remove(index);
            String left = operands.remove(index);
            String right = operands.remove(index);
            Var var = oneOperation(left, operation, right);
            operands.add(index, var.toString());
        }
        return varCreator.create(operands.get(0));
    }

    private Var oneOperation(String stringLeftPart, String operation, String stringRightPart) {

        Var varRightPart = varCreator.create(stringRightPart);
        if (operation.equals("=")) {
            varRepository.save(stringLeftPart, varRightPart);
            return varRightPart;
        }
        Var varLeftPart = varCreator.create(stringLeftPart);
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
        throw new RuntimeException("Something stupid");


    }

    private int getIndex(ArrayList<String> operations) {
        int index=-1;
        int priority=-1;
        for (int i = 0; i < operations.size(); i++) {
            String currentOperation= operations.get(i);
            Integer currentPriority = map.get(currentOperation);
            if (priority<currentPriority){
                index=i;
                priority=currentPriority;
            }
        }
        return index;
    }
}
