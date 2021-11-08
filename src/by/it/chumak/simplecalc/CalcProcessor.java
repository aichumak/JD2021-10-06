package by.it.chumak.simplecalc;

import java.lang.reflect.Field;
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
            case "+" -> add (varLeftPartExpression, varRightPartExpression);
            //case "-" -> varLeftPartExpression.sub(varRightPartExpression);
            //case "*" -> varLeftPartExpression.mul(varRightPartExpression);
            //case "/" -> varLeftPartExpression.div(varRightPartExpression);
            default -> null;
        };
    }

    private Var add(Var varLeftPartExpression, Var varRightPartExpression) {
        String className = varLeftPartExpression.getClass().getSimpleName()+"Methods";
        try {
            Class<?> desiredСlass = Class.forName("by.it.chumak.simplecalc."+className);
            Object instanceClass = desiredСlass.newInstance();
            Class[] arrayparam = new Class[2];
            arrayparam[0] = Var.class;
            Method method = desiredСlass.getDeclaredMethod("add", arrayparam[0], arrayparam[0]);
            Object abc = method.invoke(instanceClass,  varLeftPartExpression, varRightPartExpression);
            return new Scalar((Double) abc);
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
