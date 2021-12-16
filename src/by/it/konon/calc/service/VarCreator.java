package by.it.konon.calc.service;

import by.it.konon.calc.constant.Patterns;
import by.it.konon.calc.exception.CalcException;
import by.it.konon.calc.model.Matrix;
import by.it.konon.calc.model.Scalar;
import by.it.konon.calc.model.Var;
import by.it.konon.calc.model.Vector;
import by.it.konon.calc.repository.VarRepository;

public class VarCreator {

    private final VarRepository varRepository;

    public VarCreator(VarRepository varRepository) {
        this.varRepository = varRepository;
    }

    Var create(String stringVarValue) throws CalcException {
        if (stringVarValue.matches(Patterns.SCALAR)) {
            return new Scalar(stringVarValue);
        }  if (stringVarValue.matches(Patterns.VECTOR)) {
            return new Vector(stringVarValue);
        }  if (stringVarValue.matches(Patterns.MATRIX)) {
            return new Matrix(stringVarValue);
        } else {

            return varRepository.find(stringVarValue);
        }
    }
}
