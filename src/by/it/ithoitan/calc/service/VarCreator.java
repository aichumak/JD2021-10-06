package by.it.ithoitan.calc.service;

import by.it.ithoitan.calc.constant.Patterns;
import by.it.ithoitan.calc.ecxeption.CalcException;
import by.it.ithoitan.calc.model.Matrix;
import by.it.ithoitan.calc.model.Scalar;
import by.it.ithoitan.calc.model.Var;
import by.it.ithoitan.calc.model.Vector;
import by.it.ithoitan.calc.repository.VarRepository;

public class VarCreator {
    private final VarRepository varRepository;

    public VarCreator(VarRepository varRepository) {
        this.varRepository = varRepository;
    }

    public Var create(String stringVarValue) throws CalcException {
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
