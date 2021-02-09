package com.sparta.greg.pom.pagesTest;

import com.sparta.greg.pom.pages.Login;
import com.sparta.greg.pom.pages.ReportTrainee;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReportTraineeTest {

    private static final    Properties      properties = new Properties();
    private static          Login           login;
    private static          ReportTrainee   reportTrainee;
    private static          WebDriver       webDriver;
    private static          String          traineeUsername;
    private static          String          traineePassword;

    @BeforeEach
    void setup() {
        webDriver = new ChromeDriver();
        login     = new Login(webDriver);

        try {
            properties.load(new FileReader("src/test/resources/login.properties"));
            traineeUsername = properties.getProperty("traineeUsername");
            traineePassword = properties.getProperty("traineePassword");
        } catch (IOException e) {
            e.printStackTrace();
        }

        login.enterUsernameAddress(traineeUsername);
        login.enterPassword(traineePassword);
        login.clickSubmitButton();

        reportTrainee = new ReportTrainee(webDriver);
        reportTrainee.setWeekReports();
    }

    @AfterEach
    void closeWindow() {
        webDriver.close();
    }

    @Test
    @DisplayName("Does http://localhost:8080/trainee/report load to WebDriver on class instantiation?")
    void isReportTraineePageLoaded() {
        Assertions.assertEquals("http://localhost:8080/trainee/report", reportTrainee.getUrl());
    }

    @Test
    @DisplayName("Does the 'expand' button expand a weekly report?")
    void doesReportExpand() {
        Assertions.assertTrue(reportTrainee.doesExpandButtonExpand(reportTrainee.getWeekReports().get(0)));
    }

    @Test
    @DisplayName("Does the 'expand' button collapse a weekly report?")
    void doesReportCollapse() {
        Assertions.assertTrue(reportTrainee.doesExpandButtonCollapse(reportTrainee.getWeekReports().get(0)));
    }

    @Test
    @DisplayName("Do week numbers descend chronologically?")
    void isWeekNumberCorrect() {
        Assertions.assertTrue(reportTrainee.isWeekNumberCorrect());
    }

    @AfterAll
    static void tearDown() {
        webDriver.quit();
    }
}
