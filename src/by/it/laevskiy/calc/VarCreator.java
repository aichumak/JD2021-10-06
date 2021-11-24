package by.it.laevskiy.calc;

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
