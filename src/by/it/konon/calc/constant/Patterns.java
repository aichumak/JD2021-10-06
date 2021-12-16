package by.it.konon.calc.constant;

public class Patterns {

    private Patterns() {
    }
        // A=-2+-4+{-3,-6}
    public static final String OPERATION = "(?<=[^-+*/={,])[-+*/=]";
    public static final String SCALAR = "-?[0-9]+(\\.[0-9]+)?";
    public static final String VECTOR = "\\{" + SCALAR + "(," + SCALAR + ")*}";
    public static final String MATRIX = "\\{" + VECTOR + "(," + VECTOR + ")*}";
}
