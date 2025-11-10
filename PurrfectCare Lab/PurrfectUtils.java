public class PurrfectUtils {
    public static String determineCatMood(Cat cat) {
        int moodLevel = cat.getMoodLevel();

        if (moodLevel > 7 && moodLevel <= 10) {
            return "Currently, Cookie is in a great mood.\nPetting is appreciated.";
        } else if (moodLevel > 3 && moodLevel <= 7) {
            return "Currently, Cookie is reminiscing of a past life.\nPetting is acceptable.";
        } else {
            return "Currently, Cookie is plotting revengeance.\nPetting is extremely risky.";
        }
    }

    public static char generateCatChar(String catId) {
        int sum = 0;
        for (int i = 0; i < catId.length(); i++) {
            sum += Character.getNumericValue(catId.charAt(i));
        }
        return (char) ('A' + (sum % 26));
    }

    public static int generateRandomNumber(int low, int high) {
        if (high < low) {
            return (int) (Math.random() * (low - high + 1)) + high;
        }
        return (int) (Math.random() * (high - low + 1)) + low;
        
    }

    public static String validateCatId(String catId) {
        int id = Integer.parseInt(catId);
        if (id >= 1000 && id <= 9999) {
            return catId;
        }
        int newId = (int) (Math.random() * 9000) + 1000;
        return String.valueOf(newId);
}
    

    public static int validateMoodLevel(int moodLevel) {
        if (moodLevel < 0) {
            return 0;
        } else if (moodLevel > 10) {
            return 10;
        } else {
            return moodLevel;
        }
    }

    public static void bootUp(Cat cat) {
        System.out.println(cat.toString());
    }

    public static void pet(Cat cat) {
        System.out.println("Attempting to pet...");
        if (cat.getMoodLevel() >= 2) {
            cat.setMoodLevel(cat.getMoodLevel() + 1);
            System.out.println("Petting successful!");
        } else if (cat.getMoodLevel() < 2 && cat.isHungry()) {
            cat.setMoodLevel(cat.getMoodLevel() - 1);
            System.out.println("Petting failed...");
        } else {
            cat.setMoodLevel(cat.getMoodLevel() + 1);
            System.out.println("Petting successful!");
        }
    }

    public static void trimClaws(Cat cat) {
        System.out.println("Attempting to trim claws...");

        // 50% chance to decrease by 1 or 2
        int decrease = (Math.random() < 0.5) ? 1 : 2;
        cat.setMoodLevel(cat.getMoodLevel() - 1); // assuming you already have this method

        if (decrease == 1) {
            System.out.println(cat.getName() + " did not like that...");
        } else {
            System.out.println(cat.getName() + " really hated that!");
        }
    }

    public static void feed(Cat cat) {
        System.out.println("Filling up " 
            + cat.getName() 
            + "'s bowl...\n Done!\n" 
            + cat.getName() 
            + " is eating...\n" 
            + cat.getName() 
            + " is full");
        cat.setHungry(false);
        cat.setMoodLevel(cat.getMoodLevel() + 2);
    }
}
