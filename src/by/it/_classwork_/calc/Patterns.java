package by.it._classwork_.calc;

public interface Patterns {

    String OPERATION = "[-+*/=]";

    // -2     -2.2    345    2.222
    String SCALAR = "-?[0-9]+(\\.[0-9]+)?";

    //{1,2,3}   {1.0,4,-9} {10.0}
    String VECTOR = "\\{" + SCALAR + "(," + SCALAR + ")*}";
    String MATRIX = "\\{" + VECTOR + "(," + VECTOR + ")*}";
}
