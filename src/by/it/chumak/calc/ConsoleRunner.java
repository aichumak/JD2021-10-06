package by.it.chumak.calc;

import by.it.chumak.calc.exception.CalcException;
import by.it.chumak.calc.model.Var;
import by.it.chumak.calc.repository.VarRepository;
import by.it.chumak.calc.service.Parser;
import by.it.chumak.calc.service.Printer;

import java.util.Scanner;

public class ConsoleRunner {

    public static final String STOP_APP_COMMAND = "end";

    public static void main(String[] args) throws CalcException {
        Scanner scanner = new Scanner(System.in);
        Printer printer = new Printer();
        Parser parser = new Parser();
        VarRepository varRepository = new VarRepository();
        for (; ; ) {
            String expression = scanner.nextLine();
                if (!expression.equals(STOP_APP_COMMAND)) {
                    try {
                        Var result = parser.evaluate(expression, varRepository);
                        printer.print(result);
                    }
                    catch (CalcException e){
                        printer.print(e);
                    }
                } else {
                    break;
                }
        }
        System.out.println("Calculator closed");
    }
}
