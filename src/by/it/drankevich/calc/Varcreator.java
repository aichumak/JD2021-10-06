package by.it.drankevich.calc;

import by.it._classwork_.calc.CalcException;

public class Varcreator {
    private final VarRepository varRepository;

    public Varcreator(VarRepository varRepository) {
        this.varRepository = varRepository;
    }


    Var create(String stringVarValue) throws CalcExeption {

        if (stringVarValue.matches(Patterns.SCALAR)) {
            return new Scalar(stringVarValue);
        }
        if (stringVarValue.matches(Patterns.VECTOR)) {
            return new Vector(stringVarValue);

        }
        if (stringVarValue.matches(Patterns.MATRIX)) {
            return new Matrix(stringVarValue);
        } else {


            return varRepository.find(stringVarValue);
        }
    }
}
