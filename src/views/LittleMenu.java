package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static views.GraphicalUserInterface.*;
import static views.GraphicalUserInterface.styleComponent;

public class LittleMenu extends JPanel {

    private JButton modBtn;
    private JButton deleteBtn;
    private JButton sortTableBtn;
    private JButton addBtn;
    private JLabel targetedLbl;
    private JLabel targetedField;


    public LittleMenu(ActionListener listener) {
        this.setBackground(colorBackground.darker());
        initComponents(listener);
    }

    private void initComponents(ActionListener listener) {
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(0, 0, 0, 20);

        targetedLbl = new JLabel("Recordatorio: ");
        styleComponent(targetedLbl);
        add(targetedLbl, gbc);

        gbc.gridy = 0;
        gbc.gridx = 1;
        gbc.gridwidth = 3;
        targetedField = new JLabel();
        styleComponent(targetedField);
        add(targetedField, gbc);

        gbc.gridy = 1;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        addBtn = new JButton("AGREGAR");
        styleButton(addBtn);
        addBtn.addActionListener(listener);
        addBtn.setActionCommand("SHOW_MANAGER_REMINDER_PANEL");
        add(addBtn, gbc);

        gbc.gridx = 1;
        modBtn = new JButton("MODIFICAR ");
        styleButton(modBtn);
        modBtn.addActionListener(listener);
        modBtn.setActionCommand("SHOW_MODDING_PANEL");
        add(modBtn, gbc);

        gbc.gridx = 2;
        deleteBtn = new JButton("BORRAR ");
        styleButton(deleteBtn);
        deleteBtn.addActionListener(listener);
        deleteBtn.setActionCommand("DELETE_REMINDER");
        add(deleteBtn, gbc);

        gbc.gridx = 3;
        sortTableBtn = new JButton("ORDENAR");
        styleButton(sortTableBtn);
        sortTableBtn.addActionListener(listener);
        sortTableBtn.setActionCommand("SHOW_ORDINANCE_PANEL");
        add(sortTableBtn, gbc);
    }

    public void setTargetedField(String text) {
        targetedField.setText(text);
    }
}
