package ru.luxsoft.task.averagevowels.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class ResourceReader {

    private final Properties properties;
    private final String input;
    private final String output;

    public ResourceReader() {
        try (InputStream inputStream =
                     ResourceReader.class.getClassLoader().getResourceAsStream("default.properties")) {
            this.properties = new Properties();
            this.properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        input = properties.getProperty("input");
        output = properties.getProperty("output");
    }

    public String getInput() {
        return input;
    }

    public String getOutput() {
        return output;
    }
}
