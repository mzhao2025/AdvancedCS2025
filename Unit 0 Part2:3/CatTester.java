public class CatTester {
    public static void main(String[] args) {
        Cat myCat = new Cat("Betsy", "Tabby"); // add new
        Cat otherCat = new Cat("Tiger Beast", "Tabby"); // add new
        System.out.println(myCat.toString());
        System.out.println("My Cat's Name: " + myCat.getName()); // add "System.out.println"

        System.out.println("Are the cat's equal?" + myCat.equals(otherCat)); // use System.out.println instead of return statement

        System.out.println("Is my cat hungry? " + myCat.getIsHungry()); // replace "print" with "System.out.println"

        String firstName = "Tiger";
        String lastName = "Beast"; // use "=" for assigning values to a variable, not "=="
        String name = firstName + " " + lastName;

        System.out.println("Changing the cat's name...");
        myCat.setName(name);
        System.out.println("The two cat's are the same now: " + myCat.equals(otherCat));

    }

}