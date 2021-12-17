package by.it.chumak.calc.service;

import by.it.chumak.calc.constant.Patterns;
import by.it.chumak.calc.model.Var;
import by.it.chumak.calc.model.Vector;
import by.it.chumak.calc.repository.VarRepository;

public class VectorCreator implements VarCreatorMethods {
    @Override
    public Var create(String stringVarValue, VarRepository varRepository) {
        if (stringVarValue.matches(Patterns.VECTOR)) {
            return new Vector(stringVarValue);
        } else {
            return new Vector(varRepository.find(stringVarValue));
        }
    }
}
