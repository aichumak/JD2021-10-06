package by.it.drankevich.calc;

public class CalcExeption extends Exception{
    public CalcExeption() {
        this("no message");
    }

    public CalcExeption(String message) {
        super("ERROR: "+ message);
    }

    public CalcExeption(String message, Throwable cause) {
        super("ERROR: "+ message, cause);
    }

    public CalcExeption(Throwable cause) {
        super("no message",cause);
    }

    public CalcExeption(String format, Object...objects){
        this(String.format(format,objects));
    }
}
