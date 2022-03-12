package views;

import models.Reminder;
import views.ComponentModifications.TableModelModed;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class CalendarPanel extends JPanel {

    private JScrollPane scrollPane;
    private JTable table;
    private ArrayList<Reminder> reminders;
    TableModelModed model;

    public CalendarPanel(ActionListener listener) {
        initComponents(listener);
    }

    private void initComponents(ActionListener listener) {

        table = new JTable(model);
        scrollPane = new JScrollPane(table);
        add(scrollPane);



    }

}
