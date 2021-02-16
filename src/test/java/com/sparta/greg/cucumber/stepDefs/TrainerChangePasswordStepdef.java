package com.sparta.greg.cucumber.stepdefs;

import com.sparta.greg.pom.pages.components.Login;
import com.sparta.greg.pom.pages.components.PropertyLoader;
import com.sparta.greg.pom.pages.trainer.HomeTrainer;
import com.sparta.greg.pom.pages.trainer.TrainerChangePassword;
import com.sparta.greg.pom.webDriverFactory.WebDriverFactory;
import com.sparta.greg.pom.webDriverFactory.WebDriverType;
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

public class TrainerChangePasswordStepdef {
    WebDriver webDriver;
    Login login;
    Login loginLogout;
    String trainerUsername;
    String trainerPassword;
    HomeTrainer homeTrainer;
    HomeTrainer homeTrainer2;
    TrainerChangePassword trainerChangePassword;

    private void setup() {
        webDriver = WebDriverFactory.getWebDriver(WebDriverType.CHROME);
        webDriver.get("http://localhost:8080");
        login = new Login(webDriver);

        PropertyLoader.loadProperties();
        trainerUsername = PropertyLoader.properties.getProperty("trainerUsername");
        trainerPassword = PropertyLoader.properties.getProperty("trainerPassword");
    }

    @Given("I am logged in as a Trainer and on the Trainer Change Password Page")
    public void iAmLoggedInAsATrainerAndIAmOnTheChangePasswordPage() {
        setup();
        homeTrainer = login.logInAsTrainer(trainerUsername, trainerPassword);
        homeTrainer.selectProfileImage();
        trainerChangePassword = homeTrainer.getSideBarTrainer().changePassword();
    }


    @When("I change my password as a Trainer from {string} to {string}")
    public void iChangeMyPasswordFromTo(String arg0, String arg1) {
        homeTrainer = trainerChangePassword.changePassword(arg0, arg1);
    }

    @And("I log out from Trainer page")
    public void iLogOutFromTrainerPage() {
        homeTrainer.selectProfileImage();
        loginLogout = homeTrainer.logout();
    }


    @Then("I am able to log back in as a Trainer with new password {string}")
    public void iAmAbleToLogBackInAsATrainerWithNewPassword(String arg0) {
        homeTrainer2 = loginLogout.logInAsTrainer(trainerUsername, arg0);
        Assertions.assertEquals("http://localhost:8080/trainer/home", homeTrainer.getURL());
        webDriver.quit();
    }


    @When("I click on Sparta Global Logo on the Trainer Change Password Page")
    public void iClickOnSpartaGlobalLogoOnTheTrainerChangePasswordPage() {
        homeTrainer2 = trainerChangePassword.getSideBarTrainer().goToHomePageByClickingLogo();
    }

    @Then("I am taken to the Home Trainer Page from Trainer Change Password Page")
    public void iAmTakenToTheHomeTrainerPageFromTrainerChangePasswordPage() {
        Assertions.assertEquals("http://localhost:8080/trainer/home", webDriver.getCurrentUrl());
        webDriver.quit();
    }

    @When("I click on Dashboard on the Trainer Change Password Page")
    public void iClickOnProfileOnTheTrainerChangePasswordPage() {
        trainerChangePassword.getSideBarTrainer().goToHomePageByClickingDashboard();
    }

    @When("I click View on the Trainer sidebar on the Trainer Change Password Page")
    public void iClickViewOnTheTrainerSidebarOnTheTrainerChangePasswordPage() {
        if(!trainerChangePassword.getSideBarTrainer().isViewExpanded()) {
            trainerChangePassword.getSideBarTrainer().selectView();
        }
    }

    @And("I click on Consultancy Skills on the Trainer Change Password Page")
    public void iClickOnConsultancySkillsOnTheTrainerChangePasswordPage() {
        trainerChangePassword.getSideBarTrainer().goToConsultancySkills();
    }

    @Then("I am taken to the Consultancy Skills Page from Trainer Change Password Page")
    public void iAmTakenToTheConsultancySkillsPageFromTrainerChangePasswordPage() {
        Assertions.assertEquals("http://localhost:8080/consultancy", webDriver.getCurrentUrl());
        webDriver.quit();
    }

