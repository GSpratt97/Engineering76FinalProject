package com.sparta.greg.cucumber.stepdefs;

import com.sparta.greg.pom.pages.Login;
import com.sparta.greg.pom.pages.utilities.PropertyLoader;
import com.sparta.greg.pom.pages.trainee.FeedbackForm;
import com.sparta.greg.pom.webDriverFactory.WebDriverFactory;
import com.sparta.greg.pom.webDriverFactory.WebDriverType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class FeedbackFormStepdefs {

    private Properties properties;
    private WebDriver webDriver = WebDriverFactory.getWebDriver(WebDriverType.FIREFOX);

    private Login login;

    private FeedbackForm feedbackForm;


    private boolean start;
    private boolean stop;
    private boolean continueBoolean;

    private boolean selectTechnical;
    private boolean selectConsultant;

    @Given("I am logged in as a trainee on the Feedback Page")
    public void iAmLoggedInATraineeOnTheFeedbackPage() {
        properties = PropertyLoader.properties;
        PropertyLoader.loadProperties();
        webDriver.get("http://localhost:8080/login");
        login = new Login(webDriver);
        feedbackForm = new FeedbackForm(webDriver);
        login.logInAsTrainee(properties.getProperty("traineeUsername"), properties.getProperty("traineePassword"));

        feedbackForm.getSideBarTrainee().clickTraineeOptions();
        feedbackForm.getSideBarTrainee().goToFeedbackForm();

    }

    @When("I update my start, stop, continue on the Feedback Page")
    public void iUpdateMyStartStopContinueOnTheFeedbackPage() {
        stop = feedbackForm.enterStop("Entering stop", 20);
        start = feedbackForm.enterStart("Entering start", 20);
        continueBoolean = feedbackForm.enterContinue("Entering continue", 20);
    }

    @Then("The text should update on the Feedback Page")
    public void theTextShouldUpdateOnTheFeedbackPage() {
        Assertions.assertTrue(stop);
        Assertions.assertTrue(start);
        Assertions.assertTrue(continueBoolean);
        webDriver.quit();
    }

    @When("I select a technical grade on the Feedback Page")
    public void iSelectATechnicalGradeOnTheFeedbackPage() {
        selectTechnical = feedbackForm.isTechnicalGradeSelected("c");
    }

    @Then("The technical grade should be selected on the Feedback Page")
    public void theTechnicalGradeShouldBeSelectedOnTheFeedbackPage() {
        Assertions.assertTrue(selectTechnical);
        webDriver.quit();
    }

    @When("I select a consultant grade on the Feedback Page")
    public void iSelectAConsultantGradeOnTheFeedbackPage() {
        selectConsultant = feedbackForm.isConsultantGradeSelected("A");

    }

    @Then("The consultant grade should be selected on the Feedback Page")
    public void theConsultantGradeShouldBeSelectedOnTheFeedbackPage() {
        Assertions.assertTrue(selectConsultant);
        webDriver.quit();
    }

    @When("I click the Sparta global logo from the Feedback Page")
    public void iClickTheSpartaGlobalLogoFromTheFeedbackPage() {
        feedbackForm.getSideBarTrainee().goToHomePageByClickingLogo();
    }

    @Then("I should be directed to the Dashboard from the Feedback Page")
    public void iShouldBeDirectedToTheDashboardFromTheFeedbackPage() {
        Assertions.assertEquals(webDriver.getCurrentUrl(), "http://localhost:8080/trainee/home");
        webDriver.quit();
    }

    @When("I click profile from the Feedback Page")
    public void iClickProfileFromTheFeedbackPage() {
        feedbackForm.getSideBarTrainee().goToHomePageByClickingProfile();
    }

    @When("I click Consultancy Skills from the Feedback Page")
    public void iClickConsultancySkillsFromTheFeedbackPage() {
        feedbackForm.getSideBarTrainee().selectView();
        feedbackForm.getSideBarTrainee().goToConsultancySkills();
    }

    @Then("I should be directed to the Consultancy Skills page from the Feedback Page")
    public void iShouldBeDirectedToTheConsultancySkillsPageFromTheFeedbackPage() {
        Assertions.assertEquals(webDriver.getCurrentUrl(), "http://localhost:8080/consultancy");
        webDriver.quit();
    }

    @When("I click on the Trainee Guide from the Feedback Page")
    public void iClickOnTheTraineeGuideFromTheFeedbackPage() {
        feedbackForm.getSideBarTrainee().selectView();
        feedbackForm.getSideBarTrainee().goToTraineeGuide();
    }

    @Then("I should be directed to the Trainee Guide page from the Feedback Page")
    public void iShouldBeDirectedToTheTraineeGuidePageFromTheFeedbackPage() {
        Assertions.assertEquals(webDriver.getCurrentUrl(), "http://localhost:8080/guide");
        webDriver.quit();
    }

    @When("I click on logout from the Feedback Page")
    public void iClickOnLogoutFromTheFeedbackPage() {
        feedbackForm.selectProfileImage();
        feedbackForm.logout();
    }

    @Then("I should be logged out from the Feedback Page")
    public void iShouldBeLoggedOutFromTheFeedbackPage() {
        Assertions.assertEquals(webDriver.getCurrentUrl(), "http://localhost:8080/login");
        webDriver.quit();
    }

    @When("I click on the Reports History from the Feedback Page")
    public void iClickOnTheReportsHistoryFromTheFeedbackPage() {
        feedbackForm.getSideBarTrainee().clickTraineeOptions();
        feedbackForm.getSideBarTrainee().goToReportTrainee();
    }

    @Then("I should be directed to the Reports History page from the Feedback Page")
    public void iShouldBeDirectedToTheReportsHistoryPageFromTheFeedbackPage() {
        Assertions.assertEquals(webDriver.getCurrentUrl(), "http://localhost:8080/trainee/report");
        webDriver.quit();
    }

    @When("I click on the Attendance History page from the Feedback Page")
    public void iClickOnTheAttendanceHistoryPageFromTheFeedbackPage() {
        feedbackForm.getSideBarTrainee().clickTraineeOptions();
        feedbackForm.getSideBarTrainee().goToTraineeAttendance();
    }

    @Then("I should be directed to the Attendance History page from the Feedback Page")
    public void iShouldBeDirectedToTheAttendanceHistoryPageFromTheFeedbackPage() {
        Assertions.assertEquals(webDriver.getCurrentUrl(), "http://localhost:8080/trainee/trainee-attendance");
        webDriver.quit();
    }
}
