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
import java.util.Objects;

import static views.GraphicalUserInterface.colorMenu;
import static views.GraphicalUserInterface.styleButton;

public class MainMenu extends JPanel {

    private JButton configurationButton;
    private JButton tableButton;
    private JButton exitButton;
    private JButton stadisticsButton;
    private ImageIcon lilIcon;
    private JLabel imageLabel;

    public MainMenu(ActionListener listener) {
        initComponents(listener);
    }

    private void initComponents(ActionListener listener) {
        this.setLayout(new GridBagLayout());
        this.setBackground(colorMenu); //Color del menu principal
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weighty = 0.1;
        gbc.gridy = 0;

        lilIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/resources/logo.jpg")));
        imageLabel = new JLabel(lilIcon);

        Border border = BorderFactory.createLineBorder(Color.BLACK, 3);
        imageLabel.setBorder(border);
        add(imageLabel, gbc);


        gbc.gridy = 1;
        tableButton = new JButton("CALENDARIO");
        tableButton.setActionCommand("SHOW_TABLE_PANEL");
        tableButton.addActionListener(listener);
        styleButton(tableButton);
        add(tableButton, gbc);

        gbc.gridy =2;
        stadisticsButton = new JButton("Estadisticas");
        stadisticsButton.setActionCommand("SHOW_STATS_PANEL");
        stadisticsButton.addActionListener(listener);
        styleButton(stadisticsButton);
        add(stadisticsButton, gbc);

        gbc.gridy = 3;
        add(Box.createVerticalStrut(100), gbc); // Esta linea crea espacios en el gridBagLayout

        gbc.gridy = 4;
        configurationButton = new JButton("CONFIGURACION");
        configurationButton.setActionCommand("SHOW_CONFIGURATION_PANEL");
        configurationButton.addActionListener(listener);
        styleButton(configurationButton);
        add(configurationButton, gbc);

        gbc.gridy = 5;
        add(Box.createVerticalStrut(10), gbc); // Esta linea crea espacios en el gridBagLayout

        gbc.gridy = 6;
        exitButton = new JButton("EXIT");
        exitButton.setActionCommand("exit");
        exitButton.addActionListener(listener);
        styleButton(exitButton);
        add(exitButton, gbc);
    }

}
