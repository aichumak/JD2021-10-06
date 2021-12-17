package by.it.chumak.calc.service;

import by.it.chumak.calc.model.Report;
import by.it.chumak.calc.model.ResourceManager;

import java.util.List;

public abstract class ReportBuilder {
    Report report;

    void createNewReportBuilder() {
        this.report = new Report();
    }

    public abstract void appendReportTitle(ResourceManager resourceManager);

    public abstract void appendPackageLaunchTime(ResourceManager resourceManager);

    public abstract void appendPackageCompletionTime(ResourceManager resourceManager);

    public abstract void appendEnteredOperationsAndResults(ResourceManager resourceManager, String enteredOperationsAndResults);

    public abstract void appendErrorInfoMessages(ResourceManager resourceManager, List<?> errorInfoMessages);

}
