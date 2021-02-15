package com.sparta.greg.cucumber.stepdefs;

import com.sparta.greg.pom.pages.components.Login;
import com.sparta.greg.pom.pages.components.PropertyLoader;
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

public class AttendanceStepdefs {

    WebDriver webDriver;
    Login loginPage;
    HomeTrainee homePage;
    Attendance traineeAttendance;
    String usernameTrainee;
    String passwordTrainee;

    @Given("I am logged in as a trainee and on the Trainee Attendance page")
    public void iAmLoggedInAsATraineeAndOnTheTraineeAttendancePage() {
        webDriver = new ChromeDriver();
        loginPage = new Login(webDriver);
        PropertyLoader.loadProperties();
        usernameTrainee = PropertyLoader.properties.getProperty("traineeUsername");
        passwordTrainee = PropertyLoader.properties.getProperty("traineePassword");
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
