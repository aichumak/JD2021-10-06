package by.it.drankevich.calc.model;

import by.it.drankevich.calc.exeption.CalcExeption;

interface Operation {
    Var add(Var other) throws CalcExeption;
    Var sub(Var other) throws CalcExeption;
    Var mul(Var other) throws CalcExeption;
    Var div(Var other) throws CalcExeption;
}