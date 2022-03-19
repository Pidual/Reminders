package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static views.GraphicalUserInterface.*;

public class OrdinancePanel extends JPanel {

    private JLabel text;
    private JButton prioritySorting;
    private JButton lexicographicSorting;
    private JButton initialDateSorting;
    private JButton finalDateSorting;
    private JButton initialTimeSorting;
    private JButton finalTimeSorting;

    public OrdinancePanel(ActionListener listener) {
        this.setBackground(colorMenu.brighter());
        initComponents(listener);
    }

    private void initComponents(ActionListener listener) {
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridy = 0;
        gbc.gridx = 2;
        gbc.gridwidth = 3;
        text = new JLabel("ORDENAR TABLA POR:");
        styleComponent(text);
        add(text, gbc);
        gbc.gridwidth = 1;

        gbc.gridx = 0;
        gbc.gridy = 1;
        prioritySorting = new JButton("PRIORIDAD");
        styleButton(prioritySorting);
        prioritySorting.setActionCommand("PRIORITY_ORDINANCE");
        prioritySorting.addActionListener(listener);
        add(prioritySorting, gbc);

        gbc.gridx = 1;
        lexicographicSorting = new JButton("A-Z");
        styleButton(lexicographicSorting);
        lexicographicSorting.addActionListener(listener);
        lexicographicSorting.setActionCommand("LEXICOGRAPHIC_ORDINANCE");
        add(lexicographicSorting, gbc);

        gbc.gridx = 2;
        initialDateSorting = new JButton("Fechas INICIAL");
        styleButton(initialDateSorting);
        initialDateSorting.addActionListener(listener);
        initialDateSorting.setActionCommand("START_DATE_ORDINANCE");
        add(initialDateSorting, gbc);

        gbc.gridx = 3;
        finalDateSorting = new JButton("FECHAS FINALES");
        styleButton(finalDateSorting);
        finalDateSorting.addActionListener(listener);
        finalDateSorting.setActionCommand("FINAL_DATE_ORDINANCE");
        add(finalDateSorting, gbc);

        gbc.gridx = 4;
        initialTimeSorting = new JButton("TIEMPO INICIAL");
        styleButton(initialTimeSorting);
        initialTimeSorting.addActionListener(listener);
        initialTimeSorting.setActionCommand("START_TIME_ORDINANCE");
        add(initialTimeSorting, gbc);

        gbc.gridx = 5;
        finalTimeSorting = new JButton("TIEMPO FINAL");
        styleButton(finalTimeSorting);
        finalTimeSorting.addActionListener(listener);
        finalTimeSorting.setActionCommand("FINAL_TIME_ORDINANCE");
        add(finalTimeSorting, gbc);
    }
}
