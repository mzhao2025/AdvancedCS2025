
// This item is NOT a ChocolateBar, but it IS Sellable.
// Thats the point of the interface.
class CocoaSticker implements Sellable {

    private static final double PRICE = 0.50;

    @Override
    public String getName() {
        return "Cocoa Sticker";
    }

    @Override
    public double getBasePrice() {
        return PRICE;
    }
}

// This item is NOT a ChocolateBar, but it IS Sellable.
// Thats the point of the interface.
class TShirt implements Sellable {

    private static final double PRICE = 25.00;

    @Override
    public String getName() {
        return "T-Shirt";
    }

    @Override
    public double getBasePrice() {
        return PRICE;
    }
}