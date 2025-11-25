package theater;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;

/**
 * This class generates a statement for a given invoice of performances.
 */
public class StatementPrinter {
    protected final StatementData statementData;

    public StatementPrinter(Invoice invoice, Map<String, Play> plays) {
        this.statementData = new StatementData(invoice, plays);
    }

    /**
     * Returns a formatted statement of the invoice associated with this printer.
     * @return the formatted statement
     */
    public String statement() {
        return renderPlainText();
    }

    private String renderPlainText() {
        StringBuilder result = new StringBuilder(String.format("Statement for %s%n", statementData.getCustomer()));

        for (PerformanceData p : statementData.getPerformances()) {
            // print line for this order
            result.append(String.format("  %s: %s (%s seats)%n",
                    p.getName(),
                    usd(p.amountFor()),
                    p.getAudience()));
        }
        result.append(String.format("Amount owed is %s%n", usd(statementData.totalAmount())));
        result.append(String.format("You earned %s credits%n", statementData.volumeCredits()));
        return result.toString();
    }

    protected String usd(int amount) {
        return NumberFormat.getCurrencyInstance(Locale.US).format(amount / Constants.PERCENT_FACTOR);
    }
}