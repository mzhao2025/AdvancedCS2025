import java.util.ArrayList;

public class RotationSchedule {
    private ArrayList<MusicPiece> activePieces;

    public RotationSchedule() {
        this.activePieces = new ArrayList<>();
    }

    public void addPiece(MusicPiece piece) {
        if (piece != null) {
            activePieces.add(piece);
        }
    }

    public void sortPiecesByPriority() { // selection sort
        for (int i = 0; i < activePieces.size() - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < activePieces.size(); j++) { // checking to the right on each pass
                if (activePieces.get(j).calculateUrgencyValue() > activePieces.get(maxIndex).calculateUrgencyValue()) {
                    maxIndex = j;
                }
            }
            MusicPiece temp = activePieces.get(i); // swapping indexes
            activePieces.set(i, activePieces.get(maxIndex));
            activePieces.set(maxIndex, temp);
        }
    }

    public ArrayList<MusicPiece> getActivePieces() { return activePieces; }
}