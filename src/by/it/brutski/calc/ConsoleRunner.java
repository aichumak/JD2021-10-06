package by.it.brutski.calc;

import by.it.brutski.calc.exception.CalcException;
import by.it.brutski.calc.model.Var;
import by.it.brutski.calc.repository.VarRepository;
import by.it.brutski.calc.service.Parser;
import by.it.brutski.calc.service.Printer;
import by.it.brutski.calc.service.VarCreator;

import java.util.Scanner;

public class ConsoleRunner {

    public static final String STOP_APP_COMMAND = "end";

    public static void main(String[] args) throws CalcException {
        Scanner scanner = new Scanner(System.in);

        VarRepository varRepository = new VarRepository();
        VarCreator varCreator = new VarCreator(varRepository);

        Parser parser = new Parser(varRepository, varCreator);
        Printer printer = new Printer();

        for (; ; ) {
            String expression = scanner.nextLine();
            if (!expression.equals(STOP_APP_COMMAND)) {
                try {
                    Var result = parser.evaluate(expression);
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
