package ID27747.Q3;
import java.util.Date;

public class TaxRecord extends Payment {
    private String receiptNo;
    private double totalTax;

    public TaxRecord(int id, Date createDate, Date updateDate, String authorityName, String region, String email, String categoryName, double rate, String code, String tin, String taxpayerName, String address, String employerName, String employerTIN, String contact, String employeeName, double salary, String employeeTIN, String declarationMonth, double totalIncome, Date assessmentDate, double assessedTax, Date paymentDate, double paymentAmount, String receiptNo, double totalTax) {
        super(id, createDate, updateDate, authorityName, region, email, categoryName, rate, code, tin, taxpayerName, address, employerName, employerTIN, contact, employeeName, salary, employeeTIN, declarationMonth, totalIncome, assessmentDate, assessedTax, paymentDate, paymentAmount);
        this.receiptNo = receiptNo;
        this.totalTax = totalTax;
    }

    public String getReceiptNo() {
        return receiptNo;
    }

    public void setReceiptNo(String receiptNo) {
        this.receiptNo = receiptNo;
    }

    public double getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(double totalTax) {
        this.totalTax = totalTax;
    }

    // computeTax method as required = (salary × rate) – credits
    public double computeTax() {
        double salary = getSalary();
        double rate = getRate();
        double credits = 0.0;

        // Apply tax credits based on income level
        if (salary <= 30000) {
            credits = salary * 0.05; // 5% credit for low income
        } else if (salary <= 60000) {
            credits = salary * 0.03; // 3% credit for medium income
        }

        double calculatedTax = (salary * rate) - credits;
        return Math.max(0, calculatedTax); // Ensure tax is not negative
    }

    public String generateTaxReport() {
        StringBuilder report = new StringBuilder();
        report.append("_27483"); // Student ID concatenation

        report.append("\n=== TAX ADMINISTRATION SYSTEM REPORT ===");
        report.append("\nReceipt Number: ").append(receiptNo);
        report.append("\nComputed Tax: $").append(String.format("%.2f", computeTax()));
        report.append("\nTotal Tax: $").append(String.format("%.2f", totalTax));
        report.append("\n========================================");

        return report.toString();
    }
}