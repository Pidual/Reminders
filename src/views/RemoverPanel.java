package views;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.*;

public class RemoverPanel extends JPanel{

    private JButton button;
    RemoverPanel(){
        initComponents();
    }

    private void initComponents() {

        button = new JButton("Hola");
        add(button);
    }
}
