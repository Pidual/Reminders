package views;

import com.toedter.calendar.JDateChooser;
import models.Reminder;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import static views.GraphicalUserInterface.*;


public class ManagerReminderPanel extends JPanel {

    private JLabel subjectLabel;
    private JTextField subject;

    private JSpinner startTime;
    private JLabel startTimeLabel;
    private JSpinner endTime;
    private JLabel endTimeLabel;

    private JDateChooser startDate;
    private JLabel startDateLabel;
    private JDateChooser endDate;
    private JLabel endDateLabel;

    private JLabel descriptionLabel;
    private JTextArea descripton;
    private JSeparator separatorTwo;
    private JButton submitButton;
    private Date actualDate;
    private JToggleButton lowPrio;
    private JToggleButton mediumPrio;
    private JToggleButton highPrio;
    private ButtonGroup priorityGroup;

    public ManagerReminderPanel(ActionListener listener) {
        actualDate = new Date();
        this.setBackground(colorBackground);
        initComponents(listener);
    }

    private void initComponents(ActionListener listener) {
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        priorityGroup = new ButtonGroup();
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(0, 30, 7, 0);
        gbc.gridy = 0;
        subjectLabel = new JLabel("Recordatorio:");//Label
        styleComponent(subjectLabel);
        add(subjectLabel, gbc);

        gbc.gridy = 1;
        gbc.gridwidth = 3;
        subject = new JTextField(30);
        subject.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
        subject.setForeground(colorFonts);
        subject.setOpaque(false);
        styleComponent(subject);
        add(subject, gbc);
        gbc.gridwidth = 1;

        gbc.gridy = 2;
        gbc.gridx = 0;
        startTimeLabel = new JLabel("Inicia a las:");
        styleComponent(startTimeLabel);
        add(startTimeLabel, gbc);

        gbc.gridy = 2;
        gbc.gridx = 1;
        endTimeLabel = new JLabel("Termina a las:");
        styleComponent(endTimeLabel);
        add(endTimeLabel, gbc);

        gbc.gridy = 2;
        gbc.gridx = 2;
        gbc.gridheight = 4;
        submitButton = new JButton("<html>AGREGAR<br/>RECORDATORIO</html>"); //Submit button
        submitButton.setActionCommand("AddReminder");
        submitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        submitButton.addActionListener(listener);
        submitButton.setPreferredSize(new Dimension(200, 180));
        submitButton.setFont(new Font("Helvetica", Font.PLAIN, 20));
        submitButton.setForeground(colorFonts);
        submitButton.setBackground(colorButtons);
        submitButton.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.WHITE));
        add(submitButton, gbc);
        gbc.gridheight = 1;

        gbc.gridy = 3;
        gbc.gridx = 0;
        startTime = new JSpinner(new SpinnerDateModel());
        startTime.setEditor(new JSpinner.DateEditor(startTime, "HH:mm"));
        startTime.setValue(actualDate); //Muestra la fecha actual
        styleComponent(startTime);
        add(startTime, gbc);

        gbc.gridy = 3;
        gbc.gridx = 1;
        endTime = new JSpinner(new SpinnerDateModel());
        endTime.setEditor(new JSpinner.DateEditor(endTime, "HH:mm"));
        endTime.setValue(actualDate);
        styleComponent(endTime);
        add(endTime, gbc);

        gbc.gridy = 4;
        gbc.gridx = 0;
        startDateLabel = new JLabel("Fecha inicial:");
        styleComponent(startDateLabel);
        add(startDateLabel, gbc);


        gbc.gridx = 1;
        endDateLabel = new JLabel("Fecha Final:");
        styleComponent(endDateLabel);
        add(endDateLabel, gbc);

        gbc.gridy = 5;
        gbc.gridx = 0;
        startDate = new JDateChooser();
        startDate.setPreferredSize(new Dimension(170, 40));
        startDate.setDate(actualDate);
        startDate.setMinSelectableDate(actualDate);
        styleComponent(startDate);
        add(startDate, gbc);

        gbc.gridy = 5;
        gbc.gridx = 1;
        endDate = new JDateChooser();
        endDate.setPreferredSize(new Dimension(170, 40));
        endDate.setMinSelectableDate(actualDate);
        endDate.setDate(actualDate);
        styleComponent(endDate);
        add(endDate, gbc);

        gbc.gridy = 6;
        separatorTwo = new JSeparator();
        separatorTwo.setPreferredSize(new Dimension(1, 20));
        add(separatorTwo, gbc);

        gbc.gridy = 7;
        gbc.gridx = 0;
        lowPrio = new JToggleButton("Baja Prioridad");
        lowPrio.setActionCommand("1");
        lowPrio.setSelected(true);
        priorityGroup.add(lowPrio);
        styleComponent(lowPrio);
        add(lowPrio, gbc);

        gbc.gridy = 7;
        gbc.gridx = 1;
        mediumPrio = new JToggleButton("Media Prioridad");
        mediumPrio.setActionCommand("2");
        priorityGroup.add(mediumPrio);
        styleComponent(mediumPrio);
        add(mediumPrio, gbc);

        gbc.gridx = 2;
        highPrio = new JToggleButton("Alta Prioridad");
        highPrio.setActionCommand("3");
        highPrio.setOpaque(false);
        priorityGroup.add(highPrio);
        styleComponent(highPrio);
        add(highPrio, gbc);

        gbc.gridy = 8;
        gbc.gridx = 0;
        descriptionLabel = new JLabel("Descripcion... :");
        styleComponent(descriptionLabel);
        add(descriptionLabel, gbc);

        gbc.gridy = 9;
        gbc.gridx = 0;
        gbc.gridwidth = 3;
        gbc.gridheight = 3;
        descripton = new JTextArea(3, 30);
        descripton.setPreferredSize(new Dimension(600, 200));
        descripton.setBorder(BorderFactory.createMatteBorder(1, 1, 3, 1, Color.BLACK));
        descripton.setOpaque(false);
        descripton.setForeground(colorFonts);
        styleComponent(descripton);
        add(descripton, gbc);
    }

    public ArrayList<Object> getInfoInAnArray() {
        ArrayList<Object> information = new ArrayList<Object>();
        information.add(subject.getText());
        information.add(descripton.getText());
        information.add(startDate.getDate());
        information.add(endDate.getDate());
        information.add(startTime.getValue());
        information.add(endTime.getValue());
        information.add(Integer.parseInt(priorityGroup.getSelection().getActionCommand()));
        return information;
    }

    public void setInformationForModding(Reminder reminder) {
        subject.setText(reminder.getSubject());
        descripton.setText(reminder.getDescription());
        submitButton.setText("<html>MODIFICAR<br/>RECORDATORIO</html>");
        submitButton.setActionCommand("MODIFY_REMINDER");
    }

    public void removeInformationForAdding() {
        subject.setText("");
        descripton.setText("");
        submitButton.setText("<html>AGREGAR<br/>RECORDATORIO</html>");
        submitButton.setActionCommand("ADD_REMINDER");
    }
}
