package by.it.chumak.calc;

import by.it.chumak.calc.constant.Patterns;
import by.it.chumak.calc.exception.CalcException;
import by.it.chumak.calc.model.Messages;
import by.it.chumak.calc.model.ResourceManager;
import by.it.chumak.calc.model.Var;
import by.it.chumak.calc.repository.VarRepository;
import by.it.chumak.calc.service.*;

import java.util.Scanner;

public class ConsoleRunner {

    public static void main(String[] args) throws CalcException {
        ResourceManager resourceManager = ResourceManager.INSTANCE;
        LocaleService locale = new LocaleService();
        resourceManager.setLocale(locale.getLocale());
        LoggerMethods logger = Logger.INSTANCE;
        logger.info(resourceManager.get(Messages.CALC_OPEN), resourceManager.getZonedDateTime());
        Scanner scanner = new Scanner(System.in);
        Printer printer = new Printer();
        Parser parser = new Parser();
        VarRepository varRepository = new VarRepository();

        for (; ; ) {
            String expression = scanner.nextLine();
            if (!expression.matches(Patterns.STOP_APP_COMMAND) && !expression.matches(Patterns.CHANGE_LANGUAGE_COMMAND)) {
                try {
                    Var result = parser.evaluate(resourceManager, logger, expression, varRepository);
                    printer.print(result);
                } catch (CalcException e) {
                    printer.print(e);
                }
            } else if (expression.matches(Patterns.STOP_APP_COMMAND)) {
                break;
            } else if (expression.matches(Patterns.CHANGE_LANGUAGE_COMMAND)) {
                resourceManager.setLocale(locale.getLocale(expression));
            }
        }
        System.out.println(resourceManager.get(Messages.CALC_CLOSED));
        logger.info(resourceManager.get(Messages.CALC_CLOSED), resourceManager.getZonedDateTime());
    }
}
