package views;

import models.Reminder;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import static views.GraphicalUserInterface.*;


public class TablePanel extends JPanel implements MouseListener { //implements MouseListener

    private JTable table;
    private JScrollPane jScrollPane;
    private DefaultTableModel tableModel;
    private ArrayList<Reminder> reminders;

    private LittleMenu littleMenu;
    private final String[] columns = {"Nombre", "Descripcion", "Fecha inicial", "Fecha final", "Incia", "Termina"};
    private int targetedRow = -1;

    public TablePanel(ActionListener listener) {
        initComponents(listener);
        this.setBackground(colorMenu);
    }

    private void initComponents(ActionListener listener) {
        this.setLayout(new BorderLayout());
        table = new JTable() {
            public boolean isCellEditable(int data, int columns) {
                return false;
            }

            public Component prepareRenderer(TableCellRenderer r, int data, int columns) {
                Component c = super.prepareRenderer(r, data, columns);
                c.setFont(new Font("Helvetica", Font.PLAIN, 15));
                if (reminders.get(data).getPriority() == 1) {
                    c.setBackground(colorLowPrio);
                } else if (reminders.get(data).getPriority() == 2) {
                    c.setBackground(colorMediumPrio);
                } else {
                    c.setBackground(colorHighPrio);
                }
                return c;
            }
        };
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Helvetica", Font.ITALIC, 14));
        header.setBackground(colorMenu);
        header.setForeground(colorFonts);
        ((DefaultTableCellRenderer) header.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        table.setRowHeight(40);
        table.setBackground(colorBackground);
        table.setFillsViewportHeight(true);
        table.addMouseListener(this);    //Mouse listener
        jScrollPane = new JScrollPane(table);
        add(jScrollPane, BorderLayout.CENTER);
        littleMenu = new LittleMenu(listener);
        add(littleMenu, BorderLayout.SOUTH);
    }

    public void setDataAndReDrawTable(ArrayList<Reminder> reminders, String[][] data) {
        this.reminders = reminders;
        tableModel = new DefaultTableModel(data, columns);
        table.setModel(tableModel);
        table.getColumnModel().getColumn(2).setMaxWidth(95); //Fecha inicial
        table.getColumnModel().getColumn(2).setMinWidth(95); //Fecha inicial
        table.getColumnModel().getColumn(3).setMaxWidth(90); //Fecha final
        table.getColumnModel().getColumn(3).setMinWidth(95);
        table.getColumnModel().getColumn(4).setMaxWidth(60);
        table.getColumnModel().getColumn(5).setMaxWidth(62);
        table.setPreferredScrollableViewportSize(new Dimension(1030, data.length * 40));
    }

    public LittleMenu getLittleMenu() {
        return littleMenu;
    }

    public int getTargetedRow() {
        return targetedRow;
    }

    public void resetTarget() {
        targetedRow = -1;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        targetedRow = table.rowAtPoint(e.getPoint());
        littleMenu.setTargetedField(reminders.get(targetedRow).getSubject());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }


}
