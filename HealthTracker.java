import java.util.Scanner;
import java.sql.*;
import java.time.LocalDate;

class HealthTracker {

    Scanner input = new Scanner(System.in);
    int sleepHours, exercise_minutes, water_intake;

    void addHealthInfo() {

        System.out.print("Enter Sleep Hours: ");
         sleepHours = input.nextInt();

         System.out.print("Enter time of Exercise (minutes): ");
         exercise_minutes = input.nextInt();

         System.out.print("Enter intake of Water Glasses: ");
         water_intake = input.nextInt();

          input.nextLine();   

        LocalDate today = LocalDate.now();

        try {

            Connection myconnection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/sibathon",
                "root",
                "#GreatZara1"
            );

            String query_command = "INSERT INTO healthtracker(sleepHours, exercise_minutes, water_intake, date_entery) VALUES(?,?,?,?)";

            PreparedStatement preparing = myconnection.prepareStatement(query_command);

            preparing.setInt(1, sleepHours);
            preparing.setInt(2, exercise_minutes);
            preparing.setInt(3, water_intake);
            preparing.setDate(4, Date.valueOf(today));

            int row_entered = preparing.executeUpdate();

            if(row_entered > 0)
                System.out.println("Health Info Stored Successfully!");

            myconnection.close();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

       void displayHealthRecord() 
       {
         System.out.println("Sleep Hours : "+ sleepHours);

         System.out.println("time of Exercise (minutes): "+ exercise_minutes);

         System.out.println("Enter intake of Water Glasses:" + water_intake);

          

       }


    
}
