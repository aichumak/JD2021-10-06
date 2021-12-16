package by.it.serkutsyev.calc;

import java.util.Scanner;

public class ConsoleRunner {

    public static final String STOP_APP_COMMAND = "end";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        VarRepository varRepository = new VarRepository();
        VarCreator varCreator = new VarCreator(varRepository);
        Parser parser = new Parser(varRepository,varCreator);
        Printer printer = new Printer();

        while (true) {
            String expression = sc.nextLine();
            if (!expression.equals(STOP_APP_COMMAND)) {
                Var result = parser.calc(expression);
                printer.print(result);
            } else {
                break;
            }
        }
        System.out.println("App stopped");
    }
}
