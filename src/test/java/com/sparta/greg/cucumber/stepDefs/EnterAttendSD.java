package com.sparta.greg.cucumber.stepdefs;

import com.sparta.greg.pom.pages.components.PropertyLoader;
import com.sparta.greg.pom.pages.trainer.EnterAttendance;
import com.sparta.greg.pom.pages.trainer.HomeTrainer;
import com.sparta.greg.pom.pages.components.Login;
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
import java.util.concurrent.TimeUnit;

public class EnterAttendSD {

    private static WebDriver webDriver;
    EnterAttendance attendancePage;
    Properties properties;

    @Given("I am logged in as a trainer and I am on the attendance page")
    public void iAmOnTheAttendancePage() {
        webDriver = new ChromeDriver();
        PropertyLoader.loadProperties();
        properties = PropertyLoader.properties;
        //SignIn
        Login login = new Login(webDriver);
        HomeTrainer trainer = login.logInAsTrainer(properties.getProperty("trainerUsername"),properties.getProperty("trainerPassword") );
        attendancePage = trainer.goToEnterAttendanceThroughDashboard();

        //Go to right page
        webDriver.get("http://localhost:8080/trainer/attendanceEntry");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        attendancePage = new EnterAttendance(webDriver);
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        attendancePage.setPageConfirm();
        Assertions.assertTrue(attendancePage.areOnAttendanceEntryPage("Set Trainee Attendance"));
    }

    @When("I select a trainee on attendance page")
    public void iSelectATrainee() {
        webDriver.get("http://localhost:8080/trainer/attendanceEntry");
        attendancePage.selectTrainee("Bill");
    }

    @And("Select the desired radio button for attendance type")
    public void selectTheDesiredRadioButton() {
        attendancePage.selectAttendanceType("Late");
    }

    @And("Select a date within the course limits on attendance page")
    public void selectADateWithinTheCourseLimits() {
        attendancePage.selectDate("22-09-2020");
    }

    @Then("I will receive a completed successfully message on attendance page")
    public void iWillReceiveACompletedSuccessfullyMessage()
    {
        attendancePage.submit();
        attendancePage.setSubmitMessage("success");
        String string = "Attendance successfully";
        Assertions.assertTrue(attendancePage.getSubmitMessage().contains(string));
        webDriver.close();
    }

    @And("I click submit Attendance")
    public void iClickSubmit() {
        attendancePage.submit();
    }

    @When("I put in a date that's outside the course bounds on attendance page")
    public void iPutInADateThatSOutsideTheCourseBounds() {
        attendancePage.selectDate("08-02-2021");
        attendancePage.submit();
    }

    @Then("I will receive an error message on attendance page")
    public void iShouldReceiveAnErrorMessage() {
        attendancePage.setSubmitMessage("fail");
        String string = "This course has finished!";
        Assertions.assertTrue(attendancePage.getSubmitMessage().contains(string));
        webDriver.close();
    }

    @Given("I have selected a date on Attendance Page")
    public void iHaveSelectedADate() {
        webDriver.get("http://localhost:8080/trainer/attendanceEntry");
        attendancePage = new EnterAttendance(webDriver);
        attendancePage.setPageConfirm();
        Assertions.assertTrue(attendancePage.areOnAttendanceEntryPage("Set Trainee Attendance"));
        attendancePage.selectDate("22-09-2020");
        Assertions.assertTrue(attendancePage.isCorrectDate("22-09-2020"));
    }

    @Then("I will receive a completed successfully message with a matching date")
    public void iWillReceiveACompletedSuccessfullyMessageWithAMatchingDate()
    {
        String string = "2020-09-22";
        attendancePage.setSubmitMessage("success");
        Assertions.assertTrue(attendancePage.getSubmitMessage().contains(string));
        webDriver.close();
    }

    @When("I change the trainee to {string}")
    public void iChangeTheTraineeTo(String arg0) {
        attendancePage.selectDate("22-09-2020");
        attendancePage.selectTrainee(arg0);
    }

    @Then("I get a success message containing {string}")
    public void iGetASuccessMessageContaining(String arg0) {
        attendancePage.submit();
        attendancePage.setSubmitMessage("success");
        Assertions.assertTrue(attendancePage.getSubmitMessage().contains(arg0));
        webDriver.close();
    }

    @When("I select the radio button {string}")
    public void iSelectTheRadioButton(String arg0) {
        attendancePage.selectAttendanceType(arg0);
    }

    @Then("The radio button selected will be {string}")
    public void theRadioButtonSelectedWillBe(String arg0) {
        Assertions.assertTrue(attendancePage.isCorrectAttendanceType(arg0));
        webDriver.close();
    }
}