    @And("I click on Trainee Guide on the Trainer Change Password Page")
    public void iClickOnTraineeGuideOnTheTrainerChangePasswordPage() {
        trainerChangePassword.getSideBarTrainer().goToTraineeGuide();
    }

    @Then("I am taken to the Trainee Guide Page from Trainer Change Password Page")
    public void iAmTakenToTheTraineeGuidePageFromTrainerChangePasswordPage() {
        Assertions.assertEquals("http://localhost:8080/guide", webDriver.getCurrentUrl());
        webDriver.quit();
    }

    @When("I click Trainer Options on the Trainer sidebar on the Trainer Change Password Page")
    public void iClickTrainerOptionsOnTheTrainerSidebarOnTheTrainerChangePasswordPage() {
        if(!trainerChangePassword.getSideBarTrainer().isTrainerOptionsExpanded()) {
            trainerChangePassword.getSideBarTrainer().clickTrainerOptions();
        }
    }

    @And("I click on Class Management on the Trainer Change Password Page")
    public void iClickOnClassManagementOnTheTrainerChangePasswordPage() {
        trainerChangePassword.getSideBarTrainer().goToClassManagement();
    }

    @Then("I am taken to the Class Management Page from Trainer Change Password Page")
    public void iAmTakenToTheClassManagementPageFromTrainerChangePasswordPage() {
        Assertions.assertEquals("http://localhost:8080/trainer/manageClass", webDriver.getCurrentUrl());
        webDriver.quit();
    }

    @And("I click on Trainee Management on the Trainer Change Password Page")
    public void iClickOnTraineeManagementOnTheTrainerChangePasswordPage() {
        trainerChangePassword.getSideBarTrainer().goToTraineeManagement();
    }

    @Then("I am taken to the Manage Trainee Page from Trainer Change Password Page")
    public void iAmTakenToTheManageTraineePageFromTrainerChangePasswordPage() {
        Assertions.assertEquals("http://localhost:8080/trainer/manageTrainee", webDriver.getCurrentUrl());
        webDriver.quit();
    }

    @And("I click on Add Weeks on the Trainer Change Password Page")
    public void iClickOnAddWeeksOnTheTrainerChangePasswordPage() {
        trainerChangePassword.getSideBarTrainer().goToAddWeeks();
    }

    @Then("I am taken to the Add Weeks Page from Trainer Change Password Page")
    public void iAmTakenToTheAddWeeksPageFromTrainerChangePasswordPage() {
        Assertions.assertEquals("http://localhost:8080/trainer/newWeek", webDriver.getCurrentUrl());
        webDriver.quit();
    }

    @And("I click on Assessments on the Trainer Change Password Page")
    public void iClickOnAssessmentsOnTheTrainerChangePasswordPage() {
        trainerChangePassword.getSideBarTrainer().goToAssessments();
    }

    @Then("I am taken to the Assessments Page from Trainer Change Password Page")
    public void iAmTakenToTheAssessmentsPageFromTrainerChangePasswordPage() {
        Assertions.assertEquals("http://localhost:8080/trainer/assessments", webDriver.getCurrentUrl());
        webDriver.quit();
    }

    @And("I click on Enter Attendance on the Trainer Change Password Page")
    public void iClickOnEnterAttendanceOnTheTrainerChangePasswordPage() {
        trainerChangePassword.getSideBarTrainer().goToEnterAttendance();
    }

    @Then("I am taken to the Enter Attendance Page from Trainer Change Password Page")
    public void iAmTakenToTheEnterAttendancePageFromTrainerChangePasswordPage() {
        Assertions.assertEquals("http://localhost:8080/trainer/attendanceEntry", webDriver.getCurrentUrl());
        webDriver.quit();
    }

    @And("I click on Weekly Attendance on the Trainer Change Password Page")
    public void iClickOnWeeklyAttendanceOnTheTrainerChangePasswordPage() {
        trainerChangePassword.getSideBarTrainer().goToWeeklyAttendance();
    }

    @Then("I am taken to the Weekly Attendance Page from Trainer Change Password Page")
    public void iAmTakenToTheWeeklyAttendancePageFromTrainerChangePasswordPage() {
        Assertions.assertEquals("http://localhost:8080/trainer/weekly-attendance", webDriver.getCurrentUrl());
        webDriver.quit();
    }
}
