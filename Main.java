public class Main{
    public static void main(String[] args){
        medicine med= new medicine("Paracetamol","8:00");
        med.takemedinfo();
        Notification reminder=new Notification();
        reminder.notify(med);
    }
}