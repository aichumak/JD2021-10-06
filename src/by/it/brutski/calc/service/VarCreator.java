package by.it.brutski.calc.service;

import by.it.brutski.calc.constant.Patterns;
import by.it.brutski.calc.exception.CalcException;
import by.it.brutski.calc.model.Scalar;
import by.it.brutski.calc.model.Var;
import by.it.brutski.calc.model.Vector;
import by.it.brutski.calc.repository.VarRepository;

public class VarCreator {

    private final VarRepository varRepository;

    public VarCreator(VarRepository varRepository) {
        this.varRepository = varRepository;
    }

    Var create(String stringVarValue) throws CalcException {
        if (stringVarValue.matches(Patterns.SCALAR)) {
            return new Scalar(stringVarValue);
        } else if (stringVarValue.matches(Patterns.VECTOR)) {
            return new Vector(stringVarValue);
        } else {
            //TODO replace with exception
            return varRepository.find(stringVarValue);
        }
    }
}
