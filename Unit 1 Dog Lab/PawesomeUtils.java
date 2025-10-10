public class PawesomeUtils {
    public static char generateDogChar(int dogId) {
        int sum = 0;

        while (dogId > 0) {
            sum += dogId % 10;
            dogId /= 10;
        }
        
        return (char) ('F' + (sum % 10));
    }

    public static String pickup(Dog dog, String personName) {
        if (dog.getOwnerName().equals(personName) && dog.isStillInFacility()) {
            dog.setStillInFacility(false);
            return dog.getName() + " has been picked up by their owner " + personName + ".";
        }
        else if (!dog.getOwnerName().equals(personName)) {
            return personName + " is not the owner of " + dog.getName() + " and cannot pick them up.";
        }
        else {
            return dog.getName() + " is not currently in the facility.";
        }
    }

    public static String checkIn(Dog dog, String personName) {
        dog.setOwnerName(personName);
        if (PawesomeUtils.validateDogTag(dog)) {
            dog.setStillInFacility(true);
            return "Successfully checked in " + dog.getName() + ".";
        }
        else {
            int newDogId = PawesomeUtils.validateDogId(dog.getDogId());
            char newDogChar = PawesomeUtils.generateDogChar(newDogId);
            String newDogTag = PawesomeUtils.generateDogTag(newDogId, newDogChar);
            dog.setDogId(newDogId);
            dog.setDogChar(newDogChar);
            dog.setDogTag(newDogTag);
            dog.setStillInFacility(false);
            return "Denied Access for " + dog.getName() + ". Note: Dog ID and Dog Tag have been updated to valid ones.";
        }
        
    }

    public static String generateDogTag(int dogId, char dogChar) {
        return "" + dogId + dogChar;
    }

    public static int validateDogId(int dogId) {
        if (dogId <= 999 && dogId >= 100) {
            return dogId;
        }
        else {
            return 100 + (int) (Math.random() * 800);
        }
    }

    public static Boolean validateDogTag(Dog dog) {
        int dogId = dog.getDogId();
        dogId = validateDogId(dogId);
        String dogTag = "" + dogId + generateDogChar(dogId);
        if (dogTag.equals(dog.getDogTag())) {
            return true;
        }
        else {
            return false;
        }
    }

    public static int convertAgeToHumanAge(Dog dog) {
        if (dog.getAge() == 1) {
            return 15;
        }
        else if (dog.getAge() == 2) {
            return 24;
        }
        else if (dog.getAge() > 2) {
            return 24 + (dog.getAge() - 2) * 5;
        }
        else {
            return 0;
        }
    }

    public static int convertAgeToDogYears(int humanYears) {
        if (humanYears <= 0) {
            return 0;
        }
        else if (humanYears <= 15) {
            return 1;
        }
        else if (humanYears <= 24) {
            return 2;
        }
        else {
            return 2 + (humanYears - 24) / 5;
        }
    }

    
}