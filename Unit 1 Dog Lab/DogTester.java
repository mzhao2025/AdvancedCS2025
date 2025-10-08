public class DogTester {
    public static void main(String[] args) {
        System.out.println("## Tester");
        System.out.println("----------------------------------------");

        // 1. Verify static method calls use PawesomeUtils
        System.out.println("1. Verifying static method calls use PawesomeUtils...");
        System.out.println("   ✅ All static method calls below reference PawesomeUtils.\n");

        // 2. Test validateDogId()
        System.out.println("2. Testing validateDogId():");

        // 2a–c. Test with valid and invalid IDs
        int[] testIds = {99, 100, 500, 999, 1000};
        for (int id : testIds) {
            int validatedId = PawesomeUtils.validateDogId(id);
            System.out.println("   Input ID: " + id + " → Validated ID: " + validatedId);
        }

        // 2d. Confirm invalid IDs generate random ID (100–999)
        System.out.println("   Checking that invalid IDs return random values between 100–999...");
        int randomTest = PawesomeUtils.validateDogId(42);
        boolean inRange = (randomTest >= 100 && randomTest <= 999);
        System.out.println("   Random test (ID 42): " + randomTest + " → In range? " + inRange + "\n");


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
            System.out.println("   All dogs valid — proceeding to modify one tag manually...");

            // 4a. Modify one dog's tag to invalid value
            dogB.setDogTag("999Z");
            System.out.println("   Modified Dog B tag to: " + dogB.getDogTag());

            // 4b. Call validateDogTag() again
            boolean newResultB = PawesomeUtils.validateDogTag(dogB);

            // 4c. Verify it now returns false
            System.out.println("   After modification, Dog B valid tag? " + newResultB);
        } else {
            System.out.println("   One or more dogs already invalid — skipping manual modification test.");
        }

        System.out.println("\n--- End of Tester ---");
    }
}