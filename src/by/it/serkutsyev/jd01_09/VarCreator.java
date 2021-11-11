package by.it.serkutsyev.jd01_09;

public class VarCreator {

    static Var create(String partOfExpression) {
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
            return null;
        }
    }
}
