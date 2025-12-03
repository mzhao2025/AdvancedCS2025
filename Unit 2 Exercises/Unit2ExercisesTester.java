public class Unit2ExercisesTester {
    public static void main(String[] args) {
        // You can add your own test cases here to test the newly implemented methods
        int[] scores1 = {2, 4, 6, 8};
        int[] scores2 = {1, 3, 5, 7};

        System.out.println("Scores Average Test:");
        System.out.println("Expected: 6, Actual: " + Unit2Exercises.scoresAverage(scores1));
        System.out.println("Expected: 5, Actual: " + Unit2Exercises.scoresAverage(scores2));

        System.out.println("\nScores Increasing Test:");
        System.out.println("Expected: true, Actual: " 
            + Unit2Exercises.scoresIncreasing(new int[]{1, 2, 2, 3}));
        System.out.println("Expected: false, Actual: " 
            + Unit2Exercises.scoresIncreasing(new int[]{3, 2, 1}));

        System.out.println("\nFirst Two Test:");
        System.out.println("Expected: 'He', Actual: '" + Unit2Exercises.firstTwo("Hello") + "'");
        System.out.println("Expected: 'A*', Actual: '" + Unit2Exercises.firstTwo("A") + "'");
        System.out.println("Expected: '**', Actual: '" + Unit2Exercises.firstTwo("") + "'");

        System.out.println("\nDivide Test:");
        System.out.println("Expected: 2.0, Actual: " + Unit2Exercises.divide(6, 3));
        System.out.println("Expected: 0.0, Actual: " + Unit2Exercises.divide(5, 0));
    }
}
