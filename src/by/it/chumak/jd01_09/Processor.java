package by.it.chumak.jd01_09;

public class Processor {

    public Var varLeftPartExpression, varRightPartExpression;

    public Processor() {
    }

    public void setVarLeftPartExpression(Var varLeftPartExpression) {
        this.varLeftPartExpression = varLeftPartExpression;
    }

    public void setVarRightPartExpression(Var varRightPartExpression) {
        this.varRightPartExpression = varRightPartExpression;
    }

    public Var calc(String operation) {
        return switch (operation) {
            case "+" -> varLeftPartExpression.add(varRightPartExpression);
            case "-" -> varLeftPartExpression.sub(varRightPartExpression);
            case "*" -> varLeftPartExpression.mul(varRightPartExpression);
            case "/" -> varLeftPartExpression.div(varRightPartExpression);
            default -> null;
        };
    }
}
