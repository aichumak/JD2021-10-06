package by.it._classwork_.calc.service;

import by.it._classwork_.calc.exception.CalcException;
import by.it._classwork_.calc.constant.Patterns;
import by.it._classwork_.calc.model.Matrix;
import by.it._classwork_.calc.model.Scalar;
import by.it._classwork_.calc.model.Var;
import by.it._classwork_.calc.model.Vector;
import by.it._classwork_.calc.repository.VarRepository;

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
            //TODO replace with exception
            return varRepository.find(stringVarValue);
        }
    }
}
