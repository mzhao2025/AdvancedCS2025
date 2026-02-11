public class Ocelot {
    private String name;
    private int age;
    private boolean gender;
    private String habitat;
    private String diet;
    private boolean speed;

    public Ocelot(String name, int age, boolean gender, String habitat, String diet, boolean speed) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.habitat = habitat;
        this.diet = diet;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public String getDiet() {
        return diet;
    }

    public void setDiet(String diet) {
        this.diet = diet;
    }

    public boolean isSpeed() {
        return speed;
    }

    public void setSpeed(boolean speed) {
        this.speed = speed;
    }

    public void hunt() {
        System.out.println(name + " is hunting.");
    }

    public void climb() {
        System.out.println(name + " is climbing a tree.");
    }

    public void stalk() {
        System.out.println(name + " is stalking its prey.");
    }

    public String toString() {
        return "Ocelot{name='" + name + "', age=" + age
                + ", gender=" + gender + ", habitat='" + habitat
                + "', diet='" + diet + "', speed=" + speed + "}";
    }
}