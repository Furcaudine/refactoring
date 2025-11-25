package theater;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StatementData {
    private final String customer;
    private final List<PerformanceData> performances;
    private int totalAmount;
    private int totalVolumeCredits;

    public StatementData(Invoice invoice, Map<String, Play> plays) {
        this.customer = invoice.getCustomer();
        this.performances = new ArrayList<>();
        this.totalAmount = 0;
        this.totalVolumeCredits = 0;

        for (Performance performance : invoice.getPerformances()) {
            Play play = plays.get(performance.getPlayID());
            // Task 4.1 Step 4 & 5: createPerformanceData using AbstractPerformanceCalculator
            AbstractPerformanceCalculator calculator =
                    AbstractPerformanceCalculator.createPerformanceCalculator(performance, play);

            int amount = calculator.amountFor();
            int volumeCredits = calculator.volumeCredits();

            totalAmount += amount;
            totalVolumeCredits += volumeCredits;

            performances.add(new PerformanceData(play.getName(), performance.getAudience(), amount, volumeCredits));
        }
    }

    public String getCustomer() {
        return customer;
    }

    public List<PerformanceData> getPerformances() {
        return performances;
    }

    public int totalAmount() {
        return totalAmount;
    }

    public int volumeCredits() {
        return totalVolumeCredits;
    }
}