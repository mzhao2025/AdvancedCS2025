public class DogTester {
    public static void main(String[] args) {
        System.out.println("## Tester");
        System.out.println("----------------------------------------");

        // 1. Verify static method calls use PawesomeUtils
        System.out.println("1. Verifying static method calls use PawesomeUtils...");
        System.out.println("   All static method calls below reference PawesomeUtils.\n");

        // 2. Test validateDogId()
        System.out.println("2. Testing validateDogId():");

        int[] testIds = {99, 100, 500, 999, 1000};
        for (int id : testIds) {
            int validatedId = PawesomeUtils.validateDogId(id);
            System.out.println("   Input ID: " + id + " -> Validated ID: " + validatedId);
        }

        System.out.println("   Checking that invalid IDs return random values between 100-999...");
        int randomTest = PawesomeUtils.validateDogId(42);
        boolean inRange = (randomTest >= 100 && randomTest <= 999);
        System.out.println("   Random test (ID 42): " + randomTest + " -> In range? " + inRange + "\n");

        // 3. Evaluate validateDogTag()
        System.out.println("3. Evaluating validateDogTag():");

        Dog dogA = new Dog("Buddy", "Alice", 3, 345);
        Dog dogB = new Dog("Rex", "Bob", 5, 456);
        Dog dogC = new Dog("Luna", "Charlie", 2, 789);

        boolean resultA = PawesomeUtils.validateDogTag(dogA);
        boolean resultB = PawesomeUtils.validateDogTag(dogB);
        boolean resultC = PawesomeUtils.validateDogTag(dogC);

        System.out.println("   Dog A valid tag? " + resultA);
        System.out.println("   Dog B valid tag? " + resultB);
        System.out.println("   Dog C valid tag? " + resultC + "\n");

        // 4. Test edge cases with validateDogTag()
        System.out.println("4. Testing edge cases with validateDogTag():");

        if (resultA && resultB && resultC) {
            System.out.println("   All dogs valid - proceeding to modify one tag manually...");
            dogB.setDogTag("999Z");
            System.out.println("   Modified Dog B tag to: " + dogB.getDogTag());
            boolean newResultB = PawesomeUtils.validateDogTag(dogB);
            System.out.println("   After modification, Dog B valid tag? " + newResultB);
        } else {
            System.out.println("   One or more dogs already invalid - skipping manual modification test.");
        }

        // 5. Test convertAgeToHumanAge()
        System.out.println("\n5. Testing convertAgeToHumanAge():");
        Dog puppy = new Dog("Tiny", "Mia", 1, 123);
        Dog youngDog = new Dog("Bolt", "Zoe", 2, 234);
        Dog adultDog = new Dog("Max", "Evan", 5, 345);

        System.out.println("   " + puppy.getName() + " (Age " + puppy.getAge() + "): " + PawesomeUtils.convertAgeToHumanAge(puppy) + " human years");
        System.out.println("   " + youngDog.getName() + " (Age " + youngDog.getAge() + "): " + PawesomeUtils.convertAgeToHumanAge(youngDog) + " human years");
        System.out.println("   " + adultDog.getName() + " (Age " + adultDog.getAge() + "): " + PawesomeUtils.convertAgeToHumanAge(adultDog) + " human years\n");

        // 6. Test convertAgeToDogYears()
        System.out.println("6. Testing convertAgeToDogYears():");
        int[] humanAges = {5, 15, 24, 30, 50};
        for (int human : humanAges) {
            int dogYears = PawesomeUtils.convertAgeToDogYears(human);
            System.out.println("   Human age: " + human + " -> Dog years: " + dogYears);
        }

        System.out.println("\n--- End of Tester ---");
    }
}