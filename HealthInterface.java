import javax.swing.*;
import java.io.*;

public class HealthInterface extends JFrame {

    JTextField waterField, sleepField, exerciseField;
    JLabel resultLabel;

    public HealthInterface() {
        setTitle("DocMate Health Tracker");
        setSize(400, 300);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel l1 = new JLabel("Water (liters):");
        l1.setBounds(30, 30, 120, 25);
        add(l1);

        waterField = new JTextField();
        waterField.setBounds(160, 30, 150, 25);
        add(waterField);

        JLabel l2 = new JLabel("Sleep (hours):");
        l2.setBounds(30, 70, 120, 25);
        add(l2);

        sleepField = new JTextField();
        sleepField.setBounds(160, 70, 150, 25);
        add(sleepField);

        JLabel l3 = new JLabel("Exercise (min):");
        l3.setBounds(30, 110, 120, 25);
        add(l3);

        exerciseField = new JTextField();
        exerciseField.setBounds(160, 110, 150, 25);
        add(exerciseField);

        JButton predictBtn = new JButton("Check Health");
        predictBtn.setBounds(30, 150, 280, 30);
        add(predictBtn);

        resultLabel = new JLabel("Health Status:");
        resultLabel.setBounds(30, 190, 300, 25);
        add(resultLabel);

        predictBtn.addActionListener(e -> predictHealth());
    }

    private void predictHealth() {
    try {
        String scriptPath = "C:\\Users\\Modern Tech\\Desktop\\Docmate\\prediction_file.py";

        ProcessBuilder pb = new ProcessBuilder(
            "python", scriptPath,
            waterField.getText(),
            sleepField.getText(),
            exerciseField.getText()
        );

        pb.redirectErrorStream(true);
        Process p = pb.start();

        BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
        StringBuilder output = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            output.append(line);
        }

        p.waitFor();

        resultLabel.setText("Health Status: " + output.toString().trim());

    } catch (Exception ex) {
        resultLabel.setText("Error predicting health: " + ex.getMessage());
    }
}
    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->
            new HealthInterface().setVisible(true)
        );
    }
}