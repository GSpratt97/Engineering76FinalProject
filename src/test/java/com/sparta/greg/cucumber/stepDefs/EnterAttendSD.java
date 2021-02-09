package com.sparta.greg.cucumber.stepDefs;

import com.sparta.greg.pom.pages.EnterAttendancePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EnterAttendSD {

    private static WebDriver webDriver;
    EnterAttendancePage attendancePage;

    @Given("I am on the attendance page")
    public void iAmOnTheAttendancePage() {
        webDriver = new ChromeDriver();
        //SignIn
        webDriver.get("http://localhost:8080");
        webDriver.findElement(By.name("username")).sendKeys();
        webDriver.findElement(By.name("password")).sendKeys();
        webDriver.findElement(By.cssSelector("button[type='submit']")).click();

        //Go to right page
        webDriver.get("http://localhost:8080/trainer/attendanceEntry");
        attendancePage = new EnterAttendancePage(webDriver);
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
        attendancePage = new EnterAttendancePage(webDriver);
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
        attendancePage = new EnterAttendancePage(webDriver);
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

}
