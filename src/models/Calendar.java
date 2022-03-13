package models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;


public class Calendar {

    private ArrayList<Reminder> reminders;
    private LocalTime currentTime;
    private LocalDate currentDate;
    private GUIConfigurations configs;
    private Notifications notifications;

    public Calendar(){
        currentDate = LocalDate.now();
        reminders = new ArrayList<Reminder>();
    }

    public void startReminderMatrix() {

    }

    public void addReminder(ArrayList<Object> info){
        Reminder newReminder = new Reminder(info.get(0).toString(), dateToLocalDate((Date) info.get(1)) , dateToLocalDate((Date) info.get(2)), toLocalTime((Date) info.get(3)) , toLocalTime((Date) info.get(4))) ;

        reminders.add(newReminder);
    }

    private LocalDate dateToLocalDate(Date date){
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    private LocalTime toLocalTime(Date date){
        java.time.Instant inst = date.toInstant();
        java.time.ZoneId theZone = java.time.ZoneId.systemDefault();
        java.time.LocalTime thetime = java.time.LocalTime.ofInstant(inst, theZone);
        return thetime;
    }

    public ArrayList<Reminder> getReminders() {
        return reminders;
    }
}
