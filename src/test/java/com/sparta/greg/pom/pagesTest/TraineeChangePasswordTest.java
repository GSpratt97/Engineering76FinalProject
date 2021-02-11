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

public class TraineeChangePasswordTest {

    private static final Properties properties = new Properties();
    private static Login login;
    private static WebDriver webDriver;
    private static String traineeUsername;
    private static String traineePassword;

    @BeforeEach
    void setup() {
        webDriver = new ChromeDriver();
        login = new Login(webDriver);


        try {
            properties.load(new FileReader("src/test/resources/login.properties"));
            traineeUsername = properties.getProperty("traineeUsername");
            traineePassword = properties.getProperty("traineePassword");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    void changePasswordAsTraineeReturnsHomeTrainee() {
        login.logInAsTrainee(traineeUsername, traineePassword);
        webDriver.get("http://localhost:8080/changePassword");
        TraineeChangePassword traineeChangePassword = new TraineeChangePassword(webDriver);
        HomeTrainee homeTrainee = traineeChangePassword.changePassword(traineePassword, "new");
        Assertions.assertEquals(HomeTrainee.class, homeTrainee.getClass());
    }
}
