package by.it.brutski.calc.model;

import by.it.brutski.calc.exception.CalcException;
import by.it.brutski.calc.model.Var;

interface Operation {
    Var add(Var other) throws CalcException;

    Var sub(Var other) throws CalcException;

    Var mul(Var other) throws CalcException;

    Var div(Var other) throws CalcException;
}