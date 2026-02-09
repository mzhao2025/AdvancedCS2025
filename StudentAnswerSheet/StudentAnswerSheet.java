import java.util.ArrayList;

public class StudentAnswerSheet {
    private String name;
    private double testScore;
    ArrayList<String> answers;

    public StudentAnswerSheet(String name, ArrayList<String> answers) {
        this.name = name;
        this.answers = answers;
        this.testScore = 0.0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTestScore() {
        return testScore;
    }

    public void setTestScore(double testScore) {
        this.testScore = testScore;
    }

    public ArrayList<String> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<String> answers) {
        this.answers = answers;
    }

    public double getGrade(ArrayList<String> key) {
        if (key == null || key.size() != answers.size()) {
            throw new IllegalArgumentException("Answer key is invalid or does not match the number of answers.");
        }
        if (answers == null || answers.size() == 0) {
            return 0.0;
        }

        for (int i = 0; i < key.size(); i++) {
            String correctAnswer = key.get(i);
            String studentAnswer = answers.get(i);

            if (studentAnswer.equals(correctAnswer)) {
                testScore += 1.0;
            } else if (studentAnswer.equals("?")) {
                // Omitted answer, do nothing
            } else {
                testScore -= 0.25;
            }
        }
        return testScore;
    }
}
