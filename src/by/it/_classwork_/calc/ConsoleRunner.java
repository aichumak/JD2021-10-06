package by.it._classwork_.calc;

import by.it._classwork_.calc.exception.CalcException;
import by.it._classwork_.calc.model.Var;
import by.it._classwork_.calc.repository.VarRepository;
import by.it._classwork_.calc.service.Parser;
import by.it._classwork_.calc.service.Printer;
import by.it._classwork_.calc.service.VarCreator;

import java.util.Scanner;

public class ConsoleRunner {

    public static final String STOP_APP_COMMAND = "end";

    public static void main(String[] args) {
        //2+2
        Scanner scanner = new Scanner(System.in);
        Printer printer = new Printer();
        VarRepository varRepository = new VarRepository();
        VarCreator varCreator = new VarCreator(varRepository);
        Parser parser = new Parser(varRepository, varCreator);
        for (; ; ) {
            String expression = scanner.nextLine();
            if (!expression.equals(STOP_APP_COMMAND)) {
                try {
                    Var result = parser.evaluate(expression);
                    printer.print(result);
                } catch (CalcException e) {
                    printer.print(e);
                }
            } else {
                break;
            }
        }
        System.out.println("Calculator closed");

    }
}
