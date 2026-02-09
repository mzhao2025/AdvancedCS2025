import java.util.ArrayList;

public class TestResults {
    private ArrayList<String> answerKey;
    private ArrayList<StudentAnswerSheet> submissions;

    public TestResults(ArrayList<String> key, ArrayList<StudentAnswerSheet> submissions) {
        if (key == null || submissions == null) {
            throw new IllegalArgumentException("Answer key and submissions cannot be null.");
        }
        this.answerKey = key;
        this.submissions = submissions;
    }

    public ArrayList<String> getAnswerKey() {
        return answerKey;
    }

    public void setAnswerKey(ArrayList<String> answerKey) {
        this.answerKey = answerKey;
    }

    public ArrayList<StudentAnswerSheet> getSubmissions() {
        return submissions;
    }

    public void setSubmissions(ArrayList<StudentAnswerSheet> submissions) {
        this.submissions = submissions;
    }

    public void submit(StudentAnswerSheet sheet) {
        submissions.add(sheet);
    }

    public void gradeTests() {
        for (StudentAnswerSheet sheet : submissions) {
            double score = sheet.getGrade(answerKey);
            sheet.setTestScore(score);
        }
    }

    public String highestScoringStudent() {
        if (submissions.isEmpty()) {
            return "";
        }
        StudentAnswerSheet topStudent = submissions.get(0);
        for (StudentAnswerSheet sheet : submissions) {
            if (sheet.getTestScore() > topStudent.getTestScore()) {
                topStudent = sheet;
            }
        }
        return topStudent.getName();
    }
}
