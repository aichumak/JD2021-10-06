package by.it.vrublevskii.jd01_09;

import java.util.Scanner;

class ConsoleRunner {

    public static final String STOP_COMMAND = "end";

    public static void main(String[] args) {
//        2+2
        Scanner scanner = new Scanner(System.in);
        Printer printer = new Printer();
        Parser parser = new Parser();
        for(;;){
            String expression = scanner.nextLine();
            if(!expression.equals(STOP_COMMAND)){
                Var result = parser.evaluate(expression);
                printer.print(result);
            }else{
                break;
            }


        }
    }
}
