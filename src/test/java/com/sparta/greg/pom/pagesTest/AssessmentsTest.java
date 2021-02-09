package com.sparta.greg.pom.pagesTest;

import com.sparta.greg.pom.pages.Assessments;
import com.sparta.greg.pom.pages.Login;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class AssessmentsTest {

    private static WebDriver webDriver;
    private static Login loginPage;
    private static Home homePage;
    private static Assessments assessmentsPage;
    private static Properties properties;
    private static String usernameTrainer;
    private static String passwordTrainer;

    @BeforeEach
    void setup() {
        webDriver = new ChromeDriver();
        loginPage = new Login(webDriver);

        // Name of properties file to change depending on what is sent by Ben

        try {
            properties.load(new FileReader("src/test/resources/login.properties"));
            usernameTrainer = properties.getProperty("trainerUsername");
            passwordTrainer = properties.getProperty("trainerPassword");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    void canClickFirstTrainee() {

        loginPage.enterUsernameAddress(usernameTrainer);
        loginPage.enterPassword(passwordTrainer);
        homePage = loginPage.clickSubmitButton();
        assessmentsPage = homePage.goToAssessments();
        Assertions.assertDoesNotThrow(assessmentsPage.clickTrainee(assessmentsPage.selectFirstTrainee()));
    }



    @AfterEach
    void close() {webDriver.close();}




}
