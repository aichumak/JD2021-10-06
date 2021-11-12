package by.it.astapchik.jd01_09;
import java.util.Scanner;

class ConsoleRunner {

    private static final String STOP = "end";

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Printer printer = new Printer();
        Parser parser = new Parser();
        for(;;){
            String expression = input.nextLine();
            if (!expression.equals(STOP)){
                Var result = parser.evaluate(expression);
                printer.print(result);
            } else {
                break;
            }
        }
        System.out.println("App Calculator closed.");
    }
}

