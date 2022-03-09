package presenter;

import models.Calendar;

import views.GraphicalUserInterface;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Presenter implements ActionListener {

    private Calendar calendar;
    private GraphicalUserInterface view;

    public Presenter() {
        calendar = new Calendar();
        view = new GraphicalUserInterface(this);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();
        switch (command) {
            case "openNewGoalPanel":
            System.out.println("Nueva meta acccccc");
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

            case "createNewGoal":
            System.out.println("SSSSSS221323213 ");

            break;
            default:

                break;
        }
    }

}
