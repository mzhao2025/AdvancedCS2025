import java.util.ArrayList;

public class CocoaRegister {

    public static final double TAX_RATE = 0.0875;

    private ArrayList<Sellable> items;
    private ArrayList<Integer> quantities;

    public CocoaRegister() {
        items = new ArrayList<>();
        quantities = new ArrayList<>();
    }

    public void addItem(Sellable item, int quantity) {
        // TODO:
        if (item != null && quantity > 0) {
            items.add(item);
            quantities.add(quantity);
        }
    }

    public double getSubtotal() {
        // TODO:
        double subtotal = 0.0;
        for (int i = 0; i < items.size(); i++) {
            Sellable item = items.get(i);
            int quantity = quantities.get(i);
            double lineTotal = item.getBasePrice() * quantity;
            subtotal += lineTotal;
            // Calculate line total for this item and add to subtotal
        }
        // sum item.getBasePrice() * quantity for all line items
        // return rounded to 2 decimals using ChocolateBar.round2(...)
        return ChocolateBar.round2(subtotal);
    }

    public double getTax() {
        // TODO:
        // tax = subtotal * TAX_RATE, rounded to 2 decimals
        return ChocolateBar.round2(getSubtotal() * TAX_RATE);
    }

    public double getTotal() {
        // TODO:
        // total = subtotal + tax, rounded to 2 decimals
        return ChocolateBar.round2(getSubtotal() + getTax());
    }

    public void printReceipt() {
        // TODO: Print EXACTLY the required receipt format.
        System.out.println("== COCOA CORNER ==");
        for (int i = 0; i < items.size(); i++) {
            Sellable item = items.get(i);
            int quantity = quantities.get(i);
            double lineTotal = item.getBasePrice() * quantity;
            System.out.println((i+1) + ". " + item.getName() 
                + " x" + quantity + " @ $" 
                + ChocolateBar.money(item.getBasePrice()) 
                + " = $" + ChocolateBar.money(lineTotal));
        }
        System.out.println("Subtotal: $" + ChocolateBar.money(getSubtotal()));
        System.out.println("Tax: $" + ChocolateBar.money(getTax()));
        System.out.println("Total: $" + ChocolateBar.money(getTotal()));
    }

}
