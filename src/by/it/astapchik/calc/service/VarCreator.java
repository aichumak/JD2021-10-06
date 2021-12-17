package by.it.astapchik.calc.service;

import by.it.astapchik.calc.constant.Patterns;
import by.it.astapchik.calc.exception.CalcException;
import by.it.astapchik.calc.model.Matrix;
import by.it.astapchik.calc.model.Scalar;
import by.it.astapchik.calc.model.Var;
import by.it.astapchik.calc.model.Vector;
import by.it.astapchik.calc.repository.VarRepository;

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
