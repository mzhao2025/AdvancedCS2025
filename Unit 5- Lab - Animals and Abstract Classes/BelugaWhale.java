public class BelugaWhale extends Animal {
    public BelugaWhale(String name, int age, boolean gender, String habitat, String color, String[] diet) {
        super(diet, age, gender, habitat, color, name);
    }

    public void swim() {
        System.out.println(getName() + " is swimming gracefully in the " + getHabitat() + ".");
    }

    public void eat() {
        System.out.println(getName() + " is eating " + String.join(", ", getDiet()) + ".");
    }

    public void dive() {
        System.out.println(getName() + " is diving deep into the ocean.");
    }

    public void communicate() {
        System.out.println(getName() + " is communicating with other beluga whales.");
    }

    public void migrate() {
        System.out.println(getName() + " is migrating to a different habitat.");
    }
}