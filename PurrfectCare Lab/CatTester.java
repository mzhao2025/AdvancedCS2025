public class CatTester {
    public static void main(String[] args) {
        // 1. Create a new Cat object
        Cat cat1 = new Cat("Cookie", "Michael", 9, "1435");

        // 2. Use setters to update instance variables and verify updates
        cat1.setName("Cookie");
        cat1.setOwnerName("Michael Zhao");
        cat1.setMoodLevel(8);
        cat1.setCatId("1435");
        cat1.setCatChar('N');

        System.out.println("Updated Cat Tag: " + cat1.generateCatTag());
        System.out.println("Updated Mood Level: " + cat1.getMoodLevel());

        // 3. Create another Cat with same values and compare
        Cat cat2 = new Cat("Cookie", "Michael Zhao", 8, "1435");
        cat2.setCatChar('N');
        System.out.println("Cats equal? " + cat1.equals(cat2));

        // 4. Call bootUp()
        PurrfectUtils.bootUp(cat1);

        // 5. Test pet()
        PurrfectUtils.pet(cat1);

        // 6. Test trimClaws() 4 times
        for (int i = 0; i < 4; i++) {
            PurrfectUtils.trimClaws(cat1);
        }

        // 7. Test cleanLitterBox()
        cleanLitterBox(cat1);

        // 8. Test feed()
        PurrfectUtils.feed(cat1);
    }

    // Custom cleanLitterBox() since it's not in provided code
    public static void cleanLitterBox(Cat cat) {
        System.out.println("Cleaning the litter box...");
        System.out.println("Done!");
        System.out.println(cat.getName() + " appreciated that.");
        cat.setMoodLevel(cat.getMoodLevel() + 1);
    }
}
