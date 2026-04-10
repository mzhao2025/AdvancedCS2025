import java.util.Date;

public class TicketTester {
    public static void main(String[] args) {
        Date today = new Date();

        StandardTicket standardTicket = new StandardTicket(today, 3);
        standardTicket.printTicketDetails();

        MemberTicket memberTicket = new MemberTicket(today, 3);
        memberTicket.printTicketDetails();

        StudentTicket studentTicket = new StudentTicket(today, 3);
        studentTicket.printTicketDetails();

    }
}