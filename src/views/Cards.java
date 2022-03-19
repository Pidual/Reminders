package views;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionListener;

public class Cards extends JPanel {

    private TablePanel tablePanel;
    private ConfigPanel configPanel;
    private BarChart statsPanel;
    private CardLayout cardLayout;

    public Cards(ActionListener listener) {
        this.setSize(1000, 600);
        initComponents(listener);
    }

    public void initComponents(ActionListener listener) {
        this.setLayout(cardLayout = new CardLayout()); //Card Layout
        tablePanel = new TablePanel(listener);
        configPanel = new ConfigPanel(listener);
        statsPanel = new BarChart();
        add(statsPanel, "StatsPanel");
        add(configPanel, "ConfigPanel");
        add(tablePanel, "TablePanel");
        cardLayout.show(this, "TablePanel");
    }

    public void showTablePanel() {
        cardLayout.show(this, "TablePanel");
    }

    public void showConfigPanel() {
        cardLayout.show(this, "ConfigPanel");
    }

    public void showStatsPanel() {
        cardLayout.show(this, "StatsPanel");
    }

    public TablePanel getTablePanel() {
        return tablePanel;
    }

    public BarChart getStatsPanel() {
        return statsPanel;
    }
}
