package by.it.kanaplianik.jd01_09;

public class BinaryOperation {
    private  final MathExpression mathExpression;

    public Var getResult() {
        switch (mathExpression.getOperand()) {
            case ('+'):
                return mathExpression.getLeft().add(mathExpression.getRight());
            case ('-'):
                return mathExpression.getLeft().sub(mathExpression.getRight());
            case ('*'):
                return mathExpression.getLeft().mul(mathExpression.getRight());
            case ('/'):
                return mathExpression.getLeft().div(mathExpression.getRight());
        }
        return null;
    }

    public BinaryOperation(MathExpression expression) {
        mathExpression = expression;
    }
}
