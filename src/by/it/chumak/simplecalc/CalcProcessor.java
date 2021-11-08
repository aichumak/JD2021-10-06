package by.it.chumak.simplecalc;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CalcProcessor {

    public Var varLeftPartExpression, varRightPartExpression;

    public CalcProcessor() {
    }

    public void setVarLeftPartExpression(Var varLeftPartExpression) {
        this.varLeftPartExpression = varLeftPartExpression;
    }

    public void setVarRightPartExpression(Var varRightPartExpression) {
        this.varRightPartExpression = varRightPartExpression;
    }

    public Var calc(String operation) {
        return switch (operation) {
            //case "+" -> varLeftPartExpression.add(varRightPartExpression);
            case "+" -> add(varLeftPartExpression, varRightPartExpression);
            //case "-" -> varLeftPartExpression.sub(varRightPartExpression);
            //case "*" -> varLeftPartExpression.mul(varRightPartExpression);
            //case "/" -> varLeftPartExpression.div(varRightPartExpression);
            default -> null;
        };
    }

    private Var add(Var varLeftPartExpression, Var varRightPartExpression) {
        String fullClassName = varRightPartExpression.getClass().getPackageName() + "."
                + varRightPartExpression.getClass().getSimpleName() + "Methods";
        try {
            Class<?> desiredClass = Class.forName(fullClassName);
            Object instanceClass = desiredClass.newInstance();
            Class[] arrayParameters = new Class[]{Var.class};
            Method method = desiredClass.getDeclaredMethod("add", arrayParameters[0], arrayParameters[0]);
            Object abc = method.invoke(instanceClass, varLeftPartExpression, varRightPartExpression);
            return (Var) abc;
        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
