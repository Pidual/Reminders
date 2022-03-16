package views;

import models.Reminder;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Cards extends JPanel{
    
    private TablePanel tablePanel;
    private NewGoalPanel newGoalPanel;
    private ConfigPanel configPanel;
    private CardLayout cardLayout;

    public Cards(ActionListener listener){
        initComponents(listener);
    }
    
    public void initComponents(ActionListener listener){
        this.setSize(1000,600);
        this.setLayout(cardLayout = new CardLayout()); //Card Layout
        tablePanel = new TablePanel();
        newGoalPanel = new NewGoalPanel(listener);
        configPanel = new ConfigPanel(listener);
        add(configPanel,"ConfigPanel");
        add(tablePanel,"TablePanel");
        add(newGoalPanel,"NewPanel");
        cardLayout.show(this, "NewPanel");
    }

    public void showNewGoalPanel(){
        cardLayout.show(this, "NewPanel");
    }
    public void showTablePanel(){
        cardLayout.show(this, "TablePanel");
    }
    public void showConfigPanel(){
        cardLayout.show(this, "ConfigPanel");
    }


    public NewGoalPanel getNewGoalPanel() {
        return newGoalPanel;
    }

    public TablePanel getTablePanel() {
        return tablePanel;
    }
}
