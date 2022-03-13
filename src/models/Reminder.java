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
    private int goalID; // Mine
    private boolean completed; //Mine

    public Reminder(){

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

    public Reminder(String subject, LocalDate startDate, LocalDate endDate, LocalTime startTime, LocalTime endTime) {
        this.subject = subject;
        this.startDate = startDate;
        this.endDate = endDate;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Reminder{" +
                "subject='" + subject + '\'' +
                ", description='" + description + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", priority=" + priority +
                ", goalID=" + goalID +
                ", completed=" + completed +
                '}';
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public int getGoalID() {
        return goalID;
    }

    public void setGoalID(int goalID) {
        this.goalID = goalID;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
