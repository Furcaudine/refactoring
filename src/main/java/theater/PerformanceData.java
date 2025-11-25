package theater;

public class PerformanceData {
    private final String name;
    private final int audience;
    private final int amount;
    private final int volumeCredits;

    public PerformanceData(String name, int audience, int amount, int volumeCredits) {
        this.name = name;
        this.audience = audience;
        this.amount = amount;
        this.volumeCredits = volumeCredits;
    }

    public String getName() {
        return name;
    }

    public int getAudience() {
        return audience;
    }

    public int getAmount() {
        return amount;
    }

    // Task 3.1 Step 5: "Add an amountFor method... Use this in place of statements like amountFor(p)"
    // The instructions ask to name it amountFor() in this class to match call sites in renderPlainText
    public int amountFor() {
        return amount;
    }

    public int volumeCredits() {
        return volumeCredits;
    }
}