package by.it.kanaplianik.jd02_04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    public static final String OPERATION = "(?<=[^-+*/={,])[-+*/=]";
    public static final String SCALAR = "-?[0-9]+(\\.[0-9]+)?";
    public static final String VECTOR = "\\{" + SCALAR + "(," + SCALAR + ")*}";
    public static final String MATRIX = "\\{" + VECTOR + "(," + VECTOR + ")*}";
    private HashMap<String, Var> charVariables = new HashMap<>();

    public Calculator() {
    }

    public String calculate(String expression) {
        expression = expression
                .replace(" ", "")
                .trim();

        var operators = getOperators(expression);
        var variables = getVariables(expression);

        while (operators.size() > 0) {
            int index = new TopPriorityOperatorIndex(operators).getValue();
            Character operation = operators.remove(index);
            Var left = variables.remove(index);
            Var right = variables.remove(index);

            if (operation == '=') {
                charVariables.put(left.toString(), right);

                return right.toString();
            } else {
                Var var = new BinaryOperation(left, operation, right).getResult();
                variables.add(index, var);
            }
        }

        return variables.get(0).toString();
    }

    private ArrayList<Var> getVariables(String expression) {
        var result = new ArrayList<Var>();
        List<String> operations = new ArrayList<>(List.of(expression.split(OPERATION)));
        for(var operation : operations) {
            var variable = getVariable(operation);
            result.add(variable);
        }

        return result;
    }

    private ArrayList<Character> getOperators(String expression) {
        List<String> stringOperands = new ArrayList<>();
        Matcher matcher = Pattern.compile(OPERATION).matcher(expression);
        while (matcher.find()) {
            var operation = matcher.group();
            stringOperands.add(operation);
        }


        var result = new ArrayList<Character>();
        for (var stringOperand : stringOperands) {
            if(stringOperand.contains("+")){
                result.add('+');
            }
            else if (stringOperand.contains("-")){
                result.add('-');
            }
            else if (stringOperand.contains("*")){
                result.add('*');
            }
            else if(stringOperand.contains("/")){
                result.add('/');
            }
            else if (stringOperand.contains("=")) {
                result.add('=');
            }
        }

        return result;
    }

    private Var getVariable(String variable) {
        var isNotANumber = Pattern.compile("[a-zA-Z]").matcher(variable).find();

        if (isNotANumber) {
            return new Variable(variable, charVariables);
        }

        if (variable.contains("{{")) {
            return new Matrix(variable);
        }
        else if (variable.contains("{")) {
            return new Vector(variable);
        }
        else {
            return new Scalar(variable);
        }
    }
}

