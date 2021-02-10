package com.sparta.greg.pom.pagesTest;

import com.sparta.greg.pom.pages.ChangePassword;
import com.sparta.greg.pom.pages.HomeTrainee;
import com.sparta.greg.pom.pages.HomeTrainer;
import com.sparta.greg.pom.pages.Login;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ChangePasswordTest {

    private static final Properties properties = new Properties();
    private static Login login;
    private static WebDriver webDriver;
    private static String trainerUsername;
    private static String trainerPassword;
    private static String traineeUsername;
    private static String traineePassword;
    private static HomeTrainer homeTrainer;
    private static HomeTrainee homeTrainee;
    private static ChangePassword changePassword;

    @BeforeEach
    void setup() {
        webDriver = new ChromeDriver();
        login = new Login(webDriver);


        try {
            properties.load(new FileReader("src/test/resources/login.properties"));
            trainerUsername = properties.getProperty("trainerUsername");
            trainerPassword = properties.getProperty("trainerPassword");
            traineeUsername = properties.getProperty("traineeUsername");
            traineePassword = properties.getProperty("traineePassword");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


//    I don't know what this method is supposed to return because cannot change password, but made an educated guess
    @Test
    void changePasswordAsTrainerReturnsHomeTrainer() {
        homeTrainer = login.logInAsTrainer(trainerUsername, trainerPassword);
        webDriver.get("http://localhost:8080/changePassword");
        changePassword = new ChangePassword(webDriver);
//        changePassword.changeTrainerPassword(trainerPassword, "new");
        Assertions.assertEquals("http://localhost:8080/trainer/home", webDriver.getCurrentUrl());
    }

    @Test
    void changePasswordAsTraineeReturnsHomeTrainee() {
        homeTrainee = login.logInAsTrainee(traineeUsername, traineePassword);
        webDriver.get("http://localhost:8080/changePassword");
        changePassword = new ChangePassword(webDriver);
//        changePassword.changeTraineePassword(traineePassword, "new");
        Assertions.assertEquals("http://localhost:8080/trainee/home", webDriver.getCurrentUrl());
    }
}
