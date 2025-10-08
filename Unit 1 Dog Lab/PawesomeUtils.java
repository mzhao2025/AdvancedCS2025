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

    public static void checkIn(Dog dog, String personName) {
        dog.setStillInFacility(true);
        dog.setOwnerName(personName);
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
        };
    }

    
}