package by.it.chumak.simplecalc;

interface Operation {
    Var add(Var varLeftPartExpression, Var varRightPartExpression);

    Var sub(Var varLeftPartExpression, Var varRightPartExpression);

    Var mul(Var varLeftPartExpression, Var varRightPartExpression);

    Var div(Var varLeftPartExpression, Var varRightPartExpression);
}
