package views;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

import static views.GraphicalUserInterface.*;

public class BarChart extends JPanel {

    private Graphics2D g2d;
    private String[][] data;
    private int maxDataValue;
    private int numColumns;
    private final int maxHeight = 650;
    private final int maxWidth = 580;
    private int columWidth;

    public BarChart(){
        this.setBackground(colorBackground);
    }

    public void paint(Graphics g) {
        g2d = (Graphics2D) g;
        int currentX = 10;
        int currentY;

        for (int i = 0; i < numColumns; i++) {
            currentY = maxHeight - calculateBarHeight(data[i][1]);
            if (i == 0) {
                g2d.setColor(colorLowPrio);
            } else if (i == 1) {
                g2d.setColor(colorMediumPrio);
            } else {
                g2d.setColor(colorHighPrio);
            }
            g2d.fillRect(currentX, currentY, columWidth - 2, calculateBarHeight(data[i][1]));
            g2d.setColor(Color.BLACK);
            g2d.drawString(data[i][0] + " - " + data[i][1], currentX + 10, currentY + 10);
            currentX = currentX + (maxWidth / numColumns);
        }
        g2d.drawLine(10, 10, 10, maxHeight);
        g2d.drawLine(10, maxHeight, maxWidth, maxHeight);
    }

    public void setDataAndSetMaxValue(String[][] data) {
        this.data = data;
        int maxDataValue = 0;
        int numColums = 0;
        for (String[] datum : data) { //Este loop nos saca el numero de columnas y el valor maximo
            numColums++;
            int aux = Integer.parseInt(datum[1]);
            if (aux > maxDataValue) {
                maxDataValue = aux;
            }
        }
        this.maxDataValue = maxDataValue;
        this.numColumns = numColums;
        this.columWidth = maxWidth / numColumns;
    }

    public int calculateBarHeight(String value) { //Hace una regla de 3 para medir la longitud de las barras
        return (maxHeight * Integer.parseInt(value)) / maxDataValue - 10; // Se le resta 10 para que se vea aestetic
    }
}
