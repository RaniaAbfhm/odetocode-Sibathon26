import java.util.Scanner;
import java.sql.*;

        String url = "jdbc:mysql://localhost:3306/sibathon";
        String user = "root";
        String password = "#GreatZara1";

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to MySQL!");
        } 
        catch (Exception e) {
            System.out.println(e);
        }

class medicine {
    String name;
    String time;
    boolean taken;

    Scanner input = new Scanner(System.in);

    medicine(String name, String time) {
        this.name = name;
        this.time = time;
        this.taken = false; // default
    }

    void takemedinfo() {
        String choice;
        do {
            System.out.print("Enter Medicine Name: ");
            String name = input.nextLine();
            System.out.print("Enter Time you take this medicine: ");
            String time = input.nextLine();

            medicine med = new medicine(name, time);

            System.out.println("Medicine: " + med.name + ", Time: " + med.time);

            System.out.print("Do you want to enter another Medicine (yes/no): ");
            choice = input.nextLine();

        } while (choice.equalsIgnoreCase("yes"));
    }

    public static void main(String[] args) {
        // Create a temporary Medicine object to call the instance method
        medicine temp = new medicine("", "");
        temp.takemedinfo();
    }
}
