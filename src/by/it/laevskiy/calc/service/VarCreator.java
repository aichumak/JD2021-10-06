package by.it.laevskiy.calc.service;

import by.it.laevskiy.calc.constant.Patterns;
import by.it.laevskiy.calc.exception.CalcException;
import by.it.laevskiy.calc.model.Matrix;
import by.it.laevskiy.calc.model.Scalar;
import by.it.laevskiy.calc.model.Var;
import by.it.laevskiy.calc.model.Vector;
import by.it.laevskiy.calc.repository.VarRepository;

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
        } else if (stringVarValue.matches(Patterns.MATRIX)) {
            return new Matrix(stringVarValue);
        } else {
            return varRepository.find(stringVarValue);
        }
    }
}
