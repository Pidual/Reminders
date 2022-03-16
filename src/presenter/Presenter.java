package presenter;

import Persistence.FileOperation;
import models.Calendar;

import views.GraphicalUserInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class Presenter implements ActionListener{

    private Calendar calendar;
    private GraphicalUserInterface view;
    private FileOperation fileOperation;

    public Presenter() {
        calendar = new Calendar();
        fileOperation = new FileOperation("data/Reminders_Data.json");
        load();
        view = new GraphicalUserInterface(this);

    }

    private void load() {
        calendar.setReminders(fileOperation.load());
    }

    private void save() {
        fileOperation.save(calendar.getReminders());

    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();
        switch (command) {
            case "openNewGoalPanel":
                view.getCardsPanel().showNewGoalPanel();
                break;

            case "configuration":
                view.getCardsPanel().showConfigPanel();
                break;

            case "calendarGUI":
                view.getCardsPanel().getTablePanel().setDataAndReDrawTable(calendar.getReminders(), calendar.getReminderMatrix());
                view.getCardsPanel().showTablePanel();
                break;

            case "AddReminder":
                calendar.addReminder(view.getInfo());
                save();
                break;
            case "exit":
                System.exit(0);
                break;
        }
    }
}
