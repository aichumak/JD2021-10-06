package by.it.chumak.calc.exception;

import by.it.chumak.calc.model.Messages;
import by.it.chumak.calc.model.ResourceManager;
import by.it.chumak.calc.service.LoggerMethods;

public class CalcException extends Exception {

    public CalcException(LoggerMethods logger, ResourceManager resourceManager) {
        this(logger, resourceManager, resourceManager.get(Messages.NO_MESSAGE));
    }

    public CalcException(LoggerMethods logger, ResourceManager resourceManager, String message) {
        super(String.format("%s %s", resourceManager.get(Messages.ERROR), message));
        logger.error(String.format("%s %s", resourceManager.get(Messages.ERROR), message), resourceManager.getZonedDateTime());
    }

    public CalcException(LoggerMethods logger, ResourceManager resourceManager, String message, Throwable cause) {
        super(String.format("%s %s %s", resourceManager.get(Messages.ERROR), message, cause));
        logger.error(String.format("%s %s %s", resourceManager.get(Messages.ERROR), message, cause), resourceManager.getZonedDateTime());
    }

    public CalcException(LoggerMethods logger, ResourceManager resourceManager, Throwable cause) {
        super(String.format("%s %s", resourceManager.get(Messages.ERROR), cause.getCause()));
        logger.error(String.format("%s %s", resourceManager.get(Messages.ERROR), cause.getCause()), resourceManager.getZonedDateTime());
    }

    public CalcException(LoggerMethods logger, ResourceManager resourceManager, String format, Object... objects) {
        this(logger, resourceManager, String.format(format, objects));
    }
}
