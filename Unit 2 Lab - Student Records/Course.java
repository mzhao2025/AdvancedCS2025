public class Course {
    private String courseName;
    private StudentRecord[] studentRecords;

    public Course(String courseName, StudentRecord[] studentRecords) {
        this.courseName = courseName;
        this.studentRecords = studentRecords;
    }

    public Course(String courseName, int maxEnrollment) {
        this.courseName = courseName;
        this.studentRecords = new StudentRecord[maxEnrollment];
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public StudentRecord[] getEnrolledStudents() {
        return studentRecords;
    }

    public void setEnrolledStudents(StudentRecord[] studentRecords) {
        this.studentRecords = studentRecords;
    }

    public String toString() {
        String line1 = "== " + courseName + " ==\n";
        String studentRecords = "";
        for (int i = 1; i <= this.studentRecords.length; i++) {
            studentRecords += Integer.toString(i) + ".) "
                    + this.studentRecords[i - 1].toString() + "\n";
        }
        return line1 + studentRecords;
    }

    public String findBestStudent() {
        int bestIndex = 0;
        for (int i = 0; i < studentRecords.length; i++) {
            if (studentRecords[i].getFinalAverage() > studentRecords[bestIndex].getFinalAverage()) {
                bestIndex = i;
            }
        }
        return studentRecords[bestIndex].getName();
    }

    public double calculateTestAverage(int testNumber) {
        double total = 0.0;
        for (int i = 0; i < studentRecords.length; i++) {
            total += studentRecords[i].getTestScore(testNumber);
        }
        return total / studentRecords.length;
    }

    public boolean isFull() {
        for (int i = 0; i < studentRecords.length; i++) {
            if (studentRecords[i] == null) {
                return false;
            }
        }
        return true;
    }

    public void enrollStudent(StudentRecord newStudent) {
        for (int i = 0; i < studentRecords.length; i++) {
            if (studentRecords[i] == null) {
                studentRecords[i] = newStudent;
                return;
            }
        }
    }

    public boolean dropStudent(StudentRecord student) {
        for (int i = 0; i < studentRecords.length; i++) {
            if (studentRecords[i] != null
                    && studentRecords[i].getName().equals(student.getName())) {
                studentRecords[i] = null;
                return true;
            }
        }
        return false;
    }

    public int countEnrolledStudents() {
        int count = 0;
        for (int i = 0; i < studentRecords.length; i++) {
            if (studentRecords[i] != null) {
                count++;
            }
        }
        return count;
    }

    public void increaseClassSizeBy(int sizeIncrease) {
        StudentRecord[] newStudentRecords = new StudentRecord[studentRecords.length + sizeIncrease];
        for (int i = 0; i < studentRecords.length; i++) {
            newStudentRecords[i] = studentRecords[i];
        }
        studentRecords = newStudentRecords;
    }
}
