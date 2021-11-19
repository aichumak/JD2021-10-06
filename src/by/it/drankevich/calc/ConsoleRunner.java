package by.it.drankevich.calc;

import java.util.Scanner;

public class ConsoleRunner {
    public static final String STOP_APP_COMMAND = "end";


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        VarRepository varRepository = new VarRepository();
        Varcreator varcreator = new Varcreator(varRepository);
        Parser parser =new Parser(varRepository,varcreator);
        Printer printer=new Printer();
        for (;;){
           String expression=scanner.nextLine();
           if(!expression.equals(STOP_APP_COMMAND)){
               try {
                   Var result = parser.evaluate(expression);
                   printer.print(result);
               } catch (CalcExeption e) {
                   printer.print(e);
               }

           }
           else break;
        }
        System.out.println("Calculator closed");


    }
}
