package com.sparta.greg.cucumber.stepDefs.trainee;

import com.sparta.greg.pom.pages.Login;
import com.sparta.greg.pom.pages.utilities.PropertyLoader;
import com.sparta.greg.pom.pages.trainee.HomeTrainee;
import com.sparta.greg.pom.pages.trainee.TraineeChangePassword;
import com.sparta.greg.pom.webDriverFactory.WebDriverFactory;
import com.sparta.greg.pom.webDriverFactory.WebDriverType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;


public class TraineeChangePasswordStepdef {
    WebDriver webDriver;
    Login login;
    Login loginLogout;
    String traineeUsername;
    String traineePassword;
    HomeTrainee homeTrainee;
    TraineeChangePassword traineeChangePassword;

    private void setup() {
        webDriver = WebDriverFactory.runHeadless(WebDriverType.CHROME);
        webDriver.get("http://localhost:8080");
        login = new Login(webDriver);

        PropertyLoader.loadProperties();
        traineeUsername = PropertyLoader.properties.getProperty("traineeUsername");
        traineePassword = PropertyLoader.properties.getProperty("traineePassword");
    }


    @Given("I am logged in as a Trainee and on the Trainee Change Password Page")
    public void iAmLoggedInAsATraineeOnTheChangePasswordPage() {
        setup();
        homeTrainee = login.logInAsTrainee(traineeUsername, traineePassword);
        homeTrainee.selectProfileImage();
        traineeChangePassword = homeTrainee.getSideBarTrainee().changePassword();
    }

    @When("I change my password as a Trainee from {string} to {string}")
    public void iChangeMyPasswordAsATraineeFromTo(String arg0, String arg1) {
        homeTrainee = traineeChangePassword.changePassword(arg0, arg1);
    }

    @And("I log out from Trainee page")
    public void iLogOutFromTraineePage() {
        homeTrainee.selectProfileImage();
        loginLogout = homeTrainee.logout();
    }

    @Then("I am able to log back in as a Trainee with new password {string}")
    public void iAmAbleToLogBackInAsATraineeWithNewPassword(String arg0) {
        homeTrainee = loginLogout.logInAsTrainee(traineeUsername, arg0);
        Assertions.assertEquals("http://localhost:8080/trainee/home", homeTrainee.getURL());
        webDriver.quit();
    }


    @When("I click on Sparta Global Logo on the Trainee Change Password Page")
    public void iClickOnSpartaGlobalLogoOnTheTraineeChangePasswordPage() {
        traineeChangePassword.getSideBarTrainee().goToHomePageByClickingLogo();
    }

    @Then("I am taken to the Home Trainee Page from Trainee Change Password Page")
    public void iAmTakenToTheHomeTraineePageFromTraineeChangePasswordPage() {
        Assertions.assertEquals("http://localhost:8080/trainee/home", webDriver.getCurrentUrl());
        webDriver.quit();
    }

    @When("I click on Profile on the Trainee Change Password Page")
    public void iClickOnProfileOnTheTraineeChangePasswordPage() {
        traineeChangePassword.getSideBarTrainee().goToHomePageByClickingProfile();
    }

    @When("I click View on the Trainee sidebar on the Trainee Change Password Page")
    public void iClickViewOnTheTraineeSidebarOnTheTraineeChangePasswordPage() {
        if (!traineeChangePassword.getSideBarTrainee().isViewExpanded()) {
            traineeChangePassword.getSideBarTrainee().selectView();
        }
    }

    @And("I click on Consultancy Skills on the Trainee Change Password Page")
    public void iClickOnConsultancySkillsOnTheTraineeChangePasswordPage() {
        traineeChangePassword.getSideBarTrainee().goToConsultancySkills();
    }

    @Then("I am taken to the Consultancy Skills Page from Trainee Change Password Page")
    public void iAmTakenToTheConsultancySkillsPageFromTraineeChangePasswordPage() {
        Assertions.assertEquals("http://localhost:8080/consultancy", webDriver.getCurrentUrl());
        webDriver.quit();
    }

    @And("I click on Trainee Guide on the Trainee Change Password Page")
    public void iClickOnTraineeGuideOnTheTraineeChangePasswordPage() {
        traineeChangePassword.getSideBarTrainee().goToTraineeGuide();
    }

    @Then("I am taken to the Trainee Guide Page from Trainee Change Password Page")
    public void iAmTakenToTheTraineeGuidePageFromTraineeChangePasswordPage() {
        Assertions.assertEquals("http://localhost:8080/guide", webDriver.getCurrentUrl());
        webDriver.quit();
    }

    @When("I click Trainee Options on the Trainee sidebar on the Trainee Change Password Page")
    public void iClickTraineeOptionsOnTheTraineeSidebarOnTheTraineeChangePasswordPage() {
        if (!traineeChangePassword.getSideBarTrainee().isTraineeOptionsExpanded()) {
            traineeChangePassword.getSideBarTrainee().clickTraineeOptions();
        }
    }

    @And("I click on Feedback Form on the Trainee Change Password Page")
    public void iClickOnFeedbackFormOnTheTraineeChangePasswordPage() {
        traineeChangePassword.getSideBarTrainee().goToFeedbackForm();
    }

    @Then("I am taken to the Feedback Form from Trainee Change Password Page")
    public void iAmTakenToTheFeedbackFormFromTraineeChangePasswordPage() {
        Assertions.assertEquals("http://localhost:8080/trainee/report/12", webDriver.getCurrentUrl());
        webDriver.quit();
    }

    @And("I click on Report Trainee on the Trainee Change Password Page")
    public void iClickOnReportTraineeOnTheTraineeChangePasswordPage() {
        traineeChangePassword.getSideBarTrainee().goToReportTrainee();
    }

    @Then("I am taken to the Report Trainee Page from Trainee Change Password Page")
    public void iAmTakenToTheReportTraineePageFromTraineeChangePasswordPage() {
        Assertions.assertEquals("http://localhost:8080/trainee/report", webDriver.getCurrentUrl());
        webDriver.quit();
    }

    @And("I click on Attendance on the Trainee Change Password Page")
    public void iClickOnAttendanceOnTheTraineeChangePasswordPage() {
        traineeChangePassword.getSideBarTrainee().goToTraineeAttendance();
    }

    @Then("I am taken to the Attendance Page from Trainee Change Password Page")
    public void iAmTakenToTheAttendancePageFromTraineeChangePasswordPage() {
        Assertions.assertEquals("http://localhost:8080/trainee/trainee-attendance", webDriver.getCurrentUrl());
        webDriver.quit();
    }
}
