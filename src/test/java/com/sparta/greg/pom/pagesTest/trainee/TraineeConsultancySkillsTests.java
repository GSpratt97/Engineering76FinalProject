package com.sparta.greg.pom.pagesTest.trainee;

import com.sparta.greg.pom.pages.Login;
import com.sparta.greg.pom.pages.utilities.PropertyLoader;
import com.sparta.greg.pom.pages.trainee.TraineeConsultancySkills;
import com.sparta.greg.pom.webDriverFactory.WebDriverFactory;
import com.sparta.greg.pom.webDriverFactory.WebDriverType;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

public class TraineeConsultancySkillsTests {

    private static WebDriver webDriver;
    private static TraineeConsultancySkills traineeConsultancySkills;

    @Before
    public void setup() {
        webDriver = WebDriverFactory.getWebDriver(WebDriverType.CHROME);
        webDriver.get("http://localhost:8080/login");
        Login login = new Login(webDriver);
        PropertyLoader.loadProperties();
        String traineeUsername = PropertyLoader.properties.getProperty("traineeUsername");
        String traineePassword = PropertyLoader.properties.getProperty("traineePassword");
        login.logInAsTrainee(traineeUsername, traineePassword);
        webDriver.get("http://localhost:8080/consultancy");
        traineeConsultancySkills = new TraineeConsultancySkills(webDriver);

//        webDriver = new ChromeDriver();
//        webDriver.get("http://localhost:8080/login");
//        PropertyLoader.loadProperties();
//        String traineeUsername = PropertyLoader.properties.getProperty("trainerUsername");
//        String traineePassword = PropertyLoader.properties.getProperty("trainerPassword");
//        Login login = new Login(webDriver);
//        login.logInAsTrainer(traineeUsername, traineePassword);
//
//        webDriver.get("http://localhost:8080/consultancy");
//        traineeConsultancySkills = new TraineeConsultancySkills(webDriver);
    }

    @Test
    @DisplayName("Click back to profile button on consultancy skills")
    public void clickBackToProfileButtonOnConsultancySkillsTrainerLogin() {
        traineeConsultancySkills.clickBackToProfileButtonOnConsultancySkillsTraineeLogin();
        Assertions.assertEquals("http://localhost:8080/trainer/home",webDriver.getCurrentUrl());
    }
}
