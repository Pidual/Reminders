package models;

import java.time.*;

public class Reminder {

    private String subject; //Obligator
    private String description; //Optional
    private LocalDate startDate; //Obligatory
    private LocalDate endDate; //Obligatory
    private LocalTime startTime; //Obligatory
    private LocalTime endTime; //Obligatory
    private int priority; //Optional

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


    public LocalDate getEndDate() {
        return endDate;
    }


    public LocalTime getStartTime() {
        return startTime;
    }


    public LocalTime getEndTime() {
        return endTime;
    }

    public int getPriority() {
        return priority;
    }

}
