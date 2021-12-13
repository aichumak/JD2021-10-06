package by.it.brutski.calc.exception;

public class CalcException extends Exception {
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
        super("no message", cause);
    }

    public CalcException(String format, Object... objects) {
        this(String.format(format, objects));
    }
}
