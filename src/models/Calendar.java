package models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;


public class Calendar {

    private ArrayList<Reminder> reminders;
    private LocalTime currentTime;
    private GUIConfigurations configs;
    private Notifications notifications;

    public Calendar() {
        reminders = new ArrayList<Reminder>();
    }

    public void setReminders(ArrayList<Reminder> reminders) {
        this.reminders = reminders;
    }

    public void addReminder(ArrayList<Object> info) {
        Reminder newReminder = new Reminder(info.get(0).toString(), info.get(1).toString(), dateToLocalDate((Date) info.get(2)), dateToLocalDate((Date) info.get(3)), toLocalTime((Date) info.get(4)), toLocalTime((Date) info.get(5)),
                (Integer) info.get(6));
        boolean joinValidation = true;
        if (reminders != null){
            for (Reminder reminder : reminders) {
                if (reminder.getSubject().equals(newReminder.getSubject())) {
                    joinValidation = false;
                    break;
                }
            }
        }
        if (joinValidation) {
            reminders.add(newReminder);
        }
    }

    private LocalDate dateToLocalDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    private LocalTime toLocalTime(Date date) {
        java.time.Instant inst = date.toInstant();
        java.time.ZoneId theZone = java.time.ZoneId.systemDefault();
        return LocalTime.ofInstant(inst, theZone);
    }

    public String[][] getReminderMatrix(){
        String[][] columns = new String[reminders.size()][6];
        for (int i = 0; i < reminders.size(); i++) {
            columns[i][0] = reminders.get(i).getSubject();
            if(!Objects.equals(reminders.get(i).getDescription(), "")){
                columns[i][1] = reminders.get(i).getDescription();
            }else columns[i][1] = "Sin Descripcion";
            columns[i][2] = reminders.get(i).getStartDate().toString();
            columns[i][3] = reminders.get(i).getEndDate().toString();
            columns[i][4] = reminders.get(i).getStartTime().toString().substring(0,5);
            columns[i][5] = reminders.get(i).getEndTime().toString().substring(0,5);
        }
        return columns;
    }

    public ArrayList<Reminder> getReminders() {
        return reminders;
    }
}
