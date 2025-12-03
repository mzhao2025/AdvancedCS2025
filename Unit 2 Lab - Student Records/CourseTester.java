public class CourseTester {
    public static void main(String[] args) {

        // Create sample student Ana with scores
        int[] anaScores = {90, 89, 91, 95};
        StudentRecord ana = new StudentRecord("Ana", anaScores);

        // 1. Test toString()
        System.out.println("1. toString() test:");
        System.out.println(ana.toString().equals("Ana's scores: [90, 89, 91, 95]"));

        // 2. Test getAverage(first, last)
        System.out.println("2. getAverage() test:");
        System.out.println(ana.getAverage(0, 3) == 91.25);

        // 3. Test getTestScore()
        System.out.println("3. getTestScore() test:");
        System.out.println(ana.getTestScore(1) == 89);


        // --- Optional: test Course class too ---

        StudentRecord bob = new StudentRecord("Bob", new int[] {70, 80, 85, 90});
        StudentRecord carl = new StudentRecord("Carl", new int[] {95, 94, 96, 97});

        StudentRecord[] records = {ana, bob, carl};
        Course cs = new Course("AP CS", records);

        System.out.println("\nCourse toString():");
        System.out.println(cs.toString());

        System.out.println("Best student:");
        System.out.println(cs.findBestStudent());

        System.out.println("Average of test 1:");
        System.out.println(cs.calculateTestAverage(1));
    }
}