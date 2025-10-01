public class DogTester {
    public static void main(String[] args) {
        // Step 2: Create at least 3 different Dog objects

        // Using parameterized constructor (ID 123 for specific test)
        Dog dog1 = new Dog("Buddy", "Alice", 4, 123);

        // Using default constructor
        Dog dog2 = new Dog();

        // Another Dog with different attributes (ID 693 for specific test)
        Dog dog3 = new Dog("Max", "Bob", 7, 693);

        // Step 3: Test all getters and setters
        System.out.println("=== Initial Dog Details ===");
        System.out.println("Dog 1: " + dog1);
        System.out.println("Dog 2: " + dog2);
        System.out.println("Dog 3: " + dog3);

        // Modify at least 2 attributes using setters
        dog2.setName("Charlie");
        dog2.setOwnerName("Clara");
        dog2.setAge(2);
        dog2.setDogId(555);
        dog2.setDogChar(dog2.generateDogChar());
        dog2.setDogTag(dog2.generateDogTag());

        System.out.println("\n=== Updated Dog 2 Details After Setters ===");
        System.out.println("Dog 2: " + dog2);

        // Step 4: Test specialized methods

        System.out.println("\n=== generateDogChar() Tests ===");
        System.out.println("Dog 1 ID 123 expected char: L -> " + dog1.generateDogChar());
        System.out.println("Dog 3 ID 693 expected char: N -> " + dog3.generateDogChar());

        System.out.println("\n=== generateDogTag() Tests ===");
        System.out.println("Dog 1 Tag: " + dog1.generateDogTag());
        System.out.println("Dog 2 Tag: " + dog2.generateDogTag());
        System.out.println("Dog 3 Tag: " + dog3.generateDogTag());

        // Step 4 continued: toString() method
        System.out.println("\n=== toString() Method Output ===");
        System.out.println("Dog 1: " + dog1.toString());
        System.out.println("Dog 2: " + dog2.toString());
        System.out.println("Dog 3: " + dog3.toString());

        // Step 5: equals() tests
        System.out.println("\n=== equals() Method Tests ===");
        System.out.println("Dog 1 equals Dog 3? " + dog1.equals(dog3)); // false

        // Clone dog1's attributes for testing equality
        Dog dog1Copy = new Dog(dog1.getName(), dog1.getOwnerName(), dog1.getAge(), dog1.getDogId());
        dog1Copy.setDogChar(dog1.generateDogChar());
        dog1Copy.setDogTag(dog1.generateDogTag());
        dog1Copy.setStillInFacility(dog1.isStillInFacility());

        System.out.println("Dog 1 equals its copy? " + dog1.equals(dog1Copy)); // true

        // Step 6: Edge case - change stillInFacility
        System.out.println("\n=== Edge Case Test: stillInFacility ===");
        dog3.setStillInFacility(false);
        System.out.println("Dog 3 (after removal from facility): " + dog3.toString());
    }
}