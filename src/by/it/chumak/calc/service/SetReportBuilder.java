package by.it.chumak.calc.service;

import by.it.chumak.calc.model.ResourceManager;

import java.util.List;

public class SetReportBuilder {
    private ReportBuilder reportBuilder;

    public void SetSpecificReportBuilder(ReportBuilder reportBuilder) {
        this.reportBuilder = reportBuilder;
    }

    public void recordInitReportPart(ResourceManager resourceManager) {
        reportBuilder.createNewReportBuilder();
        reportBuilder.appendPackageLaunchTime(resourceManager);
        reportBuilder.appendReportTitle(resourceManager);
    }

    public void recordFinalReportPart(ResourceManager resourceManager) {
        reportBuilder.appendPackageCompletionTime(resourceManager);
    }

    public void recordEnteredOperationsAndResults(ResourceManager resourceManager, String enteredOperationsAndResults) {
        reportBuilder.appendEnteredOperationsAndResults(resourceManager, enteredOperationsAndResults);
    }

    public void recordErrorInfoMessages(ResourceManager resourceManager, List<?> errorInfoMessages) {
        reportBuilder.appendErrorInfoMessages(resourceManager, errorInfoMessages);
    }
}
