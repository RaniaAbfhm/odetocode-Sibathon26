import java.util.Scanner;
import java.sql.*;

class medicine{
    Scanner input = new Scanner(System.in);

    void takemedinfo() {
        String choice;
        do {
            System.out.print("Enter Medicine Name: ");
            String name = input.nextLine();

            System.out.print("Enter Time you take this medicine: ");
            String time = input.nextLine();

            System.out.println("Name=" + name + ", Time=" + time);

            try {
               
                Class.forName("com.mysql.cj.jdbc.Driver");

               
                Connection myconnection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sibathon",
                    "root",
                    "lote373"
                );

                
                String query = "INSERT INTO medicines(name, time) VALUES(?, ?)";
                PreparedStatement pre = myconnection.prepareStatement(query);

                pre.setString(1, name);
                pre.setString(2, time);

               
                int rows = pre.executeUpdate();
                
                if(rows > 0)
                    System.out.println("Inserted into database successfully!");

                myconnection.close();
                
            } catch(Exception e) {
                
                e.printStackTrace();
            }

            System.out.print("Do you want to enter another Medicine (yes/no): ");
            choice = input.nextLine();

        } while (choice.equalsIgnoreCase("yes"));
    }
    
    void updateMedicineName()
    {
        

    System.out.print("Enter the current medicine name to update: ");
    String oldName = input.nextLine();

    System.out.print("Enter the new medicine name: ");
    String newName = input.nextLine();

    try {
        Connection myconnection = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/sibathon",
            "root",
            "lote373"
        );

        String query = "UPDATE medicines SET name = ? WHERE name = ?";
        PreparedStatement pst = myconnection.prepareStatement(query);
        pst.setString(1, newName);
        pst.setString(2, oldName);

        int rows = pst.executeUpdate();
        if(rows > 0)
            System.out.println("Medicine name updated successfully!");
        else
            System.out.println("No medicine found with that name.");

        myconnection.close();
        }
         catch(Exception e) 
         {
          e.printStackTrace();
         }
    }

    void deleteMedicine()
    {
      
      System.out.println("Delete Medicine Record of Tablet: ");
      String del=input.nextLine();

      try{
        
        Connection myconnection=DriverManager.getConnection
        (
             "jdbc:mysql://localhost:3306/sibathon","root","lote373"

        );

        String del_query= "DELETE FROM medicines WHERE name = ?";

        PreparedStatement ps= myconnection.prepareStatement(del_query);

        ps.setString(1,del);

        
          int rowsDeleted = ps.executeUpdate();

        if(rowsDeleted > 0)
         {
            System.out.println("Deleted " + rowsDeleted + " record(s) successfully!");
         }
        else 
         {
            System.out.println("No medicine found with that name.");
         }

         myconnection.close();

    } 
    catch(Exception e) 
        {
         e.printStackTrace();
        }

    }


    
}
