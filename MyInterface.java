import javax.swing.*;
import java.awt.*;

public class MyInterface extends JFrame {

 MyInterface() {
        setTitle("Your DocMate");
        setSize(500, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       
        JPanel header = new JPanel(new BorderLayout());
        header.setPreferredSize(new Dimension(500, 80));
        header.setBackground(new Color(7, 94, 84));

        JLabel title = new JLabel("Your DocMate", JLabel.CENTER);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("SANS_SERIF", Font.BOLD, 28));
        header.add(title, BorderLayout.CENTER);

        JLabel status = new JLabel("Status: Active");
        status.setForeground(Color.LIGHT_GRAY);
        status.setFont(new Font("SANS_SERIF", Font.PLAIN, 14));
        header.add(status, BorderLayout.SOUTH);

        add(header, BorderLayout.NORTH);

  
        JTextArea logArea = new JTextArea();
        logArea.setEditable(false);
        logArea.setFont(new Font("MONOSPACED", Font.PLAIN, 14));
        logArea.setLineWrap(true);
        logArea.setWrapStyleWord(true);

        JScrollPane scroll = new JScrollPane(logArea);
        add(scroll, BorderLayout.CENTER);


        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JTextField text1 = new JTextField();
        text1.setFont(new Font("SANS_SERIF", Font.PLAIN, 16));
        inputPanel.add(text1, BorderLayout.CENTER);

        JButton send = new JButton("Send");
        send.setFont(new Font("SANS_SERIF", Font.BOLD, 16));
        send.setBackground(new Color(7, 94, 84));
        send.setForeground(Color.WHITE);
        inputPanel.add(send, BorderLayout.EAST);

        add(inputPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        new MyInterface();
    }
}
