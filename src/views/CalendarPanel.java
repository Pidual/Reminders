package views;

import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.GridLayout;


public class CalendarPanel extends JPanel {

    public CalendarPanel(ActionListener listener) {
        initComponents(listener);
    }

    private void initComponents(ActionListener listener) {
        this.setLayout(new GridLayout(6,6)); //Box layout
    }

}
