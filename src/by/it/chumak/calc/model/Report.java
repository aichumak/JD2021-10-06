package by.it.chumak.calc.model;

public class Report {

    private final StringBuilder report = new StringBuilder();

    public void appendReportTitle(String reportTitle) {
        this.report.append(reportTitle);
        this.report.append("\n");
    }

    public void appendPackageLaunchTime(String packageLaunchTime) {
        this.report.append(packageLaunchTime);
        this.report.append("\n");
    }

    public void appendPackageCompletionTime(String packageCompletionTime) {
        this.report.append(packageCompletionTime);
        this.report.append("\n");
    }

    public void appendEnteredOperationsAndResults(String enteredOperationsAndResults) {
        this.report.append(enteredOperationsAndResults);
        this.report.append("\n");
    }

    public void appendErrorInfoMessages(String errorInfoMessages) {
        this.report.append(errorInfoMessages);
        this.report.append("\n");
    }

    @Override
    public String toString() {
        return "Report{" +
                "report=" + report +
                '}';
    }
}
