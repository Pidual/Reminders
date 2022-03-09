package views;

import com.toedter.calendar.JDateChooser;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.Date;


public class NewGoalPanel extends JPanel {

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
    private JSeparator separator;
    private JSeparator separatorTwo;
    private JRadioButton lowPrio;
    private JRadioButton mediumPrio;
    private JRadioButton highPrio;
    private JRadioButton nuclearTreahtPrio;
    private JButton submitButton;
    private Date actualDate;

    public NewGoalPanel(ActionListener listener) {
        actualDate = new Date();
        initComponents(listener);

    }

    private void initComponents(ActionListener listener) {
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();


        this.setBackground(new Color(152, 185, 171));

        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(0, 60, 0, 0);

        gbc.gridy = 0;
        subjectLabel = new JLabel("Recordatorio:");//Label
        styleComponent(subjectLabel);
        add(subjectLabel, gbc);

        gbc.gridy = 1;
        gbc.gridwidth = 3;
        subject = new JTextField(30); //Textfield
        subject.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
        subject.setForeground(Color.black);
        styleComponent(subject);
        add(subject, gbc);
        gbc.gridwidth = 1;

        gbc.gridy = 2;
        separator = new JSeparator();
        separator.setPreferredSize(new Dimension(1, 70));
        add(separator, gbc);

        gbc.gridy = 3;
        gbc.gridx = 0;
        startTimeLabel = new JLabel("Inicia a las:");
        styleComponent(startTimeLabel);
        add(startTimeLabel, gbc);

        gbc.gridy = 3;
        gbc.gridx = 1;
        endTimeLabel = new JLabel("Termina a las:");
        styleComponent(endTimeLabel);
        add(endTimeLabel, gbc);

        gbc.gridy = 3;
        gbc.gridx = 2;
        gbc.gridheight=4;
        submitButton = new JButton("<html>AGREGAR<br/>RECORDATORIO</html> "); //Submit button
        submitButton.setPreferredSize(new Dimension(200, 142));
        styleButton(submitButton);
        add(submitButton, gbc);
        gbc.gridheight=1;

        gbc.gridy = 4;
        gbc.gridx = 0;
        startTime = new JSpinner(new SpinnerDateModel());
        startTime.setEditor(new JSpinner.DateEditor(startTime, "HH:mm"));
        startTime.setValue(actualDate); //Muestra la fecha actual
        styleComponent(startTime);
        add(startTime, gbc);

        gbc.gridy = 4;
        gbc.gridx = 1;
        endTime = new JSpinner(new SpinnerDateModel());
        endTime.setEditor(new JSpinner.DateEditor(endTime, "HH:mm"));
        endTime.setValue(actualDate);
        styleComponent(endTime);
        add(endTime, gbc);

        gbc.gridy = 5;
        gbc.gridx = 0;
        startDateLabel = new JLabel("Fecha inicial:");
        styleComponent(startDateLabel);
        add(startDateLabel, gbc);


        gbc.gridy = 5;
        gbc.gridx = 1;
        endDateLabel = new JLabel("Fecha Final:");
        styleComponent(endDateLabel);
        add(endDateLabel, gbc);

        gbc.gridy = 6;
        gbc.gridx = 0;
        startDate = new JDateChooser();
        startDate.setPreferredSize(new Dimension(170, 40));
        startDate.setDate(actualDate);
        startDate.setMinSelectableDate(actualDate);
        styleComponent(startDate);
        add(startDate, gbc);

        gbc.gridy = 6;
        gbc.gridx = 1;
        endDate = new JDateChooser();
        endDate.setPreferredSize(new Dimension(170, 40));
        endDate.setMinSelectableDate(actualDate);
        endDate.setDate(actualDate);
        styleComponent(endDate);
        add(endDate, gbc);

        gbc.gridy = 7;
        separatorTwo = new JSeparator();
        separatorTwo.setPreferredSize(new Dimension(1, 30));
        add(separatorTwo, gbc);

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
        descripton.setForeground(Color.black);
        styleComponent(descripton);
        add(descripton, gbc);
    }

    private void styleComponent(JComponent component) {
        component.setFont(new Font("Helvetica", Font.PLAIN, 25));
        component.setOpaque(false);
    }

    private void styleButton(JButton button){
        submitButton.setFont(new Font("Helvetica", Font.PLAIN, 20));
        submitButton.setForeground(Color.WHITE);
        submitButton.setBackground(new Color(0, 45, 89));
        submitButton.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.WHITE
        ));
    }


}
