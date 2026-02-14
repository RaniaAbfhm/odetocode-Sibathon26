import javax.swing.*;
import java.io.*;

public class MyInterface extends JFrame {

    private JComboBox<String> feverBox, coughBox, fatigueBox, headacheBox, nauseaBox;
    private JButton predictButton;
    private JLabel resultLabel;

    public MyInterface() {
        setTitle("DocMate AI Doctor");
        setSize(400, 400);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[] options = {"0 = No", "1 = Yes"};

        JLabel lbl1 = new JLabel("Fever:");
        lbl1.setBounds(50, 30, 100, 20);
        add(lbl1);
        feverBox = new JComboBox<>(options);
        feverBox.setBounds(150, 30, 200, 25);
        add(feverBox);

        JLabel lbl2 = new JLabel("Cough:");
        lbl2.setBounds(50, 70, 100, 20);
        add(lbl2);
        coughBox = new JComboBox<>(options);
        coughBox.setBounds(150, 70, 200, 25);
        add(coughBox);

        JLabel lbl3 = new JLabel("Fatigue:");
        lbl3.setBounds(50, 110, 100, 20);
        add(lbl3);
        fatigueBox = new JComboBox<>(options);
        fatigueBox.setBounds(150, 110, 200, 25);
        add(fatigueBox);

        JLabel lbl4 = new JLabel("Headache:");
        lbl4.setBounds(50, 150, 100, 20);
        add(lbl4);
        headacheBox = new JComboBox<>(options);
        headacheBox.setBounds(150, 150, 200, 25);
        add(headacheBox);

        JLabel lbl5 = new JLabel("Nausea:");
        lbl5.setBounds(50, 190, 100, 20);
        add(lbl5);
        nauseaBox = new JComboBox<>(options);
        nauseaBox.setBounds(150, 190, 200, 25);
        add(nauseaBox);

        predictButton = new JButton("Predict");
        predictButton.setBounds(50, 230, 300, 30);
        add(predictButton);

        resultLabel = new JLabel("Prediction: ");
        resultLabel.setBounds(50, 270, 300, 30);
        add(resultLabel);

        predictButton.addActionListener(e -> predictButtonActionPerformed());
    } // <-- close constructor

    private void predictButtonActionPerformed() {
        try {
            String s1 = feverBox.getSelectedItem().toString().substring(0,1);
            String s2 = coughBox.getSelectedItem().toString().substring(0,1);
            String s3 = fatigueBox.getSelectedItem().toString().substring(0,1);
            String s4 = headacheBox.getSelectedItem().toString().substring(0,1);
            String s5 = nauseaBox.getSelectedItem().toString().substring(0,1);

            ProcessBuilder pb = new ProcessBuilder(
                "python", "predict.py", s1, s2, s3, s4, s5
            );
            pb.directory(new File("C:\\Users\\Modern Tech\\Desktop\\Docmate"));
            pb.redirectErrorStream(true);

            Process process = pb.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            StringBuilder output = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }
            reader.close();

            int exitCode = process.waitFor();
            if (exitCode == 0 && output.length() > 0) {
                resultLabel.setText("Prediction: " + output.toString().trim());
            } else {
                resultLabel.setText("No prediction received or error occurred.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultLabel.setText("Error predicting disease.");
        }
    } 

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MyInterface().setVisible(true);
        });
    } 

} 
