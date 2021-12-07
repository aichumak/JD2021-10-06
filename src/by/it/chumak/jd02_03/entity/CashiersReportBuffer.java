package by.it.chumak.jd02_03.entity;

public class CashiersReportBuffer {
    private final StringBuffer stringBuffer;

    public CashiersReportBuffer() {
        this.stringBuffer = new StringBuffer();
        stringBuffer.append("");
        stringBuffer.append("╔════════════════════╤════════════════════╤════════════════════╤════════════════════╤════════════════════╤════════════════════╤════════════════════╗");
        stringBuffer.append("║   Cashier 1        │   Cashier 2        │   Cashier 3        │   Cashier 4        │   Cashier 5        │  Customers queue   │ Total store profit ║");
        stringBuffer.append("╟────────────────────┼────────────────────┼────────────────────┼────────────────────┼────────────────────┼────────────────────┼────────────────────╢");
    }

    public StringBuffer getStringBuffer() {
        return stringBuffer;
    }
}
