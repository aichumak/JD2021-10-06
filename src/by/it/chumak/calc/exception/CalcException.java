package by.it.chumak.calc.exception;

import by.it.chumak.calc.model.Messages;
import by.it.chumak.calc.model.ResourceManager;
import by.it.chumak.calc.service.LoggerMethods;
import by.it.chumak.calc.service.ReportBuilder;
import by.it.chumak.calc.service.SetReportBuilder;

import java.util.ArrayList;
import java.util.List;

public class CalcException extends Exception {

    public CalcException(LoggerMethods logger, SetReportBuilder reportBuilder, List<ReportBuilder> builders, ResourceManager resourceManager) {
        this(logger, reportBuilder, builders, resourceManager, resourceManager.get(Messages.NO_MESSAGE));
    }

    public CalcException(LoggerMethods logger, SetReportBuilder reportBuilder, List<ReportBuilder> builders, ResourceManager resourceManager, String message) {
        super(String.format("%s %s", resourceManager.get(Messages.ERROR), message));
        logger.error(String.format("%s %s", resourceManager.get(Messages.ERROR), message), resourceManager.getZonedDateTime());
        buildReport(resourceManager, reportBuilder, builders, resourceManager.get(Messages.ERROR), message, "");
    }

    public CalcException(LoggerMethods logger, SetReportBuilder reportBuilder, List<ReportBuilder> builders, ResourceManager resourceManager, String message, Throwable cause) {
        super(String.format("%s %s %s", resourceManager.get(Messages.ERROR), message, cause));
        logger.error(String.format("%s %s %s", resourceManager.get(Messages.ERROR), message, cause), resourceManager.getZonedDateTime());
        buildReport(resourceManager, reportBuilder, builders, resourceManager.get(Messages.ERROR), message, cause.toString());
    }

    public CalcException(LoggerMethods logger, SetReportBuilder reportBuilder, List<ReportBuilder> builders, ResourceManager resourceManager, Throwable cause) {
        super(String.format("%s %s", resourceManager.get(Messages.ERROR), cause.getCause()));
        logger.error(String.format("%s %s", resourceManager.get(Messages.ERROR), cause.getCause()), resourceManager.getZonedDateTime());
        buildReport(resourceManager, reportBuilder, builders, resourceManager.get(Messages.ERROR), "", cause.getCause().toString());
    }

    public CalcException(LoggerMethods logger, SetReportBuilder reportBuilder, List<ReportBuilder> builders, ResourceManager resourceManager, String format, Object... objects) {
        this(logger, reportBuilder, builders, resourceManager, String.format(format, objects));
    }

    private void buildReport(ResourceManager resourceManager, SetReportBuilder reportBuilder, List<ReportBuilder> builders, String messageTYPE, String message, String cause) {
        List<String> parametersList = getParametersList(messageTYPE, message, cause);
        for (ReportBuilder builder : builders) {
            reportBuilder.SetSpecificReportBuilder(builder);
            reportBuilder.recordErrorInfoMessages(resourceManager, parametersList);
        }
    }

    private List<String> getParametersList(String messageTYPE, String message, String cause) {
        List<String> parametersList = new ArrayList<>();
        parametersList.add(messageTYPE); //messageTYPE
        parametersList.add(message); // message
        parametersList.add(cause); // cause
        return parametersList;
    }

}
