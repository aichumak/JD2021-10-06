package by.it.chumak.calc.model;

import by.it.chumak.calc.exception.CalcException;

public interface Operation {
    Var add(ResourceManager resourceManager, Var varLeftPartExpression, Var varRightPartExpression) throws CalcException;

    Var sub(ResourceManager resourceManager, Var varLeftPartExpression, Var varRightPartExpression) throws CalcException;

    Var mul(ResourceManager resourceManager, Var varLeftPartExpression, Var varRightPartExpression) throws CalcException;

    Var div(ResourceManager resourceManager, Var varLeftPartExpression, Var varRightPartExpression) throws CalcException;
}
