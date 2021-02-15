package com.sparta.greg.cucumber.stepdefs;

import com.sparta.greg.pom.pages.components.Login;
import com.sparta.greg.pom.pages.trainer.HomeTrainer;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class HomeTrainerStepdefs {

    private static WebDriver webDriver;
    private static Properties properties = new Properties();
    private Login login;
    private HomeTrainer homeTrainer;

    private String trainerUsername;
    private String trainerPassword;

    @Given("I am logged in as a trainer and on the Home Trainer Page")
    public void iAmLoggedInAsATrainerAndOnTheHomeTrainerPage() {
        webDriver = new ChromeDriver();
        login = new Login(webDriver);
        try {
            properties.load(new FileReader("src/test/resources/login.properties"));
            trainerUsername = properties.getProperty("trainerUsername");
            trainerPassword = properties.getProperty("trainerPassword");
        } catch (IOException e) {
            e.printStackTrace();
        }
        login.logInAsTrainer(trainerUsername, trainerPassword);
        homeTrainer = new HomeTrainer(webDriver);
    }

    @When("I am on the Home Trainer Page")
    public void iAmOnTheHomeTrainerPage() {
    }

    @Then("I can see my Trainer details")
    public void iCanSeeMyTrainerDetails() {
        String[] traineeDetails = {"Manish Gadhvi", "Engineering 72", "Java Development", "12"};
        Assertions.assertEquals(Arrays.toString(traineeDetails), Arrays.toString(homeTrainer.getTrainerDetails()));
    }

    @Then("I can see the overall group attendance")
    public void iCanSeeTheOverallGroupAttendance() {
        String[] overallGroupAttendance = {"89.74%", "7.28%", "1.99%", "0.99%"};
        Assertions.assertEquals(Arrays.toString(overallGroupAttendance), Arrays.toString(homeTrainer.getOverallGroupAttendance()));
    }

    @When("I choose a trainee on the Home Trainer Page")
    public void iChooseATraineeOnTheHomeTrainerPage() {
        homeTrainer.findTraineeFromDropdown("Reece Louch");
    }

    @And("I click on view trainee profile on the Home Trainer Page")
    public void iClickOnViewTraineeProfileOnTheHomeTrainerPage() {
        homeTrainer.goToTraineeProfile();
    }

    @Then("I am taken to the Trainee Profile from the Home Trainer Page")
    public void iAmTakenToTheTraineeProfileFromTheHomeTrainerPage() {
        Assertions.assertEquals("http://localhost:8080/trainer/traineeProfile/187", webDriver.getCurrentUrl());
    }

    @When("I click on enter class attendance on the Home Trainer Page")
    public void iClickOnEnterClassAttendanceOnTheHomeTrainerPage() {
        homeTrainer.goToEnterAttendanceThroughDashboard();
    }

    @Then("I am taken to the Enter Attendance Page from the Home Trainer Page")
    public void iAmTakenToTheEnterAttendancePageFromTheHomeTrainerPage() {
        Assertions.assertEquals("http://localhost:8080/trainer/attendanceEntry", webDriver.getCurrentUrl());
    }

    @When("I click on Sparta Global Logo on the Home Trainer Page")
    public void iClickOnSpartaGlobalLogoOnTheHomeTrainerPage() {
        homeTrainer.getSideBarTrainer().goToHomePageByClickingLogo();
    }

    @Then("I am taken to the Home Trainer Page from the Home Trainer Page")
    public void iAmTakenToTheHomeTrainerPageFromTheHomeTrainerPage() {
        Assertions.assertEquals("http://localhost:8080/trainer/home", webDriver.getCurrentUrl());
    }

    @When("I click on Dashboard on the Home Trainer Page")
    public void iClickOnDashboardOnTheHomeTrainerPage() {
        homeTrainer.getSideBarTrainer().goToHomePageByClickingDashboard();
    }

    @When("I click View on the trainer sidebar on the Home Trainer Page")
    public void iClickViewOnTheTrainerSidebarOnTheHomeTrainerPage() {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.nav-link[data-target='#collapseTwo']")));
        homeTrainer.getSideBarTrainer().selectView();
    }

    @And("I click on Consultancy Skills on the Home Trainer Page")
    public void iClickOnConsultancySkillsOnTheHomeTrainerPage() {
        homeTrainer.getSideBarTrainer().goToConsultancySkills();
    }

    @Then("I am taken to the Consultancy Skills Page from the Home Trainer Page")
    public void iAmTakenToTheConsultancySkillsPageFromTheHomeTrainerPage() {
        Assertions.assertEquals("http://localhost:8080/consultancy", webDriver.getCurrentUrl());
    }

    @And("I click on Trainee Guide on the Home Trainer Page")
    public void iClickOnTraineeGuideOnTheHomeTrainerPage() {
        homeTrainer.getSideBarTrainer().goToTraineeGuide();
    }

    @Then("I am taken to the Trainee Guide Page from the Home Trainer Page")
    public void iAmTakenToTheTraineeGuidePageFromTheHomeTrainerPage() {
        Assertions.assertEquals("http://localhost:8080/guide", webDriver.getCurrentUrl());
    }

    @When("I click Trainer Options on the trainer sidebar on the Home Trainer Page")
    public void iClickTrainerOptionsOnTheTrainerSidebarOnTheHomeTrainerPage() {
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        homeTrainer.getSideBarTrainer().clickTrainerOptions();
    }

    @And("I click on Class Management on the Home Trainer Page")
    public void iClickOnClassManagementOnTheHomeTrainerPage() {
        homeTrainer.getSideBarTrainer().goToClassManagement();
    }

    @Then("I am taken to the Class Management Page from the Home Trainer Page")
    public void iAmTakenToTheClassManagementPageFromTheHomeTrainerPage() {
        Assertions.assertEquals("http://localhost:8080/trainer/manageClass", webDriver.getCurrentUrl());
    }

    @And("I click on Trainee Management on the Home Trainer Page")
    public void iClickOnTraineeManagementOnTheHomeTrainerPage() {
        homeTrainer.getSideBarTrainer().goToTraineeManagement();
    }

    @Then("I am taken to the Manage Trainee Page from the Home Trainer Page")
    public void iAmTakenToTheManageTraineePageFromTheHomeTrainerPage() {
        Assertions.assertEquals("http://localhost:8080/trainer/manageTrainee", webDriver.getCurrentUrl());
    }

    @And("I click on Add Weeks on the Home Trainer Page")
    public void iClickOnAddWeeksOnTheHomeTrainerPage() {
        homeTrainer.getSideBarTrainer().goToAddWeeks();
    }

    @Then("I am taken to the Add Weeks Page from the Home Trainer Page")
    public void iAmTakenToTheAddWeeksPageFromTheHomeTrainerPage() {
        Assertions.assertEquals("http://localhost:8080/trainer/newWeek", webDriver.getCurrentUrl());
    }

    @And("I click on Assessments on the Home Trainer Page")
    public void iClickOnAssessmentsOnTheHomeTrainerPage() {
        homeTrainer.getSideBarTrainer().goToAssessments();
    }

    @Then("I am taken to the Assessments Page from the Home Trainer Page")
    public void iAmTakenToTheAssessmentsPageFromTheHomeTrainerPage() {
        Assertions.assertEquals("http://localhost:8080/trainer/assessments", webDriver.getCurrentUrl());
    }

    @And("I click on Enter Attendance on the Home Trainer Page")
    public void iClickOnEnterAttendanceOnTheHomeTrainerPage() {
        homeTrainer.getSideBarTrainer().goToEnterAttendance();
    }


    @And("I click on Weekly Attendance on the Home Trainer Page")
    public void iClickOnWeeklyAttendanceOnTheHomeTrainerPage() {
        homeTrainer.getSideBarTrainer().goToWeeklyAttendance();
    }

    @Then("I am taken to the Weekly Attendance Page from the Home Trainer Page")
    public void iAmTakenToTheWeeklyAttendancePageFromTheHomeTrainerPage() {
        Assertions.assertEquals("http://localhost:8080/trainer/weekly-attendance", webDriver.getCurrentUrl());
    }

}
