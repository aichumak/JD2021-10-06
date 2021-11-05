package by.it.chumak.jd01_09;

public class Processor {

    public final Var varLeftPartExpression, varRightPartExpression;

    public Processor(Var leftPartExpression, Var rightPartExpression) {
        this.varLeftPartExpression = leftPartExpression;
        this.varRightPartExpression = rightPartExpression;
    }

    public Var calc(String operation) {
        switch (operation) {
            case "+":
                return varLeftPartExpression.add(varRightPartExpression);
            case "-":
                return varLeftPartExpression.sub(varRightPartExpression);
            case "*":
                return varLeftPartExpression.mul(varRightPartExpression);
            case "/":
                return varLeftPartExpression.div(varRightPartExpression);
        }
        return null;
    }
}
