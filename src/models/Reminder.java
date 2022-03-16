package models;

import java.time.*;

public class Reminder {

    private String subject; //Obligatori
    private String description; //Optional
    private LocalDate startDate; //Obligatory
    private LocalDate endDate; //Obligatory
    private LocalTime startTime; //Obligatory
    private LocalTime endTime; //Obligatory
    private int priority; //Optional
    private boolean completed; //Mine

    public Reminder() { //Util para crear objetos con gson
    }

    public Reminder(String subject, String description, LocalDate startDate, LocalDate endDate, LocalTime startTime, LocalTime endTime, int priority) {
        this.subject = subject;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.priority = priority;
    }


    public String getSubject() {
        return subject;
    }



    public String getDescription() {
        return description;
    }


    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
