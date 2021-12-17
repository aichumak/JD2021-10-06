package by.it.chumak.calc.service;

import by.it.chumak.calc.exception.CalcException;
import by.it.chumak.calc.model.ResourceManager;
import by.it.chumak.calc.model.Var;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class CalcProcessor {

    public CalcProcessor() {
    }

    public Var calc(String operation, Var varLeftPartExpression, Var varRightPartExpression, ResourceManager resourceManager,
                    LoggerMethods logger, SetReportBuilder reportBuilder, List<ReportBuilder> builders) throws CalcException {
        return switch (operation) {
            case "+" -> performCalculations("add", varLeftPartExpression, varRightPartExpression, resourceManager, logger, reportBuilder, builders);
            case "-" -> performCalculations("sub", varLeftPartExpression, varRightPartExpression, resourceManager, logger, reportBuilder, builders);
            case "*" -> performCalculations("mul", varLeftPartExpression, varRightPartExpression, resourceManager, logger, reportBuilder, builders);
            case "/" -> performCalculations("div", varLeftPartExpression, varRightPartExpression, resourceManager, logger, reportBuilder, builders);
            default -> null;
        };
    }

    @SuppressWarnings("deprecation")
    private Var performCalculations(String operation, Var varLeftPartExpression, Var varRightPartExpression, ResourceManager resourceManager,
                                    LoggerMethods logger, SetReportBuilder reportBuilder, List<ReportBuilder> builders) throws CalcException {
        String fullClassName = varLeftPartExpression.getClass().getPackageName() + "." + "MathExpressions";
        fullClassName = fullClassName.replace("model", "service");
        try {
            Class<?> desiredClass = Class.forName(fullClassName);
            Object instanceClass = desiredClass.newInstance();
            Class<?>[] arrayParametersResourceManager = new Class[]{ResourceManager.class};
            Class<?>[] arrayParametersLoggerMethods = new Class[]{LoggerMethods.class};
            Class<?>[] arrayParametersReportBuilder = new Class[]{SetReportBuilder.class};
            Class<?>[] arrayParametersBuildersList = new Class[]{List.class};
            Class<?>[] arrayParametersVar = new Class[]{Var.class};
            Method method = desiredClass.getDeclaredMethod(operation, arrayParametersResourceManager[0], arrayParametersLoggerMethods[0],
                    arrayParametersReportBuilder[0], arrayParametersBuildersList[0], arrayParametersVar[0], arrayParametersVar[0]);
            Object abc = method.invoke(instanceClass, resourceManager, logger, reportBuilder, builders, varLeftPartExpression, varRightPartExpression);
            return (Var) abc;
        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException exception) {
            throw new CalcException(logger, reportBuilder, builders, resourceManager, exception);
        }
    }

}
