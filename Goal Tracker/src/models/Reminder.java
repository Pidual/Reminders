package models;

import java.time.*;

public class Reminder {

    private String subject; //Obligatori
    private String descripton; //Optional
    private LocalDate startDate; //Obligatory
    private LocalDate endDate; //Obligatory
    private LocalTime startTime; //Obligatory
    private LocalTime endTime; //Obligatory
    private int priority; //Optional
    private int goalID; // Mine
    private boolean completed; //Mine

    public Reminder(String subject, String descripton, LocalDate startDate, LocalDate endDate, LocalTime startTime, LocalTime endTime, int priority, boolean completed) {
        this.subject = subject;
        this.descripton = descripton;
        this.startDate = startDate;
        this.endDate = endDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.priority = priority;
        this.completed = completed;
    }

    public Reminder(String subject, LocalDate startDate, LocalDate endDate, LocalTime startTime, LocalTime endTime) {
        this.subject = subject;
        this.startDate = startDate;
        this.endDate = endDate;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
