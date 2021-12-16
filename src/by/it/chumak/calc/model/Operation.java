package by.it.chumak.calc.model;

import by.it.chumak.calc.exception.CalcException;
import by.it.chumak.calc.service.LoggerMethods;

public interface Operation {
    Var add(ResourceManager resourceManager, LoggerMethods logger, Var varLeftPartExpression, Var varRightPartExpression) throws CalcException;

    Var sub(ResourceManager resourceManager, LoggerMethods logger, Var varLeftPartExpression, Var varRightPartExpression) throws CalcException;

    Var mul(ResourceManager resourceManager, LoggerMethods logger, Var varLeftPartExpression, Var varRightPartExpression) throws CalcException;

    Var div(ResourceManager resourceManager, LoggerMethods logger, Var varLeftPartExpression, Var varRightPartExpression) throws CalcException;
}
