package views;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * Se crea la vista
 */
public class GraphicalUserInterface extends JFrame{

    private MainMenu mainMenu;
    private Cards cardPanes;

    
    public GraphicalUserInterface(ActionListener listener) {
        super("Goal Tracker Calendario");  
        initComponents(listener);
        this.setSize(1000, 700);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void initComponents(ActionListener listener){
        this.setLayout(new BorderLayout());
        mainMenu = new MainMenu(listener); //Iniciamos el panel del menu
        mainMenu.setBackground(new Color(0, 45, 89)); //Color del menu principal
        mainMenu.setPreferredSize(mainMenu.getPreferredSize());
        add(mainMenu, BorderLayout.WEST);

        cardPanes = new Cards(listener);
        add(cardPanes, BorderLayout.CENTER);
    }

    public void showNewGoalPanel(){
        cardPanes.showNewGoalPanel();
    }

    public void showRemoveGoalPanel(){
        cardPanes.showRemoverPanel();
    }

}
