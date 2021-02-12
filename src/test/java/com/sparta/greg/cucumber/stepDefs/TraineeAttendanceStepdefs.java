package com.sparta.greg.cucumber.stepdefs;

import com.sparta.greg.pom.pages.components.Login;
import com.sparta.greg.pom.pages.trainee.HomeTrainee;
import com.sparta.greg.pom.pages.trainee.Attendance;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class TraineeAttendanceStepdefs {

    protected WebDriver webDriver;
    private Login loginPage;
    private HomeTrainee homePage;
    private Attendance traineeAttendance;
    private Properties properties = new Properties();
    String usernameTrainee;
    String passwordTrainee;

    @Given("I am logged in as a trainee and on the Trainee Attendance page")
    public void iAmLoggedInAsATraineeAndOnTheTraineeAttendancePage() {
        webDriver = new ChromeDriver();
        loginPage = new Login(webDriver);

        try {
            properties.load(new FileReader("src/test/resources/login.properties"));
            usernameTrainee = properties.getProperty("traineeUsername");
            passwordTrainee = properties.getProperty("traineePassword");
        } catch (IOException e) {
            e.printStackTrace();
        }
        homePage = loginPage.logInAsTrainee(usernameTrainee, passwordTrainee);
        traineeAttendance = homePage.goToWeeklyAttendance();
    }

    @When("I click on week {int}")
    public void iClickOnWeek(int arg0) {
        traineeAttendance.clickWeek(arg0);
    }

    @Then("The dropdown for week {int} will be toggled")
    public void theDropdownForWeekWillBeToggled(int arg0) {
        Assertions.assertTrue(traineeAttendance.isToggledOnWeek(arg0));
        webDriver.close();
        webDriver.quit();
    }

}
