package by.it.serkutsyev.calc;

public class VarCreator {

    private final VarRepository varRepository;

    public VarCreator(VarRepository varRepository) {
        this.varRepository = varRepository;
    }

    public Var create(String partOfExpression) {
        if (partOfExpression.matches(Patterns.SCALAR)) {
            Scalar scalar = new Scalar(partOfExpression);
            return scalar;
        } else if (partOfExpression.matches(Patterns.VECTOR)) {
            Vector vector = new Vector(partOfExpression);
            return vector;
        } else if (partOfExpression.matches(Patterns.MATRIX)) {
            Matrix matrix = new Matrix(partOfExpression);
            return matrix;
        } else {
            return varRepository.find(partOfExpression);
        }
    }
}
