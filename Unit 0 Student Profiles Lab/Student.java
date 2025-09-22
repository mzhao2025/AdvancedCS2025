public class Student {
    private String name;
    private String id;
    private int grade;
    private String latestOpp;
    private String recentFriend;

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
        this.id = generateId();
    }

    public Student(String name) {
        this.name = name;
        this.grade = 10;
        this.id = generateId();
    }

    public String vibeCheck(Student other) {
        if (this.latestOpp != null && this.latestOpp.equals(other.latestOpp)) {
            this.setRecentFriend(other.name);
            other.setRecentFriend(this.name);
            return this.name + " and " + other.name 
                + " are now friends; they both dislike " + this.latestOpp + ".";
        } 
        return this.name + " and " + other.name + " are not friends.";
    }

    public String generateId() {
        String id = "";

        for (int i = 0; i < 3; i++) {
            id += (int) (Math.random() * 8) + 1;
        }

        id += "-";
    
        for (int i = 0; i < 4; i++) {
            id += (int) (Math.random() * 10);
        }

        return id;
    }

    public String getLatestOpp() {
        return latestOpp;
    }

    public String getRecentFriend() {
        return recentFriend;
    }

    public void setLatestOpp(String latestOpp) {
        this.latestOpp = latestOpp;
    }

    public void setRecentFriend(String recentFriend) {
        this.recentFriend = recentFriend;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public int getGrade() {
        return grade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String toString() {
        return name + " is a " + grade + "th grader. Their id is " + id;
    }

    public boolean equals(Student other) {
        return this.id.equals(other.id) 
            && this.name.equals(other.name) 
            && this.grade == other.grade;
    }
}