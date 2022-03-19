package models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.*;


public class Calendar {

    private ArrayList<Reminder> reminders;
    private Configurations configs;

    public Calendar() {
        reminders = new ArrayList<Reminder>();
        configs = new Configurations();
    }

    public void setReminders(ArrayList<Reminder> reminders) {
        this.reminders = reminders;
    }

    public void addReminder(ArrayList<Object> info) {
        Reminder newReminder = new Reminder(info.get(0).toString(), info.get(1).toString(), dateToLocalDate((Date) info.get(2)), dateToLocalDate((Date) info.get(3)), dateToLocalTime((Date) info.get(4)), dateToLocalTime((Date) info.get(5)),
                (Integer) info.get(6));
        boolean joinValidation = true;
        if (reminders != null) {
            for (Reminder reminder : reminders) {
                if (reminder.getSubject().equals(newReminder.getSubject())) {
                    joinValidation = false;
                    break;
                }
            }
        }
        if (joinValidation) {
            assert reminders != null;
            reminders.add(newReminder);
        }
    }

    public void modifyReminder(int target, ArrayList<Object> info) {
        Reminder newReminder = new Reminder(info.get(0).toString(), info.get(1).toString(), dateToLocalDate((Date) info.get(2)), dateToLocalDate((Date) info.get(3)), dateToLocalTime((Date) info.get(4)), dateToLocalTime((Date) info.get(5)),
                (Integer) info.get(6));
        reminders.set(target, newReminder);
    }

    public void deleteReminder(int target) {
        reminders.remove(target);
    }

    private LocalDate dateToLocalDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    private LocalTime dateToLocalTime(Date date) {
        java.time.Instant inst = date.toInstant();
        java.time.ZoneId theZone = java.time.ZoneId.systemDefault();
        return LocalTime.ofInstant(inst, theZone);
    }

    public String[][] getReminderMatrix() {
        String[][] columns = new String[reminders.size()][6];
        for (int i = 0; i < reminders.size(); i++) {
            columns[i][0] = reminders.get(i).getSubject();
            if (!Objects.equals(reminders.get(i).getDescription(), "")) {
                columns[i][1] = reminders.get(i).getDescription();
            } else columns[i][1] = "Sin Descripcion";
            columns[i][2] = reminders.get(i).getStartDate().toString();
            columns[i][3] = reminders.get(i).getEndDate().toString();
            columns[i][4] = reminders.get(i).getStartTime().toString().substring(0, 5);
            columns[i][5] = reminders.get(i).getEndTime().toString().substring(0, 5);
        }
        return columns;
    }

    public String[][] getDataForStatistics() {
        String[][] data = new String[3][2];
        data[0][0] = "Baja prioridad";
        data[1][0] = "Media prioridad";
        data[2][0] = "Alta prioridad";
        int lowPrios = 0;
        int mediumPrios = 0;
        int highPrios = 0;
        for (Reminder reminder : reminders) {
            if (reminder.getPriority() == 1) {
                lowPrios++;
            } else if (reminder.getPriority() == 2) {
                mediumPrios++;
            } else if (reminder.getPriority() == 3) {
                highPrios++;
            }
        }
        data[0][1] = String.valueOf(lowPrios);
        data[1][1] = String.valueOf(mediumPrios);
        data[2][1] = String.valueOf(highPrios);
        return data;
    }

    public void sortTable(int sortMode) {
        if (sortMode == 0) {
            reminders.sort(Comparator.comparingInt(Reminder::getPriority));
        } else if (sortMode == 1) {
            reminders.sort(Comparator.comparing(Reminder::getStartDate));
        } else if (sortMode == 2) {
            reminders.sort(Comparator.comparing(Reminder::getEndDate));
        } else if (sortMode == 3) {
            reminders.sort(Comparator.comparing(Reminder::getStartTime));
        } else if (sortMode == 4) {
            reminders.sort(Comparator.comparing(Reminder::getEndTime));
        } else if (sortMode == 5) {
            reminders.sort(Comparator.comparing(o -> o.getSubject().toLowerCase()));
        }
    }

    public ArrayList<Reminder> getReminders() {
        return reminders;
    }

    public Configurations getConfigs() {
        return configs;
    }


}
