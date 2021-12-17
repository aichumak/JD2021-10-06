package by.it.chumak.calc.service;

import java.util.List;

public class SetReportBuilder {
    private ReportBuilder reportBuilder;

    public void SetReportBuilder(ReportBuilder reportBuilder) {
        this.reportBuilder = reportBuilder;
    }

    public ReportBuilder getReportBuilder() {
        return reportBuilder;
    }

    public void recordInitReportPart(){
        reportBuilder.appendPackageLaunchTime();
        reportBuilder.appendReportTitle();
    }

    public void recordFinalReportPart(){
        reportBuilder.appendPackageCompletionTime();
    }

    public void recordEnteredOperationsAndResults(String enteredOperationsAndResults){
        reportBuilder.appendEnteredOperationsAndResults(enteredOperationsAndResults);
    }

    public void recordErrorInfoMessages(List<?> errorInfoMessages){
        reportBuilder.appendErrorInfoMessages(errorInfoMessages);
    }
}
