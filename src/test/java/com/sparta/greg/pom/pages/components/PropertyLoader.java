package com.sparta.greg.pom.pages.components;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyLoader {

    public static Properties properties = new Properties();

    public static void loadProperties() {

        try {
            properties.load(new FileReader("src/test/resources/login.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
