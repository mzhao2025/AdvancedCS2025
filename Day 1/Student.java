public class Student {
    private int age;
    private String name;
    private double gpa;
    private boolean honorRoll;

    public Student(String name, int age, double gpa, boolean honorRoll) {
        this.age = age;
        this.name = name;
        this.gpa = gpa;
        this.honorRoll = honorRoll;
    }
    public double study(int hours) {
        gpa += hours/100;
        return gpa;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }
}
