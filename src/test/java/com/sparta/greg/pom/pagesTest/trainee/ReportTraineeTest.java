package com.sparta.greg.pom.pagesTest.trainee;

import com.sparta.greg.pom.pages.components.Login;
import com.sparta.greg.pom.pages.components.PropertyLoader;
import com.sparta.greg.pom.pages.trainee.ReportTrainee;
import io.cucumber.java.bs.A;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

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

        webDriver.get("http://localhost:8080/");

        PropertyLoader.loadProperties();
        String traineeUsername = PropertyLoader.properties.getProperty("traineeUsername");
        String traineePassword = PropertyLoader.properties.getProperty("traineePassword");

        login.logInAsTrainee(traineeUsername, traineePassword);
        webDriver.get("http://localhost:8080/trainee/report");

        reportTrainee = new ReportTrainee(webDriver);
        reportTrainee.setWeekReports();
        reportTrainee.setReportDataForWeek(12);
    }

    @AfterEach
    void closeWindow() {
        webDriver.close();
    }

    @Test
    @DisplayName("Does http://localhost:8080/trainee/report load to WebDriver on class instantiation?")
    void isReportTraineePageLoaded() {
        Assertions.assertEquals("http://localhost:8080/trainee/report", reportTrainee.getURL());
    }

    @Test
    @DisplayName("Does the first 'expand' button expand its weekly report?")
    void doesReportExpand() {
        Assertions.assertTrue(reportTrainee.doesExpandButtonExpand(reportTrainee.getWeekReports().get(0)));
    }

    @Test
    @DisplayName("Does the first 'expand' button collapse its weekly report?")
    void doesReportCollapse() {
        Assertions.assertTrue(reportTrainee.doesExpandButtonCollapse(reportTrainee.getWeekReports().get(0)));
    }

    @Test
    @DisplayName("Do all 'expand' buttons expand their weekly report and collapse it?")
    void doAllReportsExpandAndCollapse() {
        Assertions.assertTrue(reportTrainee.doAllExpandButtonsWork());
    }

    @Test
    @DisplayName("Do week numbers descend chronologically?")
    void isWeekNumberCorrect() {
        Assertions.assertTrue(reportTrainee.isWeekNumberCorrect());
    }

    @Test
    @DisplayName("Are the grades correct for Bill Bird's Week 12 report?")
    void areMainGradesCorrectForWeekTwelve() {
        Assertions.assertEquals("A", reportTrainee.getOverallGrade());
        Assertions.assertEquals("A", reportTrainee.getTechnicalGrade());
        Assertions.assertEquals("B", reportTrainee.getConsultantGrade());
    }

    @Test
    @DisplayName("Are the Start, Stop, Continues correct for Bill Bird's Week 12 report?")
    void areSscCorrectForWeekTwelve() {
        reportTrainee.clickExpandButton(reportTrainee.getWeekReports().get(0));
        reportTrainee.waitForClick();

        Assertions.assertEquals("Start This", reportTrainee.getTraineeStart());
        Assertions.assertEquals("Stop That", reportTrainee.getTraineeStop());
        Assertions.assertEquals("Continue Everything Else!", reportTrainee.getTraineeContinue());
    }

    @Test
    @DisplayName("Are the Bill Bird's Feedback Form grades correct for Week 12?")
    void areTraineeGradesCorrectForWeekTwelve() {
        reportTrainee.clickExpandButton(reportTrainee.getWeekReports().get(0));
        reportTrainee.waitForClick();

        Assertions.assertEquals("B", reportTrainee.getTraineeTechnicalGrade());
        Assertions.assertEquals("B", reportTrainee.getTraineeConsultantGrade());
    }

    @Test
    @DisplayName("Are the Trainer's Start, Stop, Continues correct for Bill Bird's Week 12 report?")
    void areTrainerSscCorrectForWeekTwelve() {
        reportTrainee.clickExpandButton(reportTrainee.getWeekReports().get(0));
        reportTrainee.waitForClick();

        Assertions.assertEquals("Start This", reportTrainee.getTrainerStart());
        Assertions.assertEquals("Stop That", reportTrainee.getTrainerStop());
        Assertions.assertEquals("Continue Everything Else", reportTrainee.getTrainerContinue());
    }

    @Test
    @DisplayName("Are the Trainer's Feedback grades correct for Week 12?")
    void areTrainerGradesCorrectForWeekTwelve() {
        reportTrainee.clickExpandButton(reportTrainee.getWeekReports().get(0));
        reportTrainee.waitForClick();

        Assertions.assertEquals("A", reportTrainee.getTrainerOverallGrade());
        Assertions.assertEquals("A", reportTrainee.getTrainerTechnicalGrade());
        Assertions.assertEquals("B", reportTrainee.getTrainerConsultantGrade());
    }

    @Test
    @DisplayName("Are the Trainer's comments correct for Week 12?")
    void isTrainerCommentsCorrectForWeekTwelve() {
        reportTrainee.clickExpandButton(reportTrainee.getWeekReports().get(0));
        reportTrainee.waitForClick();

        Assertions.assertEquals("Trainer Comments", reportTrainee.getTrainerComments());
    }

    @Test
    @DisplayName("Is the Deadline correct for Week 12?")
    void isDeadlineCorrectForWeekTwelve() {
        reportTrainee.clickExpandButton(reportTrainee.getWeekReports().get(0));
        reportTrainee.waitForClick();

        Assertions.assertEquals("11/12/2020 - 5:30 PM", reportTrainee.getDeadline());
    }

    @Test
    @DisplayName("Is the Last Edited correct for Week 12?")
    void isLastEditedCorrectForWeekTwelve() {
        reportTrainee.clickExpandButton(reportTrainee.getWeekReports().get(0));
        reportTrainee.waitForClick();

        Assertions.assertEquals("10/12/2020 - 5:00 PM", reportTrainee.getLastEdited());
    }

    @AfterAll
    static void tearDown() {
        webDriver.quit();
    }
}
