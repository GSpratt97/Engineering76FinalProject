package com.sparta.greg.cucumber.stepDefs.trainer;

import com.sparta.greg.pom.pages.Login;
import com.sparta.greg.pom.pages.utilities.PropertyLoader;
import com.sparta.greg.pom.pages.trainer.AssessmentBreakdown;
import com.sparta.greg.pom.webDriverFactory.WebDriverFactory;
import com.sparta.greg.pom.webDriverFactory.WebDriverType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssessmentBreakdownStepdefs {
    private static WebDriver webDriver;
    private AssessmentBreakdown assessmentBreakdown;
    private String usernameTrainer;
    private String passwordTrainer;

    private void loadPropertiesAndLoginAsTrainer() {

        webDriver = WebDriverFactory.runHeadless(WebDriverType.CHROME);
        webDriver.get("http://localhost:8080/login");

        PropertyLoader.loadProperties();
        usernameTrainer = PropertyLoader.properties.getProperty("trainerUsername");
        passwordTrainer = PropertyLoader.properties.getProperty("trainerPassword");

        Login login = new Login(webDriver);
        login.logInAsTrainer(usernameTrainer, passwordTrainer);

        webDriver.get("http://localhost:8080/trainer/assessments/41");
        assessmentBreakdown = new AssessmentBreakdown(webDriver);
    }
    @Given("I am logged in as a trainer and on the Assessment Breakdown Page")
    public void iAmLoggedInAsATrainerAndOnTheAssessmentBreakdownPage() {
        loadPropertiesAndLoginAsTrainer();
    }

    @When("I click View on the trainer sidebar on the Assessment Breakdown Page")
    public void iClickViewOnTheTrainerSidebarOnTheAssessmentBreakdownPage() {
        assessmentBreakdown.getSideBarTrainer().selectView();
    }

    @And("I click on Consultancy Skills on the trainer sidebar on the Assessment Breakdown Page")
    public void iClickOnConsultancySkillsOnTheTrainerSidebarOnTheAssessmentBreakdownPage() {
        assessmentBreakdown.getSideBarTrainer().goToConsultancySkills();
    }

    @Then("I am taken to the Consultancy Skills Page from the Assessment Breakdown Page")
    public void iAmTakenToTheConsultancySkillsPageFromTheAssessmentBreakdownPage() {
        Assertions.assertEquals("http://localhost:8080/consultancy", webDriver.getCurrentUrl());
        webDriver.quit();
    }

    @And("I click on Trainee Guide on the trainer sidebar the Assessment Breakdown Page")
    public void iClickOnTraineeGuideOnTheTrainerSidebarTheAssessmentBreakdownPage() {
        assessmentBreakdown.getSideBarTrainer().goToTraineeGuide();
    }

    @Then("I am taken to the Trainee Guide Page from the Assessment Breakdown Page")
    public void iAmTakenToTheTraineeGuidePageFromTheAssessmentBreakdownPage() {
        Assertions.assertEquals("http://localhost:8080/guide", webDriver.getCurrentUrl());
        webDriver.quit();
    }

    @When("I click Trainer Options on the trainer sidebar on the Assessment Breakdown Page")
    public void iClickTrainerOptionsOnTheTrainerSidebarOnTheAssessmentBreakdownPage() {
        assessmentBreakdown.getSideBarTrainer().clickTrainerOptions();
    }

    @And("I click on Class Management on the trainer sidebar on the Assessment Breakdown Page")
    public void iClickOnClassManagementOnTheTrainerSidebarOnTheAssessmentBreakdownPage() {
        assessmentBreakdown.getSideBarTrainer().goToClassManagement();
    }

    @Then("I am taken to the Class Management Page from the Assessment Breakdown Page")
    public void iAmTakenToTheClassManagementPageFromTheAssessmentBreakdownPage() {
        Assertions.assertEquals("http://localhost:8080/trainer/manageClass", webDriver.getCurrentUrl());
        webDriver.quit();
    }

    @And("I click on Trainee Management on the trainer sidebar on the Assessment Breakdown Page")
    public void iClickOnTraineeManagementOnTheTrainerSidebarOnTheAssessmentBreakdownPage() {
        assessmentBreakdown.getSideBarTrainer().goToTraineeManagement();
    }

    @Then("I am taken to the Manage Trainee Page from the Assessment Breakdown Page")
    public void iAmTakenToTheManageTraineePageFromTheAssessmentBreakdownPage() {
        Assertions.assertEquals("http://localhost:8080/trainer/manageTrainee", webDriver.getCurrentUrl());
        webDriver.quit();
    }

    @And("I click on Add Weeks on the trainer sidebar on the Assessment Breakdown Page")
    public void iClickOnAddWeeksOnTheTrainerSidebarOnTheAssessmentBreakdownPage() {
        assessmentBreakdown.getSideBarTrainer().goToAddWeeks();
    }

    @Then("I am taken to the Add Weeks Page from the Assessment Breakdown Page")
    public void iAmTakenToTheAddWeeksPageFromTheAssessmentBreakdownPage() {
        Assertions.assertEquals("http://localhost:8080/trainer/newWeek", webDriver.getCurrentUrl());
        webDriver.quit();
    }

    @And("I click on Assessments on the trainer sidebar on the Assessment Breakdown Page")
    public void iClickOnAssessmentsOnTheTrainerSidebarOnTheAssessmentBreakdownPage() {
        assessmentBreakdown.getSideBarTrainer().goToAssessments();
    }

    @Then("I am taken to the Assessments Page from the Assessment Breakdown Page")
    public void iAmTakenToTheAssessmentsPageFromTheAssessmentBreakdownPage() {
        Assertions.assertEquals("http://localhost:8080/trainer/assessments", webDriver.getCurrentUrl());
        webDriver.quit();
    }

    @And("I click on Enter Attendance on the trainer sidebar on the Assessment Breakdown Page")
    public void iClickOnEnterAttendanceOnTheTrainerSidebarOnTheAssessmentBreakdownPage() {
        assessmentBreakdown.getSideBarTrainer().goToEnterAttendance();
    }

    @Then("I am taken to the Enter Attendance Page from the Assessment Breakdown Page")
    public void iAmTakenToTheEnterAttendancePageFromTheAssessmentBreakdownPage() {
        Assertions.assertEquals("http://localhost:8080/trainer/attendanceEntry", webDriver.getCurrentUrl());
        webDriver.quit();
    }

    @And("I click on Weekly Attendance on the trainer sidebar on the Assessment Breakdown Page")
    public void iClickOnWeeklyAttendanceOnTheTrainerSidebarOnTheAssessmentBreakdownPage() {
        assessmentBreakdown.getSideBarTrainer().goToWeeklyAttendance();
    }

    @Then("I am taken to the Weekly Attendance Page from the Assessment Breakdown Page")
    public void iAmTakenToTheWeeklyAttendancePageFromTheAssessmentBreakdownPage() {
        Assertions.assertEquals("http://localhost:8080/trainer/weekly-attendance", webDriver.getCurrentUrl());
        webDriver.quit();
    }

    @When("I click the plus icon on the module SQL")
    public void iClickThePlusIconOnTheModuleSQL() {
        assessmentBreakdown.clickPlusIconFirstModule();
    }

    @Then("I stay on the assessment breakdown page with the SQL module breakdown")
    public void iStayOnTheAssessmentBreakdownPageWithTheSQLModuleBreakdown() {
        Assertions.assertEquals("true", webDriver.findElement(By.cssSelector("tr[href*='collapseSQL']")).getAttribute("aria-expanded"));
        webDriver.quit();
    }

    @When("I click the plus icon on the module NotSQL")
    public void iClickThePlusIconOnTheModuleNotSQL() {
        assessmentBreakdown.clickPlusIconSecondModule();
    }

    @Then("I stay on the assessment breakdown page with the NotSQL breakdown")
    public void iStayOnTheAssessmentBreakdownPageWithTheNotSQLBreakdown() {
        Assertions.assertEquals("true", webDriver.findElement(By.cssSelector("tr[href*='collapseNotSQL']")).getAttribute("aria-expanded"));
        webDriver.quit();
    }
}
