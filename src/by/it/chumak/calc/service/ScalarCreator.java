package by.it.chumak.calc.service;

import by.it.chumak.calc.model.Scalar;
import by.it.chumak.calc.model.Var;

public class ScalarCreator implements VarCreatorMethods {

    @Override
    public Var create(String stringVarValue) {
        return new Scalar(stringVarValue);
    }
}
