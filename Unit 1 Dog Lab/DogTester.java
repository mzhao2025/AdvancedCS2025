public class DogTester {
    public static void main(String[] args) {
        // 1. Test the static generateDogChar() method
        System.out.println("=== Testing generateDogChar() ===");
        System.out.println("Dog ID 123: " + Dog.generateDogChar(123)); // should return 'L'
        System.out.println("Dog ID 456: " + Dog.generateDogChar(456)); // verify expected char
        System.out.println("Dog ID 789: " + Dog.generateDogChar(789)); // verify expected char
        System.out.println();

        // 2. Test the static pickup() method
        System.out.println("=== Testing pickup() ===");
        Dog myDog = new Dog("Buddy", "Maria", 4, 101);
        
        // Scenario 1: Correct owner picks up dog
        String result1 = Dog.pickup(myDog, "Maria");
        System.out.println(result1);
        System.out.println("Still in facility (expected false): " + myDog.isStillInFacility());

        // Scenario 2: Wrong person tries to pick up
        // Reset dog to be back in facility
        myDog.setStillInFacility(true);
        String result2 = Dog.pickup(myDog, "John");
        System.out.println(result2);
        System.out.println("Still in facility (expected true): " + myDog.isStillInFacility());
        System.out.println();

        // 3. Test the static checkIn() method
        System.out.println("=== Testing checkIn() ===");
        Dog myOtherDog = new Dog("Max", "Lisa", 3, 202);
        myOtherDog.setStillInFacility(false);

        Dog.checkIn(myOtherDog, "NewOwner");
        System.out.println("Still in facility (expected true): " + myOtherDog.isStillInFacility());
        System.out.println("Owner name (expected NewOwner): " + myOtherDog.getOwnerName());
    }
}