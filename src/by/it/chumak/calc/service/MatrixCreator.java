package by.it.chumak.calc.service;

import by.it.chumak.calc.constant.Patterns;
import by.it.chumak.calc.model.Matrix;
import by.it.chumak.calc.model.Var;
import by.it.chumak.calc.repository.VarRepository;

public class MatrixCreator implements VarCreatorMethods {
    @Override
    public Var create(String stringVarValue, VarRepository varRepository) {
        if (stringVarValue.matches(Patterns.MATRIX)) {
            return new Matrix(stringVarValue);
        } else {
            return new Matrix(varRepository.find(stringVarValue));
        }
    }
}
