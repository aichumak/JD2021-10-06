package by.it.chumak.calc.exception;

import by.it.chumak.calc.model.Messages;
import by.it.chumak.calc.model.ResourceManager;

public class CalcException extends Exception {

    public CalcException(ResourceManager resourceManager) {
        this(resourceManager, resourceManager.get(Messages.NO_MESSAGE));
    }

    public CalcException(ResourceManager resourceManager, String message) {
        super(String.format("%s %s", resourceManager.get(Messages.ERROR), message));
    }

    public CalcException(ResourceManager resourceManager, String message, Throwable cause) {
        super(String.format("%s %s %s", resourceManager.get(Messages.ERROR), message, cause));
    }

    public CalcException(ResourceManager resourceManager, Throwable cause) {
        super(String.format("%s %s", resourceManager.get(Messages.ERROR), cause));
    }

    public CalcException(ResourceManager resourceManager, String format, Object... objects) {
        this(resourceManager, String.format(format, objects));
    }
}
