package by.it.drankevich.calc;

import by.it.drankevich.calc.exeption.CalcExeption;
import by.it.drankevich.calc.logs.*;
import by.it.drankevich.calc.model.Var;
import by.it.drankevich.calc.repository.VarRepository;
import by.it.drankevich.calc.servise.Parser;
import by.it.drankevich.calc.servise.Printer;
import by.it.drankevich.calc.servise.Varcreator;

import java.util.Locale;
import java.util.Scanner;

public class ConsoleRunner {
    public static final String STOP_APP_COMMAND = "end";


    public static void main(String[] args) throws CalcExeption {
        Log logger= Logger.getLogger();
        LogCreator logBuilderShort=new LogBuilderShort();
        LogCreator logBuilderFull=new LogBuilderFull();


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
            logger.info(ResourceManager.get("massage.Report"),logBuilderShort,logBuilderFull);


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
                   logger.info(expression, logBuilderShort,logBuilderFull);
                   logger.info(result.toString(), logBuilderShort,logBuilderFull);
               } catch (CalcExeption e) {
                   printer.print(e);
                   logger.error(e.getMessage(),logBuilderShort,logBuilderFull );
               }

           }
           else break;
        }
        System.out.println(ResourceManager.get("massage.CalcClosed"));
        logger.info(ResourceManager.get("massage.CalcClosed"), logBuilderShort,logBuilderFull);


    }
}
