public interface Sellable {
    // Name to show on the receipt
    String getName();

    // Pre-tax price for ONE unit of the item
    double getBasePrice();
}