public class Platypus {
    private String name;
    private int age;
    private boolean gender;
    private String habitat;
    private String diet;
    private boolean isVenomous;

    public Platypus(String name, int age, boolean gender, String habitat, String diet, boolean isVenomous) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.habitat = habitat;
        this.diet = diet;
        this.isVenomous = isVenomous;
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

    public boolean isVenomous() {
        return isVenomous;
    }

    public void setVenomous(boolean isVenomous) {
        this.isVenomous = isVenomous;
    }

    public void searchForPrey() {
        System.out.println(name + " is searching for prey in the water.");
    }

    public void hunt() {
        System.out.println(name + " is hunting for food.");
    }

    public String toString() {
        return "Platypus{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + (gender ? "male" : "female") +
                ", habitat='" + habitat + '\'' +
                ", diet='" + diet + '\'' +
                ", isVenomous=" + isVenomous +
                '}';
    }

}