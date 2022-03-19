package views;


import models.Reminder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GraphicalUserInterface extends JFrame {

    private MainMenu mainMenu;
    private Cards cardPanes;
    private ManagerReminderPanel managerPanel;
    private JDialog dialog;
    private JDialog ordinanceDialog;
    private OrdinancePanel ordinancePanel;
    protected static Color colorMenu;
    protected static Color colorBackground;
    protected static Color colorButtons;
    protected static Color colorFonts;
    protected static Color colorLowPrio;
    protected static Color colorMediumPrio;
    protected static Color colorHighPrio;

    public GraphicalUserInterface(ActionListener listener, ArrayList<Color> colors) {
        super("Reminders :)");
        setColors(colors);
        this.setSize(1200, 700);
        initComponents(listener);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void initComponents(ActionListener listener) {
        this.setLayout(new BorderLayout());
        mainMenu = new MainMenu(listener);
        mainMenu.setPreferredSize(mainMenu.getPreferredSize());
        add(mainMenu, BorderLayout.WEST);
        cardPanes = new Cards(listener);
        managerPanel = new ManagerReminderPanel(listener);
        add(cardPanes, BorderLayout.CENTER);
        dialog = new JDialog();
        dialog.add(managerPanel);
        dialog.setSize(new Dimension(800, 660));
        dialog.setLocationRelativeTo(null);

        ordinanceDialog = new JDialog();
        ordinancePanel = new OrdinancePanel(listener);
        ordinanceDialog.add(ordinancePanel);
        ordinanceDialog.setTitle("Escoja su modo de ordenamiento: ");
        ordinanceDialog.setSize(680, 110);
        ordinanceDialog.setLocationRelativeTo(null);
    }

    public ArrayList<Color> getColors() {
        ArrayList<Color> colors = new ArrayList<>();
        colors.add(colorMenu);
        colors.add(colorBackground);
        colors.add(colorButtons);
        colors.add(colorFonts);
        colors.add(colorLowPrio);
        colors.add(colorMediumPrio);
        colors.add(colorHighPrio);
        return colors;
    }

    private void setColors(ArrayList<Color> colors) {
        colorMenu = colors.get(0);
        colorBackground = colors.get(1);
        colorButtons = colors.get(2);
        colorFonts = colors.get(3);
        colorLowPrio = colors.get(4);
        colorMediumPrio = colors.get(5);
        colorHighPrio = colors.get(6);
    }

    public void showManagerPanelForModding(Reminder reminder) {
        managerPanel.setInformationForModding(reminder);
        dialog.setTitle("Modificar Recordatorio");
        dialog.setVisible(true);
    }

    public void hideManagerPanel() {
        dialog.setVisible(false);
    }

    public ManagerReminderPanel getManagerPanel() {
        return managerPanel;
    }

    public Cards getCardsPanel() {
        return cardPanes;
    }

    public void showManagerPanelForAdding() {
        managerPanel.removeInformationForAdding();
        dialog.setTitle("Agregar Recordatorio");
        dialog.setVisible(true);
    }

    public void showRestartMessage() {
        JOptionPane.showMessageDialog(null, "Se requiere reiniciar para aplicar cambios");
    }

    public void setVisibleOrdinancePanel(boolean visibility) {
        ordinanceDialog.setVisible(visibility);
    }

    protected static void styleButton(JButton button) {
        button.setBackground(colorButtons);
        button.setForeground(colorFonts);
    }

    protected static void styleComponent(JComponent component ) {
        component.setFont(new Font("Helvetica", Font.PLAIN, 25));
        component.setForeground(colorFonts);
    }

}
