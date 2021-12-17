package by.it.chumak.calc.service;

import by.it.chumak.calc.constant.Patterns;
import by.it.chumak.calc.model.Scalar;
import by.it.chumak.calc.model.Var;
import by.it.chumak.calc.repository.VarRepository;

public class ScalarCreator implements VarCreatorMethods {
    @Override
    public Var create(String stringVarValue, VarRepository varRepository) {
        if (stringVarValue.matches(Patterns.SCALAR)) {
            return new Scalar(stringVarValue);
        } else {
            return new Scalar(varRepository.find(stringVarValue));
        }
    }
}
