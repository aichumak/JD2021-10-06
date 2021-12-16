package by.it.chumak.calc.service;

import by.it.chumak.calc.model.Matrix;
import by.it.chumak.calc.model.Var;

public class MatrixCreator implements VarCreatorMethods{
    @Override
    public Var create(String stringVarValue) {
        return new Matrix(stringVarValue);
    }
}
