public class Dog {
    private String name;
    private String ownerName;
    private int age;
    private int dogId;
    private char dogChar;
    private String dogTag;
    private boolean stillInFacility;

    public Dog(String name, String ownerName, int age, int dogId) {
        this.name = name;
        this.ownerName = ownerName;
        this.age = age;
        this.dogId = dogId;
        this.dogChar = Dog.generateDogChar(this.dogChar);
        this.dogTag = generateDogTag();
        this.stillInFacility = true;
    }

    public Dog() {
        this.name = "Unknown";
        this.ownerName = "Unknown";
        this.age = 0;
        this.dogId = 0;
        this.dogChar = Dog.generateDogChar(this.dogChar);
        this.dogTag = generateDogTag();
        this.stillInFacility = true;
    }

    public String getName() {
        return name;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public int getAge() {
        return age;
    }
    public int getDogId() {
        return dogId;
    }

    public char getDogChar() {
        return dogChar;
    }

    public String getDogTag() {
        return dogTag;
    }
    
    public boolean isStillInFacility() {
        return stillInFacility;
    }

    public void setStillInFacility(boolean stillInFacility) {
        this.stillInFacility = stillInFacility;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDogId(int dogId) {
        this.dogId = dogId;
    }

    public void setDogChar(char dogChar) {
        this.dogChar = dogChar;
    }

    public void setDogTag(String dogTag) {
        this.dogTag = dogTag;
    }

    public String toString() {
        if (stillInFacility) {
            return name + " is a good dog. They are " + age + " years old and belong to " + ownerName + ". They are currently in our facility. For employee use only: DogTag is " + dogTag + ".";
        }
        else {
            return name + " is a good dog. They are " + age + " years old and belong to " + ownerName + ". They are currently not in our facility. For employee use only: DogTag is " + dogTag + ".";
        }
    }

    public boolean equals(Dog other) {
        return (this.dogId == other.dogId) && (this.dogChar == other.dogChar) && (this.dogTag.equals(other.dogTag)) && (this.name.equals(other.name)) && (this.ownerName.equals(other.ownerName)) && (this.age == other.age) && (this.stillInFacility == other.stillInFacility);
    }

    public String generateDogTag() {
        return "" + dogId + dogChar;
    }

    public static char generateDogChar(int dogId) {
        int sum = 0;

        while (dogId > 0) {
            sum += dogId % 10;
            dogId /= 10;
        }
        
        return (char) ('F' + (sum % 10));
    }

    public static String pickup(Dog dog, String personName) {
        if (dog.ownerName.equals(personName) && dog.isStillInFacility()) {
            dog.setStillInFacility(false);
            return dog.name + " has been picked up by their owner " + personName + ".";
        }
        else if (!dog.ownerName.equals(personName)) {
            return personName + " is not the owner of " + dog.name + " and cannot pick them up.";
        }
        else {
            return dog.name + " is not currently in the facility.";
        }
    }

    public static void checkIn(Dog dog, String personName) {
        dog.setStillInFacility(true);
        dog.setOwnerName(personName);
    }
}