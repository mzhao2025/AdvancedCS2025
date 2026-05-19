public class MusicPiece extends PracticeItem {
    public static int totalPiecesCreated = 0;
    public static int totalFamiliarityUpdates = 0;

    private int familiarityScore;

    public MusicPiece(String title, int daysUntilDeadline, int familiarityScore) {
        super(title, daysUntilDeadline);
        setFamiliarityScore(familiarityScore);
        totalPiecesCreated++;
    }

    public int getFamiliarityScore() { return familiarityScore; }
    
    public void setFamiliarityScore(int familiarityScore) { 
        if (familiarityScore < 1) {
            this.familiarityScore = 1;
        } else if (familiarityScore > 10) {
            this.familiarityScore = 10;
        } else {
            this.familiarityScore = familiarityScore; 
        }
    }

    public int calculateUrgencyValue() {
        return ((10 - this.familiarityScore) * 10) + (100 - this.daysUntilDeadline);
    }
}