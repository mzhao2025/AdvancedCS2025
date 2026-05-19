public class PracticeItem {
    protected String title;
    protected int daysUntilDeadline;

    public PracticeItem(String title, int daysUntilDeadline) {
        if (title == null || title.trim().isEmpty()) {
            this.title = "Untitled Piece";
        } else {
            this.title = title;
        }
        
        if (daysUntilDeadline < 0) {
            this.daysUntilDeadline = 0;
        } else {
            this.daysUntilDeadline = daysUntilDeadline;
        }
    }

    public String getTitle() { return title; }
    public int getDaysUntilDeadline() { return daysUntilDeadline; }
    
    public void setDaysUntilDeadline(int daysUntilDeadline) {
        if (daysUntilDeadline >= 0) {
            this.daysUntilDeadline = daysUntilDeadline;
        }
    }
}