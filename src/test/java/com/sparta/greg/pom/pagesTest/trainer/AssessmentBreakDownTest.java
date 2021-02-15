package com.sparta.greg.pom.pagesTest.trainer;

import com.sparta.greg.pom.pages.components.PropertyLoader;
import com.sparta.greg.pom.pages.trainer.AssessmentBreakdown;
import com.sparta.greg.pom.pages.components.Login;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class
AssessmentBreakDownTest {
    private static WebDriver webDriver;
    private static String usernameTrainer;
    private static String passwordTrainer;
    private static AssessmentBreakdown assessmentBreakdownPage;

    @BeforeEach
    public void setup() {
        webDriver = new ChromeDriver();
        webDriver.get("http://localhost:8080/login");
        PropertyLoader.loadProperties();
        usernameTrainer = PropertyLoader.properties.getProperty("trainerUsername");
        passwordTrainer = PropertyLoader.properties.getProperty("trainerPassword");
        Login login = new Login(webDriver);
        login.logInAsTrainer(usernameTrainer, passwordTrainer);
        webDriver.get("http://localhost:8080/trainer/assessments/41");
        assessmentBreakdownPage = new AssessmentBreakdown(webDriver);
    }

    @Test
    @DisplayName("Test the first click plus icon")
    void clickFirstPlusIcon() {
        assessmentBreakdownPage.clickPlusIconFirstModule();
        Assertions.assertEquals(webDriver.findElement(By.cssSelector("tr[href*='collapseSQL']")).getText(),"SQL 30.9% FAIL 11/22/2019");
    }

    @Test
    @DisplayName("Test the second click plus icon")
    void clickSecondPlusIcon() {
        assessmentBreakdownPage.clickPlusIconSecondModule();
        Assertions.assertEquals(webDriver.findElement(By.cssSelector("tr[href*='collapseNotSQL']")).getText(),"NotSQL 78.0% B- 11/22/2019");

    }

    @AfterEach
	void close(){
        webDriver.quit();
	}
}
