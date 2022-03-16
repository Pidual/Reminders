package views;

import models.Reminder;
import presenter.Presenter;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Se crea la vista
 */
public class GraphicalUserInterface extends JFrame{

    private MainMenu mainMenu;
    private Cards cardPanes;

    
    public GraphicalUserInterface(ActionListener listener) {
        super("Reminders :)");
        initComponents(listener);
        this.setSize(1200, 700);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void initComponents(ActionListener listener){
        this.setLayout(new BorderLayout());
        mainMenu = new MainMenu(listener); //Iniciamos el panel del menu
        mainMenu.setPreferredSize(mainMenu.getPreferredSize());
        add(mainMenu, BorderLayout.WEST);
        cardPanes = new Cards(listener);
        add(cardPanes, BorderLayout.CENTER);
    }

    public ArrayList<Object> getInfo() {
        return cardPanes.getNewGoalPanel().getInfoInAnArray();
    }

    public Cards getCardsPanel() {
        return cardPanes;
    }
}
