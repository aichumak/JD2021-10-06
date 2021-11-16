package by.it._classwork_.calc;

public class VarCreator {

    private final VarRepository varRepository;

    public VarCreator(VarRepository varRepository) {
        this.varRepository = varRepository;
    }

    Var create(String stringVarValue) {
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
