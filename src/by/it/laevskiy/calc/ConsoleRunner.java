package by.it.laevskiy.calc;

import java.util.Scanner;

public class ConsoleRunner {

    public static final String STOP_APP_COMMAND = "end";

    public static void main(String[] args) throws CalcException {
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
