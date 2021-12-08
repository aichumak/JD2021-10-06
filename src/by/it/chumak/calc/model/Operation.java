package by.it.chumak.calc.model;

import by.it.chumak.calc.exception.CalcException;

public interface Operation {
    Var add(Var varLeftPartExpression, Var varRightPartExpression) throws CalcException;

    Var sub(Var varLeftPartExpression, Var varRightPartExpression) throws CalcException;

    Var mul(Var varLeftPartExpression, Var varRightPartExpression) throws CalcException;

    Var div(Var varLeftPartExpression, Var varRightPartExpression) throws CalcException;
}
