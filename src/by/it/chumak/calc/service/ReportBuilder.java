package by.it.chumak.calc.service;

import by.it.chumak.calc.model.Report;

import java.util.List;

public abstract class ReportBuilder {
    Report report;

    void createNewReportBuilder() {
        this.report = new Report();
    }

    Report getReport() {
        return report;
    }

    public abstract void appendReportTitle();
    public abstract void appendPackageLaunchTime();
    public abstract void appendPackageCompletionTime();
    public abstract void appendEnteredOperationsAndResults(String enteredOperationsAndResults);
    public abstract void appendErrorInfoMessages(List<?> errorInfoMessages);


}
