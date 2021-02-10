package com.sparta.greg.pom.pagesTest;

import com.sparta.greg.pom.pages.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class TrainerChangePasswordTest {

    private static final Properties properties = new Properties();
    private static Login login;
    private static WebDriver webDriver;
    private static String trainerUsername;
    private static String trainerPassword;
    private static HomeTrainer homeTrainer;
    private static TrainerChangePassword trainerChangePassword;

    @BeforeEach
    void setup() {
        webDriver = new ChromeDriver();
        login = new Login(webDriver);


        try {
            properties.load(new FileReader("src/test/resources/login.properties"));
            trainerUsername = properties.getProperty("trainerUsername");
            trainerPassword = properties.getProperty("trainerPassword");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


//    I don't know what this method is supposed to return because cannot change password, but made an educated guess
    @Test
    void changePasswordAsTrainerReturnsHomeTrainer() {
        homeTrainer = login.logInAsTrainer(trainerUsername, trainerPassword);
        webDriver.get("http://localhost:8080/changePassword");
        trainerChangePassword = new TrainerChangePassword(webDriver);
        HomeTrainer homeTrainer = trainerChangePassword.changeTrainerPassword(trainerPassword, "new");
        Assertions.assertEquals("http://localhost:8080/trainer/home", webDriver.getCurrentUrl());
    }

}
