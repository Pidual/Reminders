package models;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;


public class Calendar {

    private Reminder[][] reminderMatrix;
    private LocalTime currentTime;
    private LocalDate currentDate;
    private GUIConfigurations configs;
    private Notifications notifications;

    public Calendar(){
        currentDate = LocalDate.now();
    }

    public void startReminderMatrix() {
        reminderMatrix = new Reminder[7][24];
    }

    public void addReminder(LocalDate day, LocalTime hour , Reminder reminder){
            reminderMatrix[day][hour] = reminder;
    }

    public void removeReminder(int day,int hour){
        reminderMatrix[day][hour] = null;
    }

    public Reminder[][] generateNextWeekMatrix(){
        //Todo
        return null;
    }

    public Reminder[][] generatePreviusWeekMatrix(){
        //Todo
        return null;
    }

    public Reminder[][] generateSpecificWeekMatrix(){
        //TODO
        return null;
    }
}
