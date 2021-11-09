package by.it.chumak.simplecalc;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CalcProcessor {

    public CalcProcessor() {
    }

    public Var calc(String operation, Var varLeftPartExpression, Var varRightPartExpression) {
        return switch (operation) {
            case "+" -> performCalculations("add", varLeftPartExpression, varRightPartExpression);
            case "-" -> performCalculations("sub", varLeftPartExpression, varRightPartExpression);
            case "*" -> performCalculations("mul", varLeftPartExpression, varRightPartExpression);
            case "/" -> performCalculations("div", varLeftPartExpression, varRightPartExpression);
            default -> null;
        };
    }

    private Var performCalculations(String operation, Var varLeftPartExpression, Var varRightPartExpression) {
        String fullClassName = varLeftPartExpression.getClass().getPackageName() + "." + "MathExpressions";
        try {
            Class<?> desiredClass = Class.forName(fullClassName);
            Object instanceClass = desiredClass.newInstance();
            Class[] arrayParameters = new Class[]{Var.class};
            Method method = desiredClass.getDeclaredMethod(operation, arrayParameters[0], arrayParameters[0]);
            Object abc = method.invoke(instanceClass, varLeftPartExpression, varRightPartExpression);
            return (Var) abc;
        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
