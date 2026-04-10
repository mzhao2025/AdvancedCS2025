import java.util.ArrayList;
import java.util.Arrays;

public class ContactListTester {
    public static void main(String args[]) {


        // A list of unsorted names
        ArrayList<String> names = new ArrayList<String>(
                Arrays.asList("Alice", "Tommy", "Bobby", "Annabelle", "Samantha", "Samuel", "Alice"));


        // initializing a contact list
        ContactList contactList = new ContactList();


        System.out.println("=== Testing Adding Names ===");
        // testing the add method
        for (String name : names) {
            contactList.add(name);
            System.out.println(contactList);
        }


        // Current contact list should be 
        // Contact List: [Alice, Annabelle, Bobby, Samantha, Samuel, Tommy]


        if(contactList.toString().equals("Contact List: [Alice, Annabelle, Bobby, Samantha, Samuel, Tommy]")) {
            System.out.println("=== Adding Names PASSED! === \n");
        } else {
            System.out.println("=== Adding Names FAILED! === \n");
        }


        System.out.println("=== Testing Removing Names ===");

        // testing the remove method
        contactList.remove("Bobby");
        System.out.println(contactList);

        contactList.remove("Alice");
        System.out.println(contactList);

        contactList.add("Fred");
        System.out.println(contactList);

        contactList.add("Xena");
        System.out.println(contactList);

        contactList.remove("Tommy");
        System.out.println(contactList);

        contactList.remove("Fred");
        System.out.println(contactList);

        contactList.remove("Annabelle");
        System.out.println(contactList);

        contactList.remove("Samantha");
        System.out.println(contactList);

        // Final contact list should be
        // Contact List: [Samuel, Xena]

        if(contactList.toString().equals("Contact List: [Samuel, Xena]")) {
            System.out.println("=== Removing Names PASSED! === \n");
        } else {
            System.out.println("=== Removing Names FAILED! === \n");
        }
    }
}

