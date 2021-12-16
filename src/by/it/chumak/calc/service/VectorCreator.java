package by.it.chumak.calc.service;

import by.it.chumak.calc.model.Var;
import by.it.chumak.calc.model.Vector;

public class VectorCreator implements VarCreatorMethods{
    @Override
    public Var create(String stringVarValue) {
        return new Vector(stringVarValue);
    }
}
