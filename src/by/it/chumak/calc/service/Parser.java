package by.it.chumak.calc.service;

import by.it.chumak.calc.constant.Patterns;
import by.it.chumak.calc.exception.CalcException;
import by.it.chumak.calc.model.Var;
import by.it.chumak.calc.repository.VarRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private final Map<String, Integer> map = Map.of(
            "=", 0,
            "+", 1,
            "-", 1,
            "*", 2,
            "/", 2,
            "(", 3
    );

    private VarRepository varRepository;
    private VarCreator varCreator;

    public Parser() {
    }

    public Var evaluate(String expression, VarRepository varRepository) throws CalcException {
        this.varRepository = varRepository;
        this.varCreator = new VarCreator(varRepository);

        expression = expression.replace(" ", "").trim();
        //processOperands(expression);

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
            operands.add(index, var.toString());
        }

        return varCreator.create(operands.get(0).replaceAll(" ", ""));
    }

    private void processOperands(String expression) throws CalcException {


    }

    private Var oneOperation(String stingLeftVar, String operation, String stingRightVar) throws CalcException {
        CalcProcessor calcProcessor = new CalcProcessor();
        Var right = varCreator.create(stingRightVar);
        if (operation.equals("=")) {
            varRepository.save(stingLeftVar, right);
            return right;
        }

        Var left = varCreator.create(stingLeftVar);
        return calcProcessor.calc(operation, left, right);
    }

    private int getIndex(List<String> operation) {
        int index = -1;
        int pr = -1;
        for (int i = 0; i < operation.size(); i++) {
            String currentOperation = operation.get(i);
            Integer currentPriority = map.get(currentOperation);
            if (pr < currentPriority) {
                index = i;
                pr = currentPriority;
            }
        }
        return index;
    }
}
