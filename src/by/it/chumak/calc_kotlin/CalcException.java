package by.it.chumak.calc_kotlin;

public class CalcException extends Exception{
    public CalcException() {
        this("no message");
    }

    public CalcException(String message) {
        super("ERROR: " + message);
    }

    public CalcException(String message, Throwable cause) {
        super("ERROR: " + message, cause);
    }

    public CalcException(Throwable cause) {
        super("ERROR: " + cause);
    }

    public CalcException(String format, Object... objects) {
        this(String.format(format, objects));
    }
}
