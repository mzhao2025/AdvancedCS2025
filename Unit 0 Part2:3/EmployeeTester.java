public class EmployeeTester {
    public static void main(String[] args) {
        System.out.println("Employee Tester");

        // Instantiating Employee Objects
        Employee employee1 = new Employee("John Smith", "Manager", 50000);
        Employee employee2 = new Employee("Jane Doe", "Engineer", 85000);
        Employee employee3 = new Employee("Jane Doe", "Engineer", 85000);

        // Testing Getters
        System.out.println("1. Employee 1 Name: " + employee1.getName()
                + testGetName(employee1, "John Smith"));
        System.out.println("2. Employee 2 Job Title: " + employee2.getJobTitle()
                + testGetJobTitle(employee2, "Engineer"));
        System.out.println(
                "3. Employee 1 Salary: " + employee1.getSalary() + testGetSalary(employee1, 50000));


        // Testing equals()
        System.out.println("4. Are Employee 1 and 2 equal? "
                + (employee1.equals(employee2) ? "Yes... Fail!" : "No... Pass!"));
        System.out.println("5. Are Employee 2 and 3 equal? "
                + (employee2.equals(employee3) ? "Yes... Pass!" : "No... Fail!"));

        // Testing toString()
        String outputMatcher = "Name: Jane Doe, Job Title: Engineer, Salary: 85000";
        System.out.println("6. Did I match the string exactly? "
                + (employee2.toString().equals(outputMatcher) ? "Yes... Pass!" : "No... Fail!"));


        System.out.println();
        System.out.println("To String Method: ");
        System.out.println(employee2.toString());
        System.out.println();

        // Test other methods here
        System.out.println(
                "7. (Optional) Create a test case for any other methods in the class that you have written.");



    }

    public static String testGetName(Employee employee, String name) {
        return employee.getName().equals(name) ? "... Pass!" : "... Fail!";
    }

    public static String testGetJobTitle(Employee employee, String title) {
        return employee.getJobTitle().equals(title) ? "... Pass!" : "... Fail!";
    }

    public static String testGetSalary(Employee employee, int salary) {
        return employee.getSalary() == salary ? "... Pass!" : "... Fail!";
    }


}