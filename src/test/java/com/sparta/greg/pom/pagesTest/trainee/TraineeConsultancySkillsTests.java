package com.sparta.greg.pom.pagesTest.trainee;

import com.sparta.greg.pom.pages.components.Login;
import com.sparta.greg.pom.pages.trainee.TraineeConsultancySkills;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class TraineeConsultancySkillsTests {

    private static WebDriver webDriver;
    private static TraineeConsultancySkills traineeConsultancySkills;
    private static String traineeUsername;
    private static String traineePassword;

    @Before
    public void setup() {
        Properties properties = new Properties();
        webDriver = new ChromeDriver();
        webDriver.get("http://localhost:8080/login");

        try {
            properties.load(new FileReader("src/test/resources/login.properties"));
            traineeUsername = properties.getProperty("traineeUsername");
            traineePassword = properties.getProperty("traineePassword");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Login login = new Login(webDriver);
        login.logInAsTrainer(traineeUsername, traineePassword);

        webDriver.get("http://localhost:8080/consultancy");
        traineeConsultancySkills = new TraineeConsultancySkills(webDriver);
    }

    @Test
    @DisplayName("Click back to profile button on consultancy skills")
    public void clickBackToProfileButtonOnConsultancySkillsTrainerLogin() {
        traineeConsultancySkills.clickBackToProfileButtonOnConsultancySkillsTraineeLogin();
        Assertions.assertEquals("http://localhost:8080/trainer/home",webDriver.getCurrentUrl());
    }
}
