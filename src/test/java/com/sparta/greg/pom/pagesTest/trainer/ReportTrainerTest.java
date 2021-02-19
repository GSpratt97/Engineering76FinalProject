package com.sparta.greg.pom.pagesTest.trainer;

import com.sparta.greg.pom.pages.Login;
import com.sparta.greg.pom.pages.utilities.PropertyLoader;
import com.sparta.greg.pom.pages.trainer.ReportTrainer;
import com.sparta.greg.pom.webDriverFactory.WebDriverFactory;
import com.sparta.greg.pom.webDriverFactory.WebDriverType;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

public class ReportTrainerTest {

    private static       Login          login;
    private static       ReportTrainer  reportTrainer;
    private static       WebDriver      webDriver;

    @BeforeEach
    void setup() {
        webDriver = WebDriverFactory.getWebDriver(WebDriverType.CHROME);
        webDriver.get("http://localhost:8080/login");
        login     = new Login(webDriver);

        PropertyLoader.loadProperties();
        String trainerUsername = PropertyLoader.properties.getProperty("trainerUsername");
        String trainerPassword = PropertyLoader.properties.getProperty("trainerPassword");

        login.logInAsTrainer(trainerUsername, trainerPassword);
        webDriver.get("http://localhost:8080/trainer/report/41"); //Bill Bird

        reportTrainer = new ReportTrainer(webDriver);
        reportTrainer.setWeekReports();
        reportTrainer.setReportDataForWeek(12);
    }

    @AfterEach
    void closeWindow() {
        webDriver.close();
    }

    @Test
    @DisplayName("Is SidebarTrainer object set?")
    void isSidebarSet() {
        Assertions.assertNotNull(reportTrainer.getSideBarTrainer());
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

    @Test
    @DisplayName("Are the grades correct for Bill Bird's Week 12 report?")
    void areMainGradesCorrectForWeekTwelve() {
        Assertions.assertEquals("A", reportTrainer.getOverallGrade());
        Assertions.assertEquals("A", reportTrainer.getTechnicalGrade());
        Assertions.assertEquals("B", reportTrainer.getConsultantGrade());
    }

    @Test
    @DisplayName("Are the Start, Stop, Continues correct for Bill Bird's Week 12 report?")
    void areSscCorrectForWeekTwelve() {
        reportTrainer.clickExpandButton(reportTrainer.getWeekReports().get(0));
        reportTrainer.waitForClick();

        Assertions.assertEquals("Start This", reportTrainer.getTraineeStart());
        Assertions.assertEquals("Stop That", reportTrainer.getTraineeStop());
        Assertions.assertEquals("Continue Everything Else!", reportTrainer.getTraineeContinue());
    }

    @Test
    @DisplayName("Are the Bill Bird's Feedback Form grades correct for Week 12?")
    void areTraineeGradesCorrectForWeekTwelve() {
        reportTrainer.clickExpandButton(reportTrainer.getWeekReports().get(0));
        reportTrainer.waitForClick();

        Assertions.assertEquals("B", reportTrainer.getTraineeTechnicalGrade());
        Assertions.assertEquals("B", reportTrainer.getTraineeConsultantGrade());
    }

    @Test
    @DisplayName("Are the Trainer's Start, Stop, Continues correct for Bill Bird's Week 12 report?")
    void areTrainerSscCorrectForWeekTwelve() {
        reportTrainer.clickExpandButton(reportTrainer.getWeekReports().get(0));
        reportTrainer.waitForClick();

        Assertions.assertEquals("Start This", reportTrainer.getTrainerStart());
        Assertions.assertEquals("Stop That", reportTrainer.getTrainerStop());
        Assertions.assertEquals("Continue Everything Else", reportTrainer.getTrainerContinue());
    }

    @Test
    @DisplayName("Are the Trainer's Feedback grades correct for Week 12?")
    void areTrainerGradesCorrectForWeekTwelve() {
        reportTrainer.clickExpandButton(reportTrainer.getWeekReports().get(0));
        reportTrainer.waitForClick();

        Assertions.assertEquals("A", reportTrainer.getTrainerOverallGrade());
        Assertions.assertEquals("A", reportTrainer.getTrainerTechnicalGrade());
        Assertions.assertEquals("B", reportTrainer.getTrainerConsultantGrade());
    }

    @Test
    @DisplayName("Are the Trainer's comments correct for Week 12?")
    void isTrainerCommentsCorrectForWeekTwelve() {
        reportTrainer.clickExpandButton(reportTrainer.getWeekReports().get(0));
        reportTrainer.waitForClick();

        Assertions.assertEquals("Trainer Comments", reportTrainer.getTrainerComments());
    }

    @Test
    @DisplayName("Is the Deadline correct for Week 12?")
    void isDeadlineCorrectForWeekTwelve() {
        reportTrainer.clickExpandButton(reportTrainer.getWeekReports().get(0));
        reportTrainer.waitForClick();

        Assertions.assertEquals("11/12/2020 - 5:30 PM", reportTrainer.getDeadline());
    }

    @Test
    @DisplayName("Is the Last Edited correct for Week 12?")
    void isLastEditedCorrectForWeekTwelve() {
        reportTrainer.clickExpandButton(reportTrainer.getWeekReports().get(0));
        reportTrainer.waitForClick();

        Assertions.assertEquals("10/12/2020 - 5:00 PM", reportTrainer.getLastEdited());
    }

    @AfterAll
    static void tearDown() {
        webDriver.quit();
    }
}
