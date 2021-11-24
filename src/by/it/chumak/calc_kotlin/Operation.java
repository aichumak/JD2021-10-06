package by.it.chumak.calc_kotlin;

interface Operation {
    Var add(Var varLeftPartExpression, Var varRightPartExpression) throws CalcException;

    Var sub(Var varLeftPartExpression, Var varRightPartExpression) throws CalcException;

    Var mul(Var varLeftPartExpression, Var varRightPartExpression) throws CalcException;

    Var div(Var varLeftPartExpression, Var varRightPartExpression) throws CalcException;
}
