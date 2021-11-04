package by.it.chumak.jd01_09;

public class VarCreator {
    public Var create(String stringVarValue) {
        if (stringVarValue.matches(Patterns.SCALAR)) {
            return new Scalar(stringVarValue);
        } else if (stringVarValue.matches(Patterns.VECTOR)) {
            return new Vector(stringVarValue);
        } else if (stringVarValue.matches(Patterns.MATRIX)) {
            return new Matrix(stringVarValue);
        } else {
            //TODO replace with exception
            System.err.println("Incorrect variable " + stringVarValue);
            return null;
        }
    }
}
