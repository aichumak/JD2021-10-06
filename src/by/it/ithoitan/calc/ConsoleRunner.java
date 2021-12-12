package by.it.ithoitan.calc;


import by.it.ithoitan.calc.ecxeption.CalcException;
import by.it.ithoitan.calc.model.Var;
import by.it.ithoitan.calc.repository.VarRepository;
import by.it.ithoitan.calc.service.Parser;
import by.it.ithoitan.calc.service.Printer;
import by.it.ithoitan.calc.service.VarCreator;

import java.util.Scanner;

public class ConsoleRunner {
    public  static final String STOP_APP_COMMAND = "end";
    public static void main(String[] args) throws CalcException {

        Scanner scanner = new Scanner(System.in);
        Printer printer = new Printer();
        VarRepository varRepository = new VarRepository();
        VarCreator varCreator = new VarCreator(varRepository);
        Parser parser = new Parser(varRepository,varCreator);
        for(;;){
            String expression = scanner.nextLine();
            if(!expression.equals(STOP_APP_COMMAND)){
                Var result = parser.evaluate(expression);
                printer.print(result);
            } else {
                break;
            }
        }
        System.out.println("Calculator closed");
    }

}
