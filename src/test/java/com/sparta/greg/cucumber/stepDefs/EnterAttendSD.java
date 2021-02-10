package com.sparta.greg.cucumber.stepdefs;

import com.sparta.greg.pom.pages.EnterAttendance;
import com.sparta.greg.pom.pages.HomeTrainer;
import com.sparta.greg.pom.pages.Login;
import com.sparta.greg.pom.pages.EnterAttendance;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

public class EnterAttendSD {

    private static WebDriver webDriver;
    EnterAttendance attendancePage;
    Properties properties = new Properties();

    @Given("I am on the attendance page")
    public void iAmOnTheAttendancePage() {
        webDriver = new ChromeDriver();
        try {
            properties.load(new FileReader("src/test/resources/login.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //SignIn
        Login login = new Login(webDriver);
        HomeTrainer trainer = login.logInAsTrainer(properties.getProperty("trainerUsername"),properties.getProperty("trainerPassword") );
        attendancePage = trainer.goToEnterAttendanceThroughDashboard();

        //Go to right page
        webDriver.get("http://localhost:8080/trainer/attendanceEntry");
        attendancePage = new EnterAttendance(webDriver);
        attendancePage.setPageConfirm();
        Assertions.assertEquals("Set Trainee Attendance", attendancePage.getPageConfirm());
    }

    @When("I select a trainee")
    public void iSelectATrainee() {
        webDriver.get("http://localhost:8080/trainer/attendanceEntry");
        attendancePage.selectTrainee("Bill");
    }

    @And("Select the desired radio button")
    public void selectTheDesiredRadioButton() {
        attendancePage.selectAttendanceType("Late");
    }

    @And("Select a date within the course limits")
    public void selectADateWithinTheCourseLimits() {
        attendancePage.selectDate("22-09-2020");
    }

    @Then("I will receive a completed successfully message")
    public void iWillReceiveACompletedSuccessfullyMessage()
    {
        attendancePage.submit();
        attendancePage.setSubmitMessage("success");
        String string = "Attendance successfully";
        Assertions.assertTrue(attendancePage.getSubmitMessage().contains(string));
    }

    @Given("I am signed in for radioButton check")
    public void iAmSignedInForRadioButtonCheck() {
        webDriver.get("http://localhost:8080/trainer/attendanceEntry");
        attendancePage = new EnterAttendance(webDriver);
        attendancePage.setPageConfirm();
        Assertions.assertEquals("Set Trainee Attendance", attendancePage.getPageConfirm());
    }

    @When("I change the radio button attendance type")
    public void iChangeTheRadioButtonAttendanceType() {
        attendancePage.selectDate("22-09-2020");
        attendancePage.selectAttendanceType("On Time");
        Assertions.assertTrue(webDriver.findElement(By.id("attendanceId1")).isSelected());
    }

    @And("I click submit")
    public void iClickSubmit() {
        attendancePage.submit();
    }

    @Then("I will still receive a completed successfully message")
    public void iWillStillReceiveACompletedSuccessfullyMessage() {
        attendancePage.setSubmitMessage("success");
        String string = "Attendance successfully";
        Assertions.assertTrue(attendancePage.getSubmitMessage().contains(string));
    }

    @Given("I am signed in on the attendance page")
    public void iAmSignedInOnTheAttendancePage() {
        webDriver.get("http://localhost:8080/trainer/attendanceEntry");
        attendancePage = new EnterAttendance(webDriver);
        attendancePage.setPageConfirm();
        Assertions.assertEquals("Set Trainee Attendance", attendancePage.getPageConfirm());
    }

    @When("I put in a date that's outside the course bounds")
    public void iPutInADateThatSOutsideTheCourseBounds() {
        attendancePage.selectDate("08-02-2021");
        attendancePage.submit();
    }

    @Then("I should receive an error message")
    public void iShouldReceiveAnErrorMessage() {
        attendancePage.setSubmitMessage("fail");
        String string = "This course has finished!";
        Assertions.assertTrue(attendancePage.getSubmitMessage().contains(string));
    }

    @Given("I have selected a date")
    public void iHaveSelectedADate() {
        webDriver.get("http://localhost:8080/trainer/attendanceEntry");
        attendancePage = new EnterAttendance(webDriver);
        attendancePage.setPageConfirm();
        Assertions.assertEquals("Set Trainee Attendance", attendancePage.getPageConfirm());
        attendancePage.selectDate("22-09-2020");
    }

    @When("I submit my request")
    public void iSubmitMyRequest() {
        attendancePage.submit();
    }

    @Then("I will receive a completed successfully message with a matching date")
    public void iWillReceiveACompletedSuccessfullyMessageWithAMatchingDate()
    {
        String string = "2020-09-22";
        attendancePage.setSubmitMessage("success");
        Assertions.assertTrue(attendancePage.getSubmitMessage().contains(string));
    }

    @Given("I have multiple trainee")
    public void iHaveMultipleTrainee() {
        webDriver.get("http://localhost:8080/trainer/attendanceEntry");
        attendancePage = new EnterAttendance(webDriver);
        attendancePage.setPageConfirm();
    }

    @When("I change the employee")
    public void iChangeTheEmployee() {
        attendancePage.selectTrainee("Bill");
        Assertions.assertTrue(webDriver.findElement(By.name("traineeId")).getText().contains("Bill"));
    }

    @Then("I can add their attendance easily")
    public void iCanAddTheirAttendanceEasily() {
        attendancePage.selectDate("22-09-2020");
        attendancePage.selectTrainee("Reece");
        attendancePage.submit();
        attendancePage.setSubmitMessage("success");
        Assertions.assertTrue(attendancePage.getSubmitMessage().contains("Reece"));
    }
}
