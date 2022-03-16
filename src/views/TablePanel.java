package views;

import models.Reminder;
import views.ComponentModifications.TableRenderer;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;


public class TablePanel extends JPanel implements MouseListener {

    private JTable table;
    private JScrollPane jScrollPane;
    private ArrayList<Reminder> reminders;
    private final String[] columns = {"Nombre", "Descripcion", "Fecha inicial", "Fecha final", "Incia", "Termina", "Mod", "Del"};
    private DefaultTableModel tableModel;
    private JLabel trashcanLabel;
    private JLabel pencilLabel;
    private ImageIcon trashcan;
    private ImageIcon pencil;
    private ImageIcon invertedTrashcan;
    private ImageIcon invertedPencil;
    private int targetedRow;
    public TablePanel() {
        initComponents();
        this.setBackground(Color.GRAY);
        trashcan = new ImageIcon("src/resources/Trashcan.png");
        pencil = new ImageIcon("src/resources/Lapiz.png");
        invertedTrashcan = new ImageIcon("src/resources/TreshCan_Inverted.png");
        invertedPencil = new ImageIcon("src/resources/Lapiz _Inverted.png");
    }

    private void initComponents() {
        table = new JTable() {
            public boolean isCellEditable(int data, int columns) {
                return false;
            }
            public Component prepareRenderer(TableCellRenderer r, int data, int columns) {
                Component c = super.prepareRenderer(r, data, columns);
                c.setFont(new Font("Helvetica", Font.PLAIN, 15));
                if (reminders.get(data).getPriority() == 1) {
                    c.setBackground(new Color(97, 255, 92));
                } else if (reminders.get(data).getPriority() == 2) {
                    c.setBackground(new Color(230, 175, 46));
                } else {
                    c.setBackground(new Color(237, 90, 104));
                }
                return c;
            }
        };
        table.setDefaultRenderer(Object.class, new TableRenderer());
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Helvetica", Font.ITALIC, 15));
        header.setBackground(new Color(0, 45, 89));
        header.setForeground(Color.WHITE);
        ((DefaultTableCellRenderer) header.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        table.setRowHeight(40);
        table.setFillsViewportHeight(true);
        table.addMouseListener(this);
        jScrollPane = new JScrollPane(table);

        add(jScrollPane);
    }

    public void setDataAndReDrawTable(ArrayList<Reminder> reminders, String[][] data) {
        this.reminders = reminders;
        tableModel = new DefaultTableModel(addModingAndDeletionButtons(data), columns);
        table.setModel(tableModel);
        table.getColumnModel().getColumn(2).setMaxWidth(95);//Fecha inicial
        table.getColumnModel().getColumn(2).setMinWidth(95);//Fecha inicial
        table.getColumnModel().getColumn(3).setMaxWidth(90); //Fecha final
        table.getColumnModel().getColumn(3).setMinWidth(95);//Fecha inicial
        table.getColumnModel().getColumn(4).setMaxWidth(60); //Hora inicial
        table.getColumnModel().getColumn(5).setMaxWidth(62); //Hora finalt
        table.getColumnModel().getColumn(6).setMaxWidth(50); //Boton Borrar
        table.getColumnModel().getColumn(7).setMaxWidth(50); //Boton editar
        table.setPreferredScrollableViewportSize(new Dimension(1030, data.length * 40));
    }

    public int getTargetedRow() {
        return targetedRow;
    }

    private Object[][] addModingAndDeletionButtons(String[][] data) {
        Object[][] dataButtons = new Object[data.length][8];
        pencilLabel = new JLabel(pencil);
        trashcanLabel = new JLabel(trashcan);
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < 8; j++) {
                if (j == 6) {
                    dataButtons[i][j] = pencilLabel;
                } else if (j == 7) {
                    dataButtons[i][j] = trashcanLabel;
                } else {
                    dataButtons[i][j] = data[i][j];
                }
            }
        }
        return dataButtons;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //Toco dejar este codigo si no me tocaba hacer la clase abstracta y F
    }

    @Override
    public void mousePressed(MouseEvent e) {
        targetedRow = table.rowAtPoint(e.getPoint());
        int column = table.columnAtPoint(e.getPoint());
        if(column == 7){
            trashcanLabel.setIcon(invertedTrashcan);

        }else if(column == 6){
            pencilLabel.setIcon(invertedPencil);
        }
        table.updateUI();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int column = table.columnAtPoint(e.getPoint());
        if(column == 7){
            trashcanLabel.setIcon(trashcan);
        }else if(column == 6){
            pencilLabel.setIcon(pencil);
        }
        table.updateUI();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
