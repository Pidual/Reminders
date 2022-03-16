package views;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import java.awt.event.ActionListener;
import java.awt.GridBagLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;

public class MainMenu extends JPanel {

    private JButton addGoalButton;
    private JButton configurationButton;
    private JButton homeButton;
    private JButton exitButton;


    private ImageIcon lilIcon;
    private JLabel imageLabel;

    public MainMenu(ActionListener listener) {
        initComponents(listener);
    }

    private void initComponents(ActionListener listener) {
        this.setLayout(new GridBagLayout());
        this.setBackground(new Color(0, 45, 89)); //Color del menu principal
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weighty = 0.1;
        gbc.gridy = 0;

        lilIcon = new ImageIcon(getClass().getResource("/resources/logo.jpg"));
        imageLabel = new JLabel(lilIcon);

        Border border = BorderFactory.createLineBorder(Color.BLACK, 3);
        imageLabel.setBorder(border);
        add(imageLabel, gbc);

        gbc.gridy = 1;
        addGoalButton = new JButton("AÑADIR META");
        addGoalButton.setActionCommand("openNewGoalPanel");
        addGoalButton.addActionListener(listener);
        add(addGoalButton, gbc);

        gbc.gridy = 2;
        homeButton = new JButton("CALENDARIO");
        homeButton.setActionCommand("calendarGUI");
        homeButton.addActionListener(listener);
        add(homeButton,gbc);

        gbc.gridy = 5;
        add(Box.createVerticalStrut(100), gbc); // Esta linea crea espacios en el gridBagLayout

        gbc.gridy = 6;
        configurationButton = new JButton("CONFIGURACION");
        configurationButton.setActionCommand("configuration");
        configurationButton.addActionListener(listener);
        add(configurationButton, gbc);

        gbc.gridy = 7;
        add(Box.createVerticalStrut(10), gbc); // Esta linea crea espacios en el gridBagLayout

        gbc.gridy = 8;
        exitButton = new JButton("EXIT");
        exitButton.setActionCommand("exit");
        exitButton.addActionListener(listener);
        add(exitButton, gbc);

    }

}
