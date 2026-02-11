public abstract class Animal {
    private String[] diet;
    private int age;
    private boolean gender;
    private String habitat;
    private String color;
    private String name;

    public Animal(String[] diet, int age, boolean gender, String habitat, String color, String name) {
        this.diet = diet;
        this.age = age;
        this.gender = gender;
        this.habitat = habitat;
        this.color = color;
        this.name = name;
    }

    public String[] getDiet() {
        return diet;
    }

    public void setDiet(String[] diet) {
        this.diet = diet;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void eat(String food) {
        if (food == null || food.isEmpty()) {
            System.out.println(name + " has nothing to eat.");
            return;
        }
        if (!String.join(", ", diet).contains(food)) {
            System.out.println(name + " cannot eat " + food + " because it's not in the diet.");
            return;
        }
        System.out.println(name + " is eating " + food);
        return;
    }

    public void swim(int time) {
        if (time <= 0) {
            System.out.println(name + " cannot swim for a non-positive amount of time.");
            return;
        }
        System.out.println(name + " is swimming for " + time + " minutes.");
        return;
    }

    public String toString() {
        return "Animal {" +
                "diet =" + String.join(", ", diet) +
                ", age =" + age +
                ", gender =" + (gender ? "Male" : "Female") +
                ", habitat ='" + habitat + '\'' +
                ", color ='" + color + '\'' +
                ", name ='" + name + '\'' +
                '}';
    }
}