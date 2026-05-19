import javax.swing.SwingUtilities;

public class ProjectTester {
    public static void main(String[] args) {
        RotationSchedule schedule = new RotationSchedule();
        schedule.addPiece(new MusicPiece("Chopin Polonaise Fantasie", 67, 3));
        schedule.addPiece(new MusicPiece("Rachmaninoff Etude", 30, 7));
        schedule.addPiece(new MusicPiece("Beethoven Sonata No. 1", 45, 8));

        System.out.println("--- BEFORE SORTING ---");
        for (MusicPiece p : schedule.getActivePieces()) {
            System.out.println(p.getTitle() + " | Deadline: " + p.getDaysUntilDeadline() + " days");
        }
        System.out.println("Total Pieces Instantiated: " P+ MusicPiece.totalPiecesCreated);
        System.out.println("-------------------------------------------\n");

        SwingUtilities.invokeLater(() -> {
            PracticeDashboard gui = new PracticeDashboard(schedule);
            gui.setVisible(true);
        });
    }
}