package by.it.ithoitan.jd01_09;

public interface Patterns {
    String SCALAR = "-?[0-9]+(\\.[0-9]+)";
    String VECTOR = "\\{"+ SCALAR + "(,"+ SCALAR + "\\}";
            String OPERATION = "-+*/";
}
