package by.it.kanaplianik.jd02_04;

public class MathExpression {
    private final char operand;
    private final Var left;
    private final Var right;

    public MathExpression(Var left, Character operator, Var right) {
        this.left = left;
        this.operand = operator;
        this.right = right;
    }

    public MathExpression (String value) {
       // 4-3 4+5 5*5 8/2
        if(value.contains("+")){
            operand = '+';
        }
        else if (value.contains("-")){
            operand = '-';
        }
        else if (value.contains("*")){
            operand = '*';
        }
        else if(value.contains("/")){
            operand = '/';
        }
        else {
            operand = '+';
        }

        String[] stringSplitted;
        stringSplitted = value.split("[-|*+/]");
        String leftPart = stringSplitted [0];
        String rightPart = stringSplitted [1];
        if (leftPart.contains("{{")) {
             left = new Matrix(leftPart);
        }
        else if (leftPart.contains("{")) {
            left = new Vector(leftPart);
        }
        else {
            left = new Scalar(leftPart);
        }

        // {{1, 2
        if (rightPart.contains("{{")) {
            right = new Matrix(rightPart);
        }
        else if (rightPart.contains("{")) {
            right = new Vector(rightPart);
        }
        else {
            right = new Scalar(rightPart);
        }
    }

    public Var getLeft() {
        return left;
    }
    public Var getRight() {
        return right;
    }
    public char getOperand() {
        return operand;
    }
}
