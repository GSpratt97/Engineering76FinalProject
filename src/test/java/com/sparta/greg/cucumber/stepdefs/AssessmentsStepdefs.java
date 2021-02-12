package com.sparta.greg.cucumber.stepdefs;

import com.sparta.greg.pom.pages.components.ConsultancySkills;
import com.sparta.greg.pom.pages.components.Login;
import com.sparta.greg.pom.pages.trainer.Assessments;
import com.sparta.greg.pom.pages.trainer.TrainerGuide;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class AssessmentsStepdefs {

    WebDriver webDriver;
    Properties properties;
    String usernameTrainer;
    String passwordTrainer;
    Assessments assessmentsPage;

    private void loadPropertiesAndLoginAsTrainer() {
        properties = new Properties();
        webDriver = new ChromeDriver();
        webDriver.get("http://localhost:8080/login");

        try {
            properties.load(new FileReader("src/test/resources/login.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        usernameTrainer = properties.getProperty("trainerUsername");
        passwordTrainer = properties.getProperty("trainerPassword");

        Login login = new Login(webDriver);
        login.logInAsTrainer(usernameTrainer, passwordTrainer);

        webDriver.get("http://localhost:8080/trainer/assessments");

        assessmentsPage = new Assessments(webDriver);

    }

    @Given("I am logged in as a trainer and on the Assessments Page")
    public void iAmOnTheAssessmentsPage() {
        loadPropertiesAndLoginAsTrainer();
    }

    @When("I click on a Trainee called {string} on the Assessments Page")
    public void iClickOnATrainee(String traineeName) {
        assessmentsPage.clickTraineeByName(traineeName);
    }

    @Then("I am taken to the Assessments Breakdown Page from the Assessments Page")
    public void iAmTakenToTheAssessmentsBreakdownPage() {
        Assertions.assertTrue(webDriver.getCurrentUrl().contains("http://localhost:8080/trainer/assessments/"));
        webDriver.close();
    }

    @When("I click View on the trainer sidebar")
    public void iClickViewOnTheTrainerSidebar() {
        assessmentsPage.getSideBarTrainer().selectView();
    }

    @And("I click on Consultancy Skills")
    public void iClickOnConsultancySkills() {
        assessmentsPage.getSideBarTrainer().goToConsultancySkills();
    }

    @Then("I am taken to the Consultancy Skills Page from the Assessments Page")
    public void iAmTakenToTheConsultancySkillsPageFromTheAssessmentsPage() {
        Assertions.assertEquals("http://localhost:8080/consultancy", webDriver.getCurrentUrl());
        webDriver.close();
    }

    @And("I click on Trainee Guide")
    public void iClickOnTraineeGuide() {
        assessmentsPage.getSideBarTrainer().goToTraineeGuide();
    }

    @Then("I am taken to the Trainee Guide Page from the Assessments Page")
    public void iAmTakenToTheTraineeGuidePageFromTheAssessmentsPage() {
        Assertions.assertEquals("http://localhost:8080/guide", webDriver.getCurrentUrl());
        webDriver.close();
    }

    @When("I click Trainer Options on the trainer sidebar")
    public void iClickTrainerOptionsOnTheTrainerSidebar() {
        assessmentsPage.getSideBarTrainer().clickTrainerOptions();
    }

    @And("I click on Class Management")
    public void iClickOnClassManagement() {
        assessmentsPage.getSideBarTrainer().goToClassManagement();
    }

    @Then("I am taken to the Class Management Page from the Assessments Page")
    public void iAmTakenToTheClassManagementPageFromTheAssessmentsPage() {
        Assertions.assertEquals("http://localhost:8080/trainer/manageClass", webDriver.getCurrentUrl());
        webDriver.close();
    }

    @And("I click on Trainee Management")
    public void iClickOnTraineeManagement() {
        assessmentsPage.getSideBarTrainer().goToTraineeManagement();
    }

    @Then("I am taken to the Manage Trainee Page from the Assessments Page")
    public void iAmTakenToTheManageTraineePageFromTheAssessmentsPage() {
        Assertions.assertEquals("http://localhost:8080/trainer/manageTrainee", webDriver.getCurrentUrl());
        webDriver.close();
    }

    @And("I click on Add Weeks")
    public void iClickOnAddWeeks() {
        assessmentsPage.getSideBarTrainer().goToAddWeeks();
    }

    @Then("I am taken to the Add Weeks Page from the Assessments Page")
    public void iAmTakenToTheAddWeeksPageFromTheAssessmentsPage() {
        Assertions.assertEquals("http://localhost:8080/trainer/newWeek", webDriver.getCurrentUrl());
        webDriver.close();
    }

    @And("I click on Assessments")
    public void iClickOnAssessments() {
        assessmentsPage.getSideBarTrainer().goToAssessments();
    }

    @And("I click on Enter Attendance")
    public void iClickOnEnterAttendance() {
        assessmentsPage.getSideBarTrainer().goToEnterAttendance();
    }

    @Then("I am taken to the Enter Attendance Page from the Assessments Page")
    public void iAmTakenToTheEnterAttendancePageFromTheAssessmentsPage() {
        Assertions.assertEquals("http://localhost:8080/trainer/attendanceEntry", webDriver.getCurrentUrl());
        webDriver.close();
    }

    @And("I click on Weekly Attendance")
    public void iClickOnWeeklyAttendance() {
        assessmentsPage.getSideBarTrainer().goToWeeklyAttendance();
    }

    @Then("I am taken to the Weekly Attendance Page from the Assessments Page")
    public void iAmTakenToTheWeeklyAttendancePageFromTheAssessmentsPage() {
        Assertions.assertEquals("http://localhost:8080/trainer/weekly-attendance", webDriver.getCurrentUrl());
        webDriver.close();
    }

    @Then("I am taken to the Assessments Page from the Assessments Page")
    public void iAmTakenToTheAssessmentsPageFromTheAssessmentsPage() {
        Assertions.assertEquals("http://localhost:8080/trainer/assessments", webDriver.getCurrentUrl());
        webDriver.close();
    }
}
