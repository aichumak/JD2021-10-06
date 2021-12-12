package by.it.drankevich.calc;

import java.util.Locale;
import java.util.Scanner;

public class ConsoleRunner {
    public static final String STOP_APP_COMMAND = "end";


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


            System.out.println("Выберите язык : en,be,ru и нажмите Enter\n Для вывода языка по умолчанию Enter");

            switch (sc.nextLine()) {
                case "en":
                    ResourceManager.setLocale(new Locale("en", "US"));

                    break;

                case "ru":
                   ResourceManager.setLocale(new Locale("ru", "RU"));

                    break;

                case "be":
                    ResourceManager.setLocale(new Locale("be", "BY"));

                    break;

                default:
                    ResourceManager.setLocale(Locale.getDefault());

                    break;

            }


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
