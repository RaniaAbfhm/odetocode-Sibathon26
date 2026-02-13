public class Notification{
    public void notify(medicine med){
        if(!med.taken){
            System.out.println("Reminder: Take at"+ med.time );
        }
    }
}