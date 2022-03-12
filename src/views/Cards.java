package views;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Date;

public class Cards extends JPanel{
    
    private CalendarPanel cp;
    private NewGoalPanel ngp;
    private RemoverPanel rp;
    private CardLayout cardLayout;
    
    public Cards(ActionListener listener){
        initComponents(listener);
    }
    
    public void initComponents(ActionListener listener){
        this.setSize(1000,600);
        this.setLayout(cardLayout = new CardLayout()); //Card Layout
        cp = new CalendarPanel(null); //Listeners bla
        cp.setBackground(Color.DARK_GRAY);
        ngp = new NewGoalPanel(listener);
        rp = new RemoverPanel();
        rp.setBackground(Color.PINK);
        add(cp,"CalendarPanel");
        add(ngp,"NewPanel");
        add(rp,"RemoverPanel");
        cardLayout.show(this, "CalendarPanel");
    }

    public void showNewGoalPanel(){
        cardLayout.show(this, "NewPanel");
    }

    public void showCalendarPanel(){
        cardLayout.show(this, "CalendarPanel");
    }

    public void showRemoverPanel(){
        cardLayout.show(this, "RemoverPanel");
    }


    public NewGoalPanel getNgp() {
        return ngp;
    }
}
