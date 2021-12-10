package by.it.chumak.calc.constant;

public interface Patterns {
    // {4.0,6.0,8.0}
    // {{1,2},{8,3}}*{{1,2},{8,3}}
    // {{1.0,2.4},{8,3}}*{{1,2},{8,3}}
    // {{17.0,8.0},{32.0,25.0}}
    // {{17.0,8.0},{32.0,25.0}}
    // (5+5)+5
    String MATH_EXPRESSION_IN_PARENTHESES = "(?<=\\().*?(?=\\))";
    String OPERATION = "(?<=[^-+*/={,])[-+*/=]";
    String SCALAR = "-?[0-9]+(\\.[0-9]+)?";
    String VECTOR = "\\{" + SCALAR + "(," + SCALAR + ")*}";
    String MATRIX = "\\{" + VECTOR + "(," + VECTOR + ")*}";
}
