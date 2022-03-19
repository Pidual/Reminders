package models;

import java.awt.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Configurations {

    private Properties properties;

    public Configurations() {
        loadPersonalizedConfigs();
    }

    private void loadPersonalizedConfigs() {
        properties = new Properties();
        try {
            properties.load(new FileReader("data/configurations.properties"));
        } catch (IOException e) {
            System.out.println("Error al cargar colores iniciando Default");
        }
    }
    public ArrayList<Color> getColors() {
        ArrayList<Color> colors = new ArrayList<>();
        colors.add(parse(properties.getProperty("colorMenu")));
        colors.add(parse(properties.getProperty("colorBackground")));
        colors.add(parse(properties.getProperty("colorButtons")));
        colors.add(parse(properties.getProperty("colorFont")));
        colors.add(parse(properties.getProperty("colorLowPrio")));
        colors.add(parse(properties.getProperty("colorMediumPrio")));
        colors.add(parse(properties.getProperty("colorHighPrio")));
        return colors;
    }

    public void setColors(ArrayList<Color> colors) {
        properties.setProperty("colorMenu", colorToString(colors.get(0)));
        properties.setProperty("colorBackground", colorToString(colors.get(1)));
        properties.setProperty("colorButtons", colorToString(colors.get(2)));
        properties.setProperty("colorFont", colorToString(colors.get(3)));
        properties.setProperty("colorLowPrio", colorToString(colors.get(4)));
        properties.setProperty("colorMediumPrio", colorToString(colors.get(5)));
        properties.setProperty("colorHighPrio", colorToString(colors.get(6)));
        try {
            properties.store(new FileWriter("data/configurations.properties"), null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void resetColors() {
        ArrayList<Color> defaultColors = new ArrayList<>();
        defaultColors.add(new Color(0, 45, 89));
        defaultColors.add(new Color(155, 193, 188));
        defaultColors.add(new Color(11, 78, 111));
        defaultColors.add(new Color(0, 0, 0));
        defaultColors.add(new Color(97, 255, 92));
        defaultColors.add(new Color(230, 175, 46));
        defaultColors.add(new Color(237, 90, 104));
        setColors(defaultColors);
    }

    private String colorToString(Color color) {
        return color.getRed() + "," + color.getGreen() + "," + color.getBlue();
    }

    private Color parse(String input) {
        Pattern c = Pattern.compile("([0-9]+),*([0-9]+),*([0-9]+)");
        Matcher m = c.matcher(input);
        if (m.matches()) {
            return new Color(Integer.valueOf(m.group(1)),  // r
                    Integer.valueOf(m.group(2)),  // g
                    Integer.valueOf(m.group(3))); // b
        }
        return Color.magenta;
    }
}
