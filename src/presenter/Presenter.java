package presenter;

import Persistence.FileOperation;
import models.Calendar;

import views.GraphicalUserInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Presenter implements ActionListener {

    private Calendar calendar;
    private GraphicalUserInterface view;
    private FileOperation fileOperation;

    public Presenter() {
        calendar = new Calendar();
        fileOperation = new FileOperation("data/Reminders_Data.json");
        load();
        view = new GraphicalUserInterface(this, calendar.getConfigs().getColors());
        updateTable();
    }

    private void updateTable() {
        view.getCardsPanel().getTablePanel().setDataAndReDrawTable(calendar.getReminders(), calendar.getReminderMatrix());
    }

    private void load() {
        calendar.setReminders(fileOperation.load());
    }

    private void save() {
        fileOperation.save(calendar.getReminders());
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();
        switch (command) {

            case "SHOW_TABLE_PANEL":
                updateTable();
                view.getCardsPanel().showTablePanel();
                break;

            case "SHOW_CONFIGURATION_PANEL":
                view.getCardsPanel().showConfigPanel();
                break;

            case "SHOW_STATS_PANEL":
                view.getCardsPanel().getStatsPanel().setDataAndSetMaxValue(calendar.getDataForStatistics());
                view.getCardsPanel().showStatsPanel();
                break;

            case "SHOW_MANAGER_REMINDER_PANEL":
                view.showManagerPanelForAdding();
                break;

            case "ADD_REMINDER":
                calendar.addReminder(view.getManagerPanel().getInfoInAnArray());
                view.hideManagerPanel();
                save();
                updateTable();
                break;

            case "SHOW_MODDING_PANEL":
                if (view.getCardsPanel().getTablePanel().getTargetedRow() == -1) {
                    view.getCardsPanel().getTablePanel().getLittleMenu().setTargetedField("Recordatorio sin seleccionar");
                } else {
                    view.showManagerPanelForModding(calendar.getReminders().get(view.getCardsPanel().getTablePanel().getTargetedRow()));
                }
                break;

            case "MODIFY_REMINDER":
                calendar.modifyReminder(view.getCardsPanel().getTablePanel().getTargetedRow(), view.getManagerPanel().getInfoInAnArray());
                view.hideManagerPanel();
                updateTable();
                save();
                break;


            case "DELETE_REMINDER":
                if (view.getCardsPanel().getTablePanel().getTargetedRow() == -1) {
                    view.getCardsPanel().getTablePanel().getLittleMenu().setTargetedField("Recordatorio sin seleccionar");
                } else {
                    calendar.deleteReminder(view.getCardsPanel().getTablePanel().getTargetedRow());
                    view.getCardsPanel().getTablePanel().resetTarget();
                    updateTable();
                    save();
                }
                break;

            case "SHOW_ORDINANCE_PANEL":
                view.setVisibleOrdinancePanel(true);
                break;

            case "PRIORITY_ORDINANCE":
                calendar.sortTable(0);
                updateTable();
                view.setVisibleOrdinancePanel(false);
                break;

            case "LEXICOGRAPHIC_ORDINANCE":
                calendar.sortTable(5);
                updateTable();
                view.setVisibleOrdinancePanel(false);
                break;

            case "START_DATE_ORDINANCE":
                calendar.sortTable(1);
                updateTable();
                view.setVisibleOrdinancePanel(false);
                break;

            case "FINAL_DATE_ORDINANCE":
                calendar.sortTable(2);
                updateTable();
                view.setVisibleOrdinancePanel(false);
                break;

            case "START_TIME_ORDINANCE":
                calendar.sortTable(3);
                updateTable();
                view.setVisibleOrdinancePanel(false);
                break;

            case "FINAL_TIME_ORDINANCE":
                calendar.sortTable(4);
                updateTable();
                view.setVisibleOrdinancePanel(false);
                break;


            case "SAVE_CONFIGURATIONS":
                calendar.getConfigs().setColors(view.getColors());
                view.showRestartMessage();
                break;

            case "RESET_CONFIGURATIONS":
                calendar.getConfigs().resetColors();
                view.showRestartMessage();
                break;

            case "exit":
                System.exit(0);
                break;
        }
    }
}
