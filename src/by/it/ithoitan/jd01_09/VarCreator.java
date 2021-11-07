package by.it.ithoitan.jd01_09;

public class VarCreator {
    static Var create(String stringVarValue) {
        if (stringVarValue.matches(Patterns.SCALAR)) {
            return new Scalar(stringVarValue);
        } else if (stringVarValue.matches(Patterns.VECTOR)) {
            return new Vector(stringVarValue);
        } else if (stringVarValue.matches(Patterns.MATRIX)) {
            return new Matrix(stringVarValue);
        } else {
            System.err.println("Incorrect variable" + stringVarValue);
            return null;
        }
    }
}
