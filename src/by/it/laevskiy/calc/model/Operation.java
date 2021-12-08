package by.it.laevskiy.calc.model;

import by.it.laevskiy.calc.exception.CalcException;

interface Operation {
    Var add(Var other) throws CalcException;
    Var sub(Var other) throws CalcException;
    Var mul(Var other) throws CalcException;
    Var div(Var other) throws CalcException;
}