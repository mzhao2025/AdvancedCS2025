public class StudentTester {
    public static void main(String[] args) {
        Student student1 = new Student("Alice", 12);
        Student student2 = new Student("Bob", 10);
        Student student3 = new Student("Calvin", 12);
        Student student4 = new Student("Dennis", 10);

        System.out.println(student1.toString());
        System.out.println(student2.toString());
        System.out.println(student3.toString());
        System.out.println(student4.toString());

        student1.setGrade(13);
        student1.setGrade(11);
        student1.setGrade(13);
        student1.setGrade(11);

        System.out.println(student1.toString());
        System.out.println(student2.toString());
        System.out.println(student3.toString());
        System.out.println(student4.toString());

        System.out.println(student1.equals(student2));
    }
}
