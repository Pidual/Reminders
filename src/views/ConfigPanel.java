package views;

import javax.swing.*;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static views.GraphicalUserInterface.*;

public class ConfigPanel extends JPanel implements ActionListener {

    private JLabel firtsColorLabel;
    private JButton firstsColorButton;
    private JLabel secondColorLabel;
    private JButton secondColorButton;
    private JLabel thirdColorLabel;
    private JButton thirdColorButton;
    private JLabel fontColor;
    private JButton fontColorButton;
    private JLabel lowPrioLabel;
    private JButton lowPrioButton;
    private JLabel mediumPrioLabel;
    private JButton mediumPrioButton;
    private JLabel highPrioLabel;
    private JButton highPrioButton;
    private JColorChooser jscolorChooser;
    private JButton saveConfigButton;
    private JButton defaultConfigsButton;
    private JDialog dialog;

    public ConfigPanel(ActionListener listener) {
        this.setBackground(colorBackground);
        initComponents(listener);
    }

    private void initComponents(ActionListener listener) {
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(10, 0, 10, 20);

        jscolorChooser = new JColorChooser();
        AbstractColorChooserPanel[] defaultPanels = jscolorChooser.getChooserPanels();
        jscolorChooser.removeChooserPanel(defaultPanels[0]);
        jscolorChooser.removeChooserPanel(defaultPanels[1]);
        jscolorChooser.removeChooserPanel(defaultPanels[2]);  // HSL
        jscolorChooser.removeChooserPanel(defaultPanels[4]); // CMYK
        dialog = JColorChooser.createDialog(null, "Choose a Color", true, jscolorChooser, null, null);

        firtsColorLabel = new JLabel("Menu: ");
        styleComponent(firtsColorLabel);
        add(firtsColorLabel, gbc);

        gbc.gridx = 1;
        firstsColorButton = new JButton();
        firstsColorButton.setBackground(colorMenu);
        firstsColorButton.addActionListener(this);
        firstsColorButton.setPreferredSize(new Dimension(200, 60));
        firstsColorButton.setActionCommand("OPEN_JCOLORCHOOSER_FIRSTS_COLOR");
        add(firstsColorButton, gbc);

        gbc.gridy = 1;
        gbc.gridx = 0;
        secondColorLabel = new JLabel("Fondos: ");
        styleComponent(secondColorLabel);
        add(secondColorLabel, gbc);

        gbc.gridx = 1;
        secondColorButton = new JButton();
        secondColorButton.setBackground(colorBackground);
        secondColorButton.setActionCommand("OPEN_JCOLORCHOOSER_SECOND_COLOR");
        secondColorButton.setPreferredSize(new Dimension(200, 60));
        secondColorButton.addActionListener(this);
        add(secondColorButton, gbc);


        gbc.gridy = 2;
        gbc.gridx = 0;
        thirdColorLabel = new JLabel("Botones: ");
        styleComponent(thirdColorLabel);
        add(thirdColorLabel, gbc);

        gbc.gridx = 1;
        thirdColorButton = new JButton();
        thirdColorButton.setActionCommand("OPEN_JCOLORCHOOSER_THIRD_COLOR");
        thirdColorButton.setBackground(colorButtons);
        thirdColorButton.addActionListener(this);
        thirdColorButton.setPreferredSize(new Dimension(200, 60));
        add(thirdColorButton, gbc);

        gbc.gridy = 3;
        gbc.gridx = 0;
        fontColor = new JLabel("Color de letra");
        styleComponent(fontColor);
        add(fontColor, gbc);

        gbc.gridx = 1;
        fontColorButton = new JButton();
        fontColorButton.setBackground(colorFonts);
        fontColorButton.setActionCommand("OPEN_JCOLORCHOOSER_FOURTH_COLOR");
        fontColorButton.addActionListener(this);
        fontColorButton.setPreferredSize(new Dimension(200, 60));
        add(fontColorButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(new JSeparator(), gbc);

        gbc.gridy = 0;
        gbc.gridx = 2;
        lowPrioLabel = new JLabel("Prioridad 1 ");
        styleComponent(lowPrioLabel);
        add(lowPrioLabel, gbc);

        gbc.gridx = 3;
        lowPrioButton = new JButton();
        lowPrioButton.addActionListener(this);
        lowPrioButton.setBackground(colorLowPrio);
        lowPrioButton.setActionCommand("OPEN_JCOLORCHOOSER_LOW_PRIORITY_COLOR");
        lowPrioButton.setPreferredSize(new Dimension(200, 50));
        add(lowPrioButton, gbc);

        gbc.gridy = 1;
        gbc.gridx = 2;
        mediumPrioLabel = new JLabel("Prioridad 2 ");
        styleComponent(mediumPrioLabel);
        add(mediumPrioLabel, gbc);

        gbc.gridx = 3;
        mediumPrioButton = new JButton();
        mediumPrioButton.addActionListener(this);
        mediumPrioButton.setBackground(colorMediumPrio);
        mediumPrioButton.setActionCommand("OPEN_JCOLORCHOOSER_MEDIUM_PRIORITY_COLOR");
        mediumPrioButton.setPreferredSize(new Dimension(200, 50));
        add(mediumPrioButton, gbc);

        gbc.gridy = 2;
        gbc.gridx = 2;
        highPrioLabel = new JLabel("Prioridad 3 ");
        styleComponent(highPrioLabel);
        add(highPrioLabel, gbc);

        gbc.gridx = 3;
        highPrioButton = new JButton();
        highPrioButton.addActionListener(this);
        highPrioButton.setPreferredSize(new Dimension(200, 50));
        highPrioButton.setBackground(colorHighPrio);
        highPrioButton.setActionCommand("OPEN_JCOLORCHOOSER_HIGH_PRIORITY_COLOR");
        add(highPrioButton, gbc);

        gbc.gridy = 3;
        gbc.gridx = 2;
        saveConfigButton = new JButton("<html>GUARDAR<br>CONFIGURACIONES<html>");
        saveConfigButton.setActionCommand("SAVE_CONFIGURATIONS");
        saveConfigButton.addActionListener(listener);
        add(saveConfigButton, gbc);

        gbc.gridx = 3;
        defaultConfigsButton = new JButton("<html>CONFIGURACIONES<br>POR DEFECTO<html>");
        defaultConfigsButton.setActionCommand("RESET_CONFIGURATIONS");
        defaultConfigsButton.addActionListener(listener);
        add(defaultConfigsButton, gbc);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "OPEN_JCOLORCHOOSER_FIRSTS_COLOR" -> {
                dialog.setVisible(true);
                colorMenu = jscolorChooser.getColor();
                firstsColorButton.setBackground(jscolorChooser.getColor());
            }
            case "OPEN_JCOLORCHOOSER_SECOND_COLOR" -> {
                dialog.setVisible(true);
                secondColorButton.setBackground(jscolorChooser.getColor());
                colorBackground = jscolorChooser.getColor();
            }
            case "OPEN_JCOLORCHOOSER_THIRD_COLOR" -> {
                dialog.setVisible(true);
                thirdColorButton.setBackground(jscolorChooser.getColor());
                colorButtons = jscolorChooser.getColor();
            }
            case "OPEN_JCOLORCHOOSER_FOURTH_COLOR" -> {
                dialog.setVisible(true);
                fontColorButton.setBackground(jscolorChooser.getColor());
                colorFonts = jscolorChooser.getColor();
            }
            case "OPEN_JCOLORCHOOSER_LOW_PRIORITY_COLOR" -> {
                dialog.setVisible(true);
                lowPrioButton.setBackground(jscolorChooser.getColor());
                colorLowPrio = jscolorChooser.getColor();
            }
            case "OPEN_JCOLORCHOOSER_MEDIUM_PRIORITY_COLOR" -> {
                dialog.setVisible(true);
                mediumPrioButton.setBackground(jscolorChooser.getColor());
                colorMediumPrio = jscolorChooser.getColor();
            }
            case "OPEN_JCOLORCHOOSER_HIGH_PRIORITY_COLOR" -> {
                dialog.setVisible(true);
                highPrioButton.setBackground(jscolorChooser.getColor());
                colorHighPrio = jscolorChooser.getColor();
            }
        }
    }
}
