package com.sparta.greg.pom.pagesTest.components;

import com.sparta.greg.pom.pages.trainer.HomeTrainer;
import com.sparta.greg.pom.pages.components.Login;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PageTest {
    private static WebDriver webDriver = new ChromeDriver();
    private static Login loginPage;
    private static Properties properties;
    private static String username;
    private static String password;
    private static HomeTrainer homeTrainer;

    @BeforeEach
    void setup() {
        webDriver = new ChromeDriver();
        loginPage = new Login(webDriver);
        properties = new Properties();
        // Name of properties file to change depending on what is sent by Ben

        try {
            properties.load(new FileReader("src/test/resources/login.properties"));
            username = properties.getProperty("username");
            password = properties.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }
        homeTrainer = loginPage.logInAsTrainer(username, password);
    }

}
