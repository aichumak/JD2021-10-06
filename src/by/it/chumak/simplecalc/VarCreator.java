package by.it.chumak.simplecalc;

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
