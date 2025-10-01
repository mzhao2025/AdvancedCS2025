public class BankTester {
    public static void main(String[] args) {
        Bank bank1 = new Bank(3, 5); // instantiate a new Bank object

        Bank bank2 = new Bank(4, 5); // instantiate a new Bank object

        System.out.println(bank1.computeTotalEmployees()); // should print 8

        bank2.setNumberOfLoanOfficers(3); // bank2 now has 3 loan officers

        System.out.println(bank1.getNumberOfTellers()); // should print 5

        System.out.println(bank1.equals(bank2)); // should print true

        System.out.println(bank2); // prints "This bank has 3 loan officers
        // and 5 tellers."

        bank1.hireMembers(2, true); // bank1 now has 5 loan officers
        bank1.hireMembers(1, false); // bank1 now has 6 tellers
        System.out.println(bank1.getEmployeeRatio()); // should print 0.8333...
        bank1.fireMembers(1, true); // bank1 now has 4 loan officers
        bank1.fireMembers(10, false); // bank1 now has 0 tellers
        bank1.transferEmployee(true); // bank1 now has 3 loan officers and 1 teller
        System.out.println(bank1.toString()); // prints "This bank has 3 loan officers
        System.out.println(bank1.getTotalSalary());

    }
}
