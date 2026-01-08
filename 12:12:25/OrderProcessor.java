public class OrderProcessor {
    // Brief written explanation
    // I took any redundant code from processCustomerOrder and moved it into two
    // separate helper methods: calculateSubtotal() and extractPremiumItems().
    // This improves code readability and maintainability by isolating specific
    // functionalities into their own methods.

    public static OrderSummary processCustomerOrder(Item[] items, double taxRate) {
        // collect order summary details from calculateSubtotal() and
        // extractPremiumItems()
        double subtotal = calculateSubtotal(items);
        String[] premiumItems = extractPremiumItems(items);
        double tax = subtotal * taxRate;
        double total = subtotal + tax;

        System.out.println("Subtotal: $" + subtotal);
        System.out.println("Tax: $" + tax);
        System.out.println("Total: $" + total);
        System.out.println("Number of premium items: " + premiumItems.length);

        return new OrderSummary(total, subtotal, tax, premiumItems);
    }

    private static double calculateSubtotal(Item[] items) {
        // Calculate subtotal, used in processCustomerOrder
        double subtotal = 0;
        for (Item item : items) {
            subtotal += item.getPrice() * item.getQuantity();
        }
        return subtotal;
    }

    private static String[] extractPremiumItems(Item[] items) {
        // Extract premium items, used in processCustomerOrder
        String[] temp = new String[items.length];
        int count = 0;

        for (Item item : items) {
            double price = item.getPrice();
            String name = item.getName();

            if (price > 50.0) {
                temp[count] = name;
                count++;
                System.out.println(name + " is a premium item at $" + price);
            } else {
                System.out.println(name + " is a regular item at $" + price);
            }
        }

        String[] premium = new String[count];
        for (int i = 0; i < count; i++) {
            premium[i] = temp[i];
        }

        return premium;
    }
}