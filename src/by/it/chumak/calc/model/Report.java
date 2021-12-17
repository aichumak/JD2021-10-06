package by.it.chumak.calc.model;

public class Report {

    private StringBuilder reportTitle = new StringBuilder();
    private StringBuilder packageLaunchTime = new StringBuilder();
    private StringBuilder packageCompletionTime = new StringBuilder();
    private StringBuilder enteredOperationsAndResults = new StringBuilder();
    private StringBuilder errorInfoMessages = new StringBuilder();

    public void appendReportTitle(String reportTitle){
     this.reportTitle.append(reportTitle);
     this.reportTitle.append("\n");
    }

    public void appendPackageLaunchTime(String packageLaunchTime){
        this.reportTitle.append(packageLaunchTime);
        this.reportTitle.append("\n");
    }

    public void appendPackageCompletionTime(String packageCompletionTime){
        this.reportTitle.append(packageCompletionTime);
        this.reportTitle.append("\n");
    }

    public void appendEnteredOperationsAndResults(String enteredOperationsAndResults){
        this.reportTitle.append(enteredOperationsAndResults);
        this.reportTitle.append("\n");
    }

    public void appendErrorInfoMessages(String errorInfoMessages){
        this.reportTitle.append(errorInfoMessages);
        this.reportTitle.append("\n");
    }
}
