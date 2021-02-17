package com.sparta.greg.pom.pagesTest.trainee;

import com.sparta.greg.pom.pages.components.Login;
import com.sparta.greg.pom.pages.components.PropertyLoader;
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

    @Before
    public void setup() {
        webDriver = new ChromeDriver();
        webDriver.get("http://localhost:8080/login");
        PropertyLoader.loadProperties();
        String traineeUsername = PropertyLoader.properties.getProperty("trainerUsername");
        String traineePassword = PropertyLoader.properties.getProperty("trainerPassword");
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
