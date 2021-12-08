package by.it.chumak.calc.service;

import by.it.chumak.calc.constant.Patterns;
import by.it.chumak.calc.model.Matrix;
import by.it.chumak.calc.model.Scalar;
import by.it.chumak.calc.model.Var;
import by.it.chumak.calc.model.Vector;
import by.it.chumak.calc.repository.VarRepository;

public class VarCreator {

    private final VarRepository varRepository;

    public VarCreator(VarRepository varRepository) {
        this.varRepository = varRepository;
    }

    public Var create(String stringVarValue) {

        try {
            if (stringVarValue.matches(Patterns.SCALAR)) {
                return new Scalar(stringVarValue);
            } else if (stringVarValue.matches(Patterns.VECTOR)) {
                return new Vector(stringVarValue);
            } else if (stringVarValue.matches(Patterns.MATRIX)) {
                return new Matrix(stringVarValue);
            } else {
                return varRepository.find(stringVarValue);
            }
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }
        return null;
    }
}
