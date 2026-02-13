// Scheduling
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

// Date/Time
import java.time.LocalTime;
import java.time.LocalDate;

// Collections
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

// System Tray Notifications
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.AWTException;
import java.awt.PopupMenu;
import java.awt.MenuItem;
public class Notification{
    public void notify(medicine med){
        if(!med.taken){
            System.out.println("Reminder: Take at "+ med.time);
        }
    }
}
