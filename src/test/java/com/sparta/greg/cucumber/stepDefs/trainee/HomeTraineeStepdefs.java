package com.sparta.greg.cucumber.stepDefs.trainee;

import com.sparta.greg.pom.pages.Login;
import com.sparta.greg.pom.pages.utilities.PropertyLoader;
import com.sparta.greg.pom.pages.trainee.HomeTrainee;
import com.sparta.greg.pom.webDriverFactory.WebDriverFactory;
import com.sparta.greg.pom.webDriverFactory.WebDriverType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;

public class HomeTraineeStepdefs {

    private static WebDriver webDriver;
    private Login login;
    private HomeTrainee homeTrainee;

    private String traineeUsername;
    private String traineePassword;

    private void loadPropertiesLoginAsTraineeGoToAssessments() {
        webDriver = WebDriverFactory.runHeadless(WebDriverType.CHROME);
        webDriver.get("http://localhost:8080/login");
        PropertyLoader.loadProperties();
        traineeUsername = PropertyLoader.properties.getProperty("traineeUsername");
        traineePassword = PropertyLoader.properties.getProperty("traineePassword");
        Login login = new Login(webDriver);
        login.logInAsTrainer(traineeUsername, traineePassword);
    }

    @Given("I am logged in as a trainee and on the Home Trainee Page")
    public void iAmLoggedInAsATraineeAndOnTheHomeTraineePage() {
        loadPropertiesLoginAsTraineeGoToAssessments();
        homeTrainee = new HomeTrainee(webDriver);
    }

    @When("I click on Attendance Details on the Home Trainee Page")
    public void iClickOnAttendanceDetailsOnTheHomeTraineePage() {
        homeTrainee.goToWeeklyAttendance();
    }

    @Then("I am taken to the Weekly Attendance Page from the Home Trainee Page")
    public void iAmTakenToTheWeeklyAttendancePageFromTheHomeTraineePage() {
        Assertions.assertEquals("http://localhost:8080/trainee/trainee-attendance", webDriver.getCurrentUrl());
    }

    @When("I click on Report Details on the Home Trainee Page")
    public void iClickOnReportDetailsOnTheHomeTraineePage() {
        homeTrainee.goToReportForTrainee();
    }

    @Then("I am taken to the Trainee Report Page from the Home Trainee Page")
    public void iAmTakenToTheTraineeReportPageFromTheHomeTraineePage() {
        Assertions.assertEquals("http://localhost:8080/trainee/report", webDriver.getCurrentUrl());
    }

    @When("I click on Sparta Global Logo on the Home Trainee Page")
    public void iClickOnSpartaGlobalLogoOnTheHomeTraineePage() {
        homeTrainee.getSideBarTrainee().goToHomePageByClickingLogo();
    }

    @Then("I am taken to the Home Trainee Page from the Home Trainee Page")
    public void iAmTakenToTheHomeTraineePageFromTheHomeTraineePage() {
        Assertions.assertEquals("http://localhost:8080/trainee/home", webDriver.getCurrentUrl());
    }

    @When("I click on Profile on the Home Trainee Page")
    public void iClickOnProfileOnTheHomeTraineePage() {
        homeTrainee.getSideBarTrainee().goToHomePageByClickingProfile();
    }

    @When("I click View on the trainee sidebar on the Home Trainee Page")
    public void iClickViewOnTheTraineeSidebarOnTheHomeTraineePage() {
        homeTrainee.getSideBarTrainee().selectView();
    }

    @And("I click on Consultancy Skills on the Home Trainee Page")
    public void iClickOnConsultancySkillsOnTheHomeTraineePage() {
        homeTrainee.getSideBarTrainee().goToConsultancySkills();
    }

    @Then("I am taken to the Consultancy Skills Page from the Home Trainee Page")
    public void iAmTakenToTheConsultancySkillsPageFromTheHomeTraineePage() {
        Assertions.assertEquals("http://localhost:8080/consultancy", webDriver.getCurrentUrl());
    }

    @And("I click on Trainee Guide on the Home Trainee Page")
    public void iClickOnTraineeGuideOnTheHomeTraineePage() {
        homeTrainee.getSideBarTrainee().goToTraineeGuide();
    }

    @Then("I am taken to the Trainee Guide Page from the Home Trainee Page")
    public void iAmTakenToTheTraineeGuidePageFromTheHomeTraineePage() {
        Assertions.assertEquals("http://localhost:8080/guide", webDriver.getCurrentUrl());
    }

    @When("I click Trainee Options on the trainee sidebar on the Home Trainee Page")
    public void iClickTraineeOptionsOnTheTraineeSidebarOnTheHomeTraineePage() {
        homeTrainee.getSideBarTrainee().clickTraineeOptions();
    }

    @And("I click on Feedback Form on the Home Trainee Page")
    public void iClickOnFeedbackFormOnTheHomeTraineePage() {
        homeTrainee.getSideBarTrainee().goToFeedbackForm();
    }

    @Then("I am taken to the Feedback Form from the Home Trainee Page")
    public void iAmTakenToTheFeedbackFormFromTheHomeTraineePage() {
        Assertions.assertEquals("http://localhost:8080/trainee/report/12", webDriver.getCurrentUrl());
    }

    @And("I click on Report Trainee on the Home Trainee Page")
    public void iClickOnReportTraineeOnTheHomeTraineePage() {
        homeTrainee.getSideBarTrainee().goToReportTrainee();
    }

    @Then("I am taken to the Report Trainee Page from the Home Trainee Page")
    public void iAmTakenToTheReportTraineePageFromTheHomeTraineePage() {
        Assertions.assertEquals("http://localhost:8080/trainee/report", webDriver.getCurrentUrl());
    }

    @And("I click on Attendance History on the Home Trainee Page")
    public void iClickOnAttendanceHistoryOnTheHomeTraineePage() {
        homeTrainee.getSideBarTrainee().goToTraineeAttendance();
    }

    @Then("I am taken to the Trainee Attendance Page from the Home Trainee Page")
    public void iAmTakenToTheTraineeAttendancePageFromTheHomeTraineePage() {
        Assertions.assertEquals("http://localhost:8080/trainee/trainee-attendance", webDriver.getCurrentUrl());
    }

    @When("I am on the Home Trainee Page")
    public void iAmOnTheHomeTraineePage() {
    }

    @Then("I can see my Trainee details on the Home Trainee Page")
    public void iCanSeeMyTraineeDetailsOnTheHomeTraineePage() {
        String[] traineeDetails = {"Bill Bird", "Engineering 72", "Java Development", "12"};
        Assertions.assertEquals(Arrays.toString(traineeDetails), Arrays.toString(homeTrainee.getTraineeDetails()));
    }

    @Then("I can see my Grade for previous week on the Home Trainee Page")
    public void iCanSeeMyGradeForPreviousWeekOnTheHomeTraineePage() {
        String[] gradeForPreviousWeek = {"C", "C", "C"};
        Assertions.assertEquals(Arrays.toString(gradeForPreviousWeek), Arrays.toString(homeTrainee.getTraineeGrades()));
    }


    @Then("I can see my Attendance details on the Home Trainee Page")
    public void iCanSeeMyAttendanceDetailsOnTheHomeTraineePage() {
        String[] attendanceBreakdown = {"0%", "100%", "0%", "0%"};
        Assertions.assertEquals(Arrays.toString(attendanceBreakdown), Arrays.toString(homeTrainee.getAttendanceBreakdown()));
    }
}
