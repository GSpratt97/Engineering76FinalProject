package com.sparta.greg.pom.pagesTest.trainer;

import com.sparta.greg.pom.pages.components.Login;
import com.sparta.greg.pom.pages.trainer.HomeTrainer;
import com.sparta.greg.pom.pages.trainer.TrainerChangePassword;
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


    @Test
    void changePasswordAsTrainerReturnsHomeTrainer() {
        login.logInAsTrainer(trainerUsername, trainerPassword);
        webDriver.get("http://localhost:8080/changePassword");
        TrainerChangePassword trainerChangePassword = new TrainerChangePassword(webDriver);
        HomeTrainer homeTrainer = trainerChangePassword.changePassword(trainerPassword, "new");
        Assertions.assertEquals(HomeTrainer.class, homeTrainer.getClass());
    }

}
