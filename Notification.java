import java.sql.*;
import java.time.LocalTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MedicineReminder {
    static boolean triggered = false;
    
    public static void main(String[] args) {
        // Test connection first
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/sibathon",
                "root",
                "lote373"
            );
            System.out.println("Connected to database!");
            conn.close();
        } catch (Exception e) {
            System.out.println("Connection failed: " + e.getMessage());
            return;
        }
        
        // Start checking for reminders
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        
        scheduler.scheduleAtFixedRate(() -> {
            LocalTime now = LocalTime.now();
            int currentHour = now.getHour();
            int currentMinute = now.getMinute();
            
            try {
                Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sibathon",
                    "root",
                    "lote373"
                );
                
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT name, time FROM medicine");
                
                while (rs.next()) {
                    String medicineName = rs.getString("name");
                    String medicineTime = rs.getString("time");
                    
                    String[] timeParts = medicineTime.split(":");
                    int medHour = Integer.parseInt(timeParts[0]);
                    int medMinute = Integer.parseInt(timeParts[1]);
                    
                    if (currentHour == medHour && currentMinute == medMinute && !triggered) {
                        sendNotification("Medicine Alert", "Time to take: " + medicineName);
                        triggered = true;
                        System.out.println("Reminder sent for: " + medicineName);
                    } else if (currentMinute != medMinute) {
                        triggered = false;
                    }
                }
                
                rs.close();
                stmt.close();
                conn.close();
                
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }, 0, 30, TimeUnit.SECONDS);
        
        System.out.println("Medicine reminder running...");
    }
    
    public static void sendNotification(String title, String message) {
        try {
            String command = "wscript notify.vbs \"" + title + "\" \"" + message + "\"";
            Runtime.getRuntime().exec(command);
        } catch (Exception e) {
            System.out.println("Notification failed: " + e.getMessage());
        }
    }
}
