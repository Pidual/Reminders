package Persistence;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import models.Reminder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

public class FileOperation {
    String path;
    Gson gson;

    public FileOperation(String path) {
        this.path = path;
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(LocalDate.class, new LocalDateAdapter());
        builder.registerTypeAdapter(LocalTime.class, new LocalTimeAdapter());
        builder.setPrettyPrinting();
        gson = builder.create();
    }

    public void save(ArrayList<Reminder> data) {
        String json = gson.toJson(data);
        try {
            PrintWriter printWriter = new PrintWriter(path);
            printWriter.write(json);
            printWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error en la escritura en FileWriter");
        }
    }

    public ArrayList<Reminder> load() {
        Reminder[] reminders = null;
        try {
            JsonReader reader = new JsonReader(new FileReader(path));
            reminders = gson.fromJson(reader, Reminder[].class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assert reminders != null;
        return new ArrayList<>(Arrays.asList(reminders));
    }
}
