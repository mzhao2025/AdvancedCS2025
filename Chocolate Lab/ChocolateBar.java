import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class ChocolateBar implements Sellable {

    private static final double BASE_PRICE_PER_GRAM = 0.03;
    private static final double PACKAGING_FEE = 0.50;

    protected int grams;

    public ChocolateBar(int grams) {
        this.grams = grams;
    }

    public int getGrams() {
        return grams;
    }

    // ---------- abstract customization points ----------
    protected abstract String getFlavorName();
    protected abstract double getAddInCostPerGram();

    // ---------- shared behavior ----------
    @Override
    public String getName() {
        return getFlavorName() + " Bar (" + grams + "g)";
    }

    @Override
    public double getBasePrice() {
        double base = (grams * BASE_PRICE_PER_GRAM) + (grams * getAddInCostPerGram()) + PACKAGING_FEE;

        return round2(base);
    }

    // Shared helpers so every class prints money consistently
    public static double round2(double value) {
        return new BigDecimal(value).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    public static String money(double value) {
        return String.format("%.2f", round2(value));
    }
}