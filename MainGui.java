import javax.swing.*;
import java.awt.*;

public class MainGui {
    MainGui() {
        // Create main frame
        JFrame frame = new JFrame("DocMate Bot");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        // Header panel
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(60, 120, 180));
        JLabel headerLabel = new JLabel("DocMate Bot");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 32));
        headerLabel.setForeground(Color.WHITE);
        headerPanel.add(headerLabel);

        // Button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.setLayout(new GridLayout(1, 3, 40, 40));

        JButton diseasePredictorButton = new JButton("Disease Predictor");
        JButton healthTrackerButton = new JButton("Health Tracker");
        JButton medicineTrackerButton = new JButton("Medicine Tracker");

        Font buttonFont = new Font("SansSerif", Font.BOLD, 16);
        diseasePredictorButton.setFont(buttonFont);
        healthTrackerButton.setFont(buttonFont);
        medicineTrackerButton.setFont(buttonFont);

        diseasePredictorButton.setBackground(new Color(135, 206, 250));
        healthTrackerButton.setBackground(new Color(152, 251, 152));
        medicineTrackerButton.setBackground(new Color(255, 182, 193));

        // Add buttons to panel
        buttonPanel.add(diseasePredictorButton);
        buttonPanel.add(healthTrackerButton);
        buttonPanel.add(medicineTrackerButton);

        // Add panels to frame
        frame.add(headerPanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);

        // Action for Disease Predictor button
        diseasePredictorButton.addActionListener(e -> {
            SwingUtilities.invokeLater(() -> {
                new MyInterface().setVisible(true);  // Launch Disease Predictor
            });
        });

        // Action for Health Tracker button
        healthTrackerButton.addActionListener(e -> {
            SwingUtilities.invokeLater(() -> {
                new HealthInterface().setVisible(true);  // Launch Health Tracker
            });
        });

        // Action for Medicine Tracker button (placeholder for now)
        medicineTrackerButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame,
                "Medicine Tracker is under development.",
                "Coming Soon",
                JOptionPane.INFORMATION_MESSAGE);
        });

        // Make frame visible
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new MainGui();
    }
}
