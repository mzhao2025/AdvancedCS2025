// No imports needed here

class MilkBar extends ChocolateBar {

    private static final double MILK_ADDIN_COST_PER_GRAM = 0.01;

    public MilkBar(int grams) {
        super(grams);
    }

    @Override
    protected String getFlavorName() {
        // TODO: return the correct flavor name
        return "Milk";
    }

    @Override
    protected double getAddInCostPerGram() {
        // TODO: return the correct add-in cost per gram
        return MILK_ADDIN_COST_PER_GRAM;
    }
}

class DarkBar extends ChocolateBar {

    private static final double DARK_ADDIN_COST_PER_GRAM = 0.02;

    public DarkBar(int grams) {
        super(grams);
    }

    @Override
    protected String getFlavorName() {
        // TODO
        return "Dark";
    }

    @Override
    protected double getAddInCostPerGram() {
        // TODO
        return DARK_ADDIN_COST_PER_GRAM;
    }
}

class MatchaBar extends ChocolateBar {

    private static final double MATCHA_ADDIN_COST_PER_GRAM = 0.03;

    public MatchaBar(int grams) {
        super(grams);
    }

    @Override
    protected String getFlavorName() {
        // TODO
        return "Matcha";
    }

    @Override
    protected double getAddInCostPerGram() {
        // TODO
        return MATCHA_ADDIN_COST_PER_GRAM;
    }
}