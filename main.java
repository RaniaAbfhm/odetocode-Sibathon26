import java.util.Scanner;

class main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        medicine temp = new medicine();
        HealthTracker info = new HealthTracker();
        String req;
        do {
            System.out.print("Do you want to enter new medicine? (yes/no): ");
            req = input.nextLine();
            if(req.equalsIgnoreCase("yes")) {
                temp.takemedinfo();
            }
        } while(req.equalsIgnoreCase("yes"));

      
        String ask;
        do {
            System.out.print("Do you want to update any medicine schedule? (yes/no): ");
            ask = input.nextLine();
            if(ask.equalsIgnoreCase("yes")) {
                temp.updateMedicineName();
            }
        } while(ask.equalsIgnoreCase("yes"));

      
        String del;
        do {
            System.out.print("Do you want to delete medicine? (yes/no): ");
            del = input.nextLine();
            if(del.equalsIgnoreCase("yes")) {
                temp.deleteMedicine();
            }
        } while(del.equalsIgnoreCase("yes"));

        
        String check;
        do {
            System.out.print("Do you want to add health info? (yes/no): ");
            check = input.nextLine();
            if(check.equalsIgnoreCase("yes")) {
                info.addHealthInfo();
            }
        } while(check.equalsIgnoreCase("yes"));

      
        String see;
        do {
            System.out.print("Do you want to see your health record? (yes/no): ");
            see = input.nextLine();
            if(see.equalsIgnoreCase("yes")) {
                info.displayHealthRecord();
            }
        } while(see.equalsIgnoreCase("yes"));
    }
}
