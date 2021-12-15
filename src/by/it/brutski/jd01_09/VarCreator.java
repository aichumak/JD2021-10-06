package by.it.brutski.jd01_09;

public class VarCreator {

    public static Var create(String stringVarValue) {
        if (stringVarValue.matches(Patterns.SCALAR)) {
            return new Scalar(stringVarValue);
        } else {
            System.err.println("Incorrect variable " + stringVarValue);
            return null;
        }
    }
}