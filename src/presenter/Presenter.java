package presenter;

import Persistence.FileOperation;
import models.Calendar;

import views.GraphicalUserInterface;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Presenter implements ActionListener {

    private Calendar calendar;
    private GraphicalUserInterface view;
    private FileOperation fileOperation;

    public Presenter() {
        calendar = new Calendar();
        view = new GraphicalUserInterface(this);
        fileOperation = new FileOperation("data/Reminders_Data2.json");
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();
        switch (command) {
            case "openNewGoalPanel":
            view.showNewGoalPanel();
            break;

            case "removeGoal":
            System.out.println("RECKT Dgoal alala");
            view.showRemoveGoalPanel();
            break;

            case "modGoal":
            System.out.println("MOD MOD");
            break;

            case "configuration":
            System.out.println("CONFIGS");
            break;

            case "exit":
            System.out.println("EXEXE");
            break;

            case "calendarGUI":
                view.showCalendarPanel();
            break;

            case "AddReminder":
                calendar.addReminder(view.getInfo());
                save();
                break;

            default:

                break;
        }
    }

    private void save() {
        fileOperation.save(calendar.getReminders());


    }

}
