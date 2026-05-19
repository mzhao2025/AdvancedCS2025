import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class PracticeDashboard extends JFrame {
    private ArrayList<RotationSchedule> savedRoutines;
    private DefaultListModel<MusicPiece> listModel;
    private JList<MusicPiece> uiList;
    private JLabel recommendationLabel;
    private JLabel statsLabel;
    
    private JTextField titleField;
    private JTextField deadlineField;
    private JTextField familiarityField;

    public PracticeDashboard(RotationSchedule initialSchedule) {
        savedRoutines = new ArrayList<>();
        savedRoutines.add(initialSchedule);

        setTitle("Music Practice Rotations");
        setSize(650, 580);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(15, 15));

        JPanel addPanel = new JPanel(new GridLayout(2, 4, 10, 8));
        addPanel.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
        
        titleField = new JTextField();
        deadlineField = new JTextField();
        familiarityField = new JTextField();
        JButton addBtn = new JButton("Add Piece");

        addPanel.add(new JLabel("Title:", SwingConstants.RIGHT));
        addPanel.add(titleField);
        addPanel.add(new JLabel("Days to Deadline:", SwingConstants.RIGHT));
        addPanel.add(deadlineField);
        addPanel.add(new JLabel("Familiarity (1-10):", SwingConstants.RIGHT));
        addPanel.add(familiarityField);
        addPanel.add(new JLabel("")); 
        addPanel.add(addBtn);

        listModel = new DefaultListModel<>();
        uiList = new JList<>(listModel);
        uiList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        uiList.setSelectionBackground(new Color(235, 235, 235));
        
        uiList.setCellRenderer(new PieceCellRenderer());

        JScrollPane scrollPane = new JScrollPane(uiList);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Current Practice Priority Queue"));

        recommendationLabel = new JLabel("Top Recommendation: None", SwingConstants.CENTER);
        recommendationLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        recommendationLabel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
        recommendationLabel.setPreferredSize(new Dimension(0, 35));

        statsLabel = new JLabel("Total Pieces: 0 | Total Updates: 0", SwingConstants.CENTER);
        statsLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
        statsLabel.setForeground(Color.GRAY);
        statsLabel.setPreferredSize(new Dimension(0, 25));
        
        JButton increaseFamButton = new JButton("★ Familiarity (+1) ★");
        increaseFamButton.setFont(new Font("SansSerif", Font.BOLD, 13));
        increaseFamButton.setPreferredSize(new Dimension(0, 45));

        JPanel infoPanel = new JPanel(new GridLayout(2, 1, 5, 5));
        infoPanel.add(recommendationLabel);
        infoPanel.add(statsLabel);

        JPanel bottomPanel = new JPanel(new BorderLayout(10, 10));
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(0, 15, 15, 15));
        bottomPanel.add(increaseFamButton, BorderLayout.NORTH);
        bottomPanel.add(infoPanel, BorderLayout.SOUTH);

        add(addPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        updateUIList(initialSchedule);

        addBtn.addActionListener(e -> {
            try {
                String title = titleField.getText().trim();
                String deadlineText = deadlineField.getText().trim();
                String familiarityText = familiarityField.getText().trim();

                if (title.isEmpty() || deadlineText.isEmpty() || familiarityText.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Input Warning", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                int deadline = Integer.parseInt(deadlineText);
                int familiarity = Integer.parseInt(familiarityField.getText().trim());

                if (deadline < 0 || familiarity < 1 || familiarity > 10) {
                    JOptionPane.showMessageDialog(this, "Deadline must be greater than 0 and Familiarity must be between 1 and 10.", "Validation Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                initialSchedule.addPiece(new MusicPiece(title, deadline, familiarity));
                updateUIList(initialSchedule);

                titleField.setText("");
                deadlineField.setText("");
                familiarityField.setText("");

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Numeric input fields must contain whole integer values.", "Format Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        increaseFamButton.addActionListener(e -> {
            int selectedIdx = uiList.getSelectedIndex();
            if (selectedIdx != -1) {
                MusicPiece selectedPiece = initialSchedule.getActivePieces().get(selectedIdx);
                int currentScore = selectedPiece.getFamiliarityScore();
                
                selectedPiece.setFamiliarityScore(currentScore + 1);
                MusicPiece.totalFamiliarityUpdates++;
                
                updateUIList(initialSchedule);
                
                int newIdx = initialSchedule.getActivePieces().indexOf(selectedPiece);
                if (newIdx != -1) {
                    uiList.setSelectedIndex(newIdx);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please highlight a choice from the queue first.", "Selection Required", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    private void updateUIList(RotationSchedule schedule) {
        System.out.println("--- BEFORE SORTING ---");
        ArrayList<MusicPiece> beforePieces = schedule.getActivePieces();
        for (int i = 0; i < beforePieces.size(); i++) {
            MusicPiece p = beforePieces.get(i);
            System.out.println(p.getTitle() + " | Familiarity: " + p.getFamiliarityScore() + " | Deadline: " + p.getDaysUntilDeadline() + " | Priority: " + p.calculateUrgencyValue());
        }

        schedule.sortPiecesByPriority();

        System.out.println("\n--- AFTER SORTING ---");
        ArrayList<MusicPiece> pieces = schedule.getActivePieces();
        for (int i = 0; i < pieces.size(); i++) {
            MusicPiece p = pieces.get(i);
            System.out.println(p.getTitle() + " | Familiarity: " + p.getFamiliarityScore() + " | Deadline: " + p.getDaysUntilDeadline() + " | Priority: " + p.calculateUrgencyValue());
        }

        listModel.clear();
        for (MusicPiece p : pieces) {
            listModel.addElement(p);
        }
        
        if (!pieces.isEmpty()) {
            MusicPiece topSelection = pieces.get(0);
            recommendationLabel.setText("Today's Highest Priority Choice: " + topSelection.getTitle());
        } else {
            recommendationLabel.setText("Today's Highest Priority Choice: None");
        }

        statsLabel.setText("Total Pieces Created: " + MusicPiece.totalPiecesCreated + "  |  Total Familiarity Clicks: " + MusicPiece.totalFamiliarityUpdates);
    }

    public ArrayList<RotationSchedule> getSavedRoutines() { return savedRoutines; }

    private class PieceCellRenderer extends JPanel implements ListCellRenderer<MusicPiece> {
        private JLabel titleLabel = new JLabel();
        private JLabel deadlineLabel = new JLabel();
        private JLabel familiarityLabel = new JLabel();
        private JLabel priorityLabel = new JLabel();

        public PieceCellRenderer() {
            setLayout(new BorderLayout());
            setBorder(BorderFactory.createEmptyBorder(6, 10, 6, 10));

            JPanel leftPanel = new JPanel(new GridLayout(2, 1, 0, 2));
            JPanel rightPanel = new JPanel(new GridLayout(2, 1, 0, 2));
            
            leftPanel.setOpaque(false);
            rightPanel.setOpaque(false);

            titleLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
            deadlineLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
            
            familiarityLabel.setFont(new Font("Monospaced", Font.PLAIN, 13));
            familiarityLabel.setHorizontalAlignment(SwingConstants.RIGHT);
            
            priorityLabel.setFont(new Font("Monospaced", Font.PLAIN, 13));
            priorityLabel.setHorizontalAlignment(SwingConstants.RIGHT);

            leftPanel.add(titleLabel);
            leftPanel.add(deadlineLabel);

            rightPanel.add(familiarityLabel);
            rightPanel.add(priorityLabel);

            add(leftPanel, BorderLayout.WEST);
            add(rightPanel, BorderLayout.EAST);
        }

        @Override
        public Component getListCellRendererComponent(JList<? extends MusicPiece> list, MusicPiece p, int index, boolean isSelected, boolean cellHasFocus) {
            titleLabel.setText(p.getTitle());
            deadlineLabel.setText("Deadline: " + p.getDaysUntilDeadline() + " days");

            int fam = p.getFamiliarityScore();
            String progressBar = "[";
            for (int b = 1; b <= 10; b++) {
                if (b <= fam) {
                    progressBar += "█";
                } else {
                    progressBar += " ";
                }
            }
            progressBar += "]";
            
            familiarityLabel.setText("Familiarity: " + progressBar);
            priorityLabel.setText("Priority: (" + p.calculateUrgencyValue() + ")");

            Color rowColor;
            if (index == 0) {
                rowColor = Color.RED;
            } else if (index == 1) {
                rowColor = Color.ORANGE;
            } else if (index == 2) {
                rowColor = new Color(179, 146, 0);
            } else if (index == 3) {
                rowColor = new Color(30, 120, 40);
            } else {
                rowColor = Color.BLUE;
            }

            titleLabel.setForeground(rowColor);
            deadlineLabel.setForeground(rowColor);
            familiarityLabel.setForeground(rowColor);
            priorityLabel.setForeground(rowColor);

            if (isSelected) {
                setBackground(list.getSelectionBackground());
            } else {
                setBackground(list.getBackground());
            }

            return this;
        }
    }
}