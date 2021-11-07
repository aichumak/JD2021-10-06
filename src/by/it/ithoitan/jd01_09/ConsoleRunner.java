package by.it.ithoitan.jd01_09;

import java.util.Scanner;

public class ConsoleRunner {
    public  static final String STOP_APP_COMMAND = "end";
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Printer printer = new Printer();
        Parcer parcer = new Parcer();
        for(;;){
            String expression = scanner.nextLine();
            if(!expression.equals(STOP_APP_COMMAND)){
                Var result = parcer.evaluate(expression);
                printer.print(result);
            } else {
                break;
            }
        }
        System.out.println("Calculator closed");
    }

}
