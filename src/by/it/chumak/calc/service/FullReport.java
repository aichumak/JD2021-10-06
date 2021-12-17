package by.it.chumak.calc.service;

import by.it.chumak.calc.ConsoleRunner;
import by.it.chumak.calc.model.GetPathMethod;
import by.it.chumak.calc.model.Messages;
import by.it.chumak.calc.model.PathMethods;
import by.it.chumak.calc.model.ResourceManager;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class FullReport extends ReportBuilder {

    @Override
    public void appendReportTitle(ResourceManager resourceManager) {
        report.appendReportTitle(resourceManager.getZonedDateTime() + " --- " + resourceManager.get(Messages.FULL_REPORT));
    }

    @Override
    public void appendPackageLaunchTime(ResourceManager resourceManager) {
        report.appendPackageLaunchTime(resourceManager.getZonedDateTime() + " --- " + resourceManager.get(Messages.CALC_OPEN));
    }

    @Override
    public void appendPackageCompletionTime(ResourceManager resourceManager) {
        PathMethods pathMethods = new GetPathMethod();
        String path = pathMethods.getFilePath(ConsoleRunner.class, "FullLogReport.txt");

        report.appendPackageCompletionTime(resourceManager.getZonedDateTime() + " --- " + resourceManager.get(Messages.CALC_CLOSED));

        try (PrintWriter writer = new PrintWriter(new FileWriter(path, false))) {
            writer.printf(report.toString());
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void appendEnteredOperationsAndResults(ResourceManager resourceManager, String enteredOperationsAndResults) {
        report.appendEnteredOperationsAndResults(resourceManager.getZonedDateTime() + " --- " + enteredOperationsAndResults);
    }

    @Override
    public void appendErrorInfoMessages(ResourceManager resourceManager, List<?> errorInfoMessages) {
        report.appendErrorInfoMessages(errorInfoMessages.get(0).toString() + errorInfoMessages.get(1).toString() + errorInfoMessages.get(2).toString());
    }
}
