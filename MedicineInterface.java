import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MedicineInterface extends JFrame {
    // creating medicine class obj
    medicine temp = new medicine();
    HealthTracker info = new HealthTracker();
    Notification rem = new Notification();

    private JTextField nameField, scheduleField;
    private JTextArea outputArea;

    public MedicineInterface() {
        setTitle("DocMate Medicine Manager");
        setSize(500, 400);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel l1 = new JLabel("Medicine Name:");
        l1.setBounds(30, 30, 120, 25);
        add(l1);

        nameField = new JTextField();
        nameField.setBounds(160, 30, 200, 25);
        add(nameField);

        JLabel l2 = new JLabel("Schedule:");
        l2.setBounds(30, 70, 120, 25);
        add(l2);

        scheduleField = new JTextField();
        scheduleField.setBounds(160, 70, 200, 25);
        add(scheduleField);

        JButton addBtn = new JButton("Add Medicine");
        addBtn.setBounds(30, 110, 330, 30);
        add(addBtn);

        JButton updateBtn = new JButton("Update Medicine");
        updateBtn.setBounds(30, 150, 330, 30);
        add(updateBtn);

        JButton deleteBtn = new JButton("Delete Medicine");
        deleteBtn.setBounds(30, 190, 330, 30);
        add(deleteBtn);

        JButton listBtn = new JButton("Show Medicines");
        listBtn.setBounds(30, 230, 330, 30);
        add(listBtn);

        outputArea = new JTextArea();
        outputArea.setBounds(30, 270, 400, 80);
        add(outputArea);

        // Actions
        addBtn.addActionListener(e -> addMedicine());
        updateBtn.addActionListener(e -> updateMedicine());
        deleteBtn.addActionListener(e -> deleteMedicine());
        listBtn.addActionListener(e -> listMedicines());
    }

    private void addMedicine() {
        String name = nameField.getText();
        String schedule = scheduleField.getText();

        if (temp.addMedicine(name, schedule)) {
            outputArea.setText("Added: " + name + " - " + schedule);
        } else {
            outputArea.setText("Failed to add medicine.");
        }
    }

    private void updateMedicine() {
        String oldName = JOptionPane.showInputDialog(this, "Enter current medicine name:");
        String newName = nameField.getText();
        String newTime = scheduleField.getText();

        if (temp.updateMedicine(oldName, newName, newTime)) {
            outputArea.setText("Updated: " + oldName + " → " + newName + " - " + newTime);
        } else {
            outputArea.setText("Update failed.");
        }
    }

    private void deleteMedicine() {
        String name = JOptionPane.showInputDialog(this, "Enter medicine name to delete:");
        if (temp.deleteMedicine(name)) {
            outputArea.setText("Deleted: " + name);
        } else {
            outputArea.setText("Delete failed.");
        }
    }

    private void listMedicines() {
        List<String> meds = temp.listMedicines();
        StringBuilder sb = new StringBuilder("Medicines:\n");
        for (String m : meds) {
            sb.append(m).append("\n");
        }
        outputArea.setText(sb.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MedicineInterface().setVisible(true));
        // Notification call
        Notification rem = new Notification();
        rem.sendnot();
    }
}
