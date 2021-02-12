package com.sparta.greg.pom.pagesTest.trainer;

import com.sparta.greg.pom.pages.components.Login;
import com.sparta.greg.pom.pages.trainer.ReportTrainer;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReportTrainerTest {

    private static final Properties     properties = new Properties();

    private static       Login          login;
    private static       ReportTrainer  reportTrainer;
    private static       WebDriver      webDriver;

    private static       String         trainerUsername;
    private static       String         trainerPassword;

    @BeforeEach
    void setup() {
        webDriver = new ChromeDriver();
        login     = new Login(webDriver);

        try {
            properties.load(new FileReader("src/test/resources/login.properties"));
            trainerUsername = properties.getProperty("traineeUsername");
            trainerPassword = properties.getProperty("traineePassword");
        } catch (IOException e) {
            e.printStackTrace();
        }

        login.logInAsTrainer(trainerUsername, trainerPassword);
        webDriver.get("http://localhost:8080/trainer/report/41"); //Bill Bird

        reportTrainer = new ReportTrainer(webDriver);
        reportTrainer.setWeekReports();
    }

    @AfterEach
    void closeWindow() {
        webDriver.close();
    }

    @Test
    @DisplayName("Does http://localhost:8080/trainer/report/41 load to WebDriver on class instantiation?")
    void isReportTrainerPageLoaded() {
        Assertions.assertEquals("http://localhost:8080/trainer/report/41", reportTrainer.getURL());
    }

    @Test
    @DisplayName("Does the first 'expand' button expand its weekly report?")
    void doesReportExpand() {
        Assertions.assertTrue(reportTrainer.doesExpandButtonExpand(reportTrainer.getWeekReports().get(0)));
    }

    @Test
    @DisplayName("Does the first 'expand' button collapse its weekly report?")
    void doesReportCollapse() {
        Assertions.assertTrue(reportTrainer.doesExpandButtonCollapse(reportTrainer.getWeekReports().get(0)));
    }

    @Test
    @DisplayName("Do all 'expand' buttons expand their weekly report and collapse it?")
    void doAllReportsExpandAndCollapse() {
        Assertions.assertTrue(reportTrainer.doAllExpandButtonsWork());
    }

    @Test
    @DisplayName("Do week numbers descend chronologically?")
    void isWeekNumberCorrect() {
        Assertions.assertTrue(reportTrainer.isWeekNumberCorrect());
    }

    @Test
    @DisplayName("Does the 'Back To Trainee Profile' button navigate to the previous page?")
    void canNavigateBackToTraineeProfile() {
        reportTrainer.backToTraineeProfile();
        Assertions.assertEquals("http://localhost:8080/trainer/traineeProfile/41", reportTrainer.getURL());
    }

    @AfterAll
    static void tearDown() {
        webDriver.quit();
    }
}
