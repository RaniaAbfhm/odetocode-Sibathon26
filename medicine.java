import java.util.Scanner;

class medicine {
    public String name;
    public String time;
    public boolean taken;

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
    String gettime(){
        return time;
    }
}