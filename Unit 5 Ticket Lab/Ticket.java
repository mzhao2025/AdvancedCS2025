import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Ticket {
    private static final double BASE_PRICE = 20.0; // static variables are shared
    private static final double TAX = 0.0924; // cannot be changed due to 'final'

    protected String eventDate;
    protected int ticketCount;

    public Ticket(Date eventDate, int ticketCount) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
        this.eventDate = simpleDateFormat.format(eventDate);
        this.ticketCount = ticketCount;
    }

    // concrete methods
    public double getBasePrice() {
        return BASE_PRICE;
    }

    public double getTax() {
        return TAX;
    }

    public int getTicketCount() {
        return ticketCount;
    }

    public void printTicketDetails() {
        System.out.println("== RECEIPT ==\nEvent Date: " + eventDate + "\nCount: " + ticketCount);
    }

    public void printCancellationPolicy() {
        System.out.print("Cancellation Policy: ");
    }

    // abstract methods
    public abstract void printTicketType();

    public abstract void printPrice();

}