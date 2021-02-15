package com.sparta.greg.cucumber.stepdefs;

import com.sparta.greg.pom.pages.components.Login;
import com.sparta.greg.pom.pages.components.PropertyLoader;
import com.sparta.greg.pom.pages.trainer.WeeklyAttendance;
import com.sparta.greg.pom.webDriverFactory.WebDriverFactory;
import com.sparta.greg.pom.webDriverFactory.WebDriverType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Properties;

public class ViewClassAttendanceSD {

    String username;
    String password;
    private WebDriver webDriver;
    private WeeklyAttendance weeklyAttendance;

    private void loginAndGoToWeeklyAttendance() {
        //webDriver = WebDriverFactory.runHeadless(WebDriverType.CHROME);
        webDriver = WebDriverFactory.getWebDriver(WebDriverType.CHROME);
        webDriver.get("http://localhost:8080/login");

        PropertyLoader.loadProperties();
        username = PropertyLoader.properties.getProperty("trainerUsername");
        password = PropertyLoader.properties.getProperty("trainerPassword");

        Login login = new Login(webDriver);
        login.logInAsTrainer(username, password);

        webDriver.get("http://localhost:8080/trainer/weekly-attendance");
        weeklyAttendance = new WeeklyAttendance(webDriver);
    }

    @Given("I am logged in as a trainer and on the Weekly Attendance page")
    public void iAmLoggedInAsATrainerAndOnTheWeeklyAttendancePage() {
        loginAndGoToWeeklyAttendance();
    }

    @Then("The week {int} tab should expand on the Weekly Attendance page")
    public void theWeekNumberTabShouldExpandOnTheWeeklyAttendancePage(int arg0) {
        Assertions.assertTrue(weeklyAttendance.isWeekExpanded(arg0));
        webDriver.quit();
    }

    @And("I have opened the attendance tab for week {int} on the Weekly Attendance page")
    public void iHaveOpenedTheAttendanceTabForWeekNumberOnTheWeeklyAttendancePage(int arg0) {
        weeklyAttendance.clickWeekRow(arg0);
    }

    @Then("The week {int} tab should close on the Weekly Attendance page")
    public void theWeekNumberTabShouldCloseOnTheWeeklyAttendancePage(int arg0) {
        Assertions.assertFalse(weeklyAttendance.isWeekExpanded(arg0));
        webDriver.quit();
    }

    @When("I click on the week {int} tab {int} times in quick succession on the Weekly Attendance page")
    public void iClickOnTheWeekTabTimesInQuickSuccessionOnTheWeeklyAttendancePage(int arg0, int arg1) {
        for (int i = 0; i <= arg1; i++) {
            weeklyAttendance.clickWeekRow(arg0);
        }
    }

    @Then("The week {int} tab should be closed on the Weekly Attendance page")
    public void theWeekTabShouldBeClosedOnTheWeeklyAttendancePage(int arg0) {
        Assertions.assertFalse(weeklyAttendance.isWeekExpanded(arg0));
    }

    @And("The week {int} attendance table should not be visible at all on the Weekly Attendance page")
    public void theWeekAttendanceTableShouldNotBeVisibleAtAllOnTheWeeklyAttendancePage(int arg0) {
        List<WebElement> studentList = weeklyAttendance.getStudentListForWeek(arg0);
        for (int i = 0 + 1; i < studentList.size(); i++) {
            WebElement studentRow = studentList.get(i);
            double height = Double.parseDouble(studentRow.getCssValue("height").replace("px", ""));
            Assertions.assertEquals(0, height);
        }
        webDriver.quit();
    }

    @When("I click Dashboard on the trainer sidebar on the Weekly Attendance page")
    public void iClickDashboardOnTheTrainerSidebarOnTheWeeklyAttendancePage() {
        weeklyAttendance.getSideBarTrainer().goToHomePageByClickingDashboard();
    }

    @Then("I am taken to the Home Trainer page from the Weekly Attendance page")
    public void iAmTakenToTheHomeTrainerPageFromTheWeeklyAttendancePage() {
        Assertions.assertEquals("http://localhost:8080/trainer/home", webDriver.getCurrentUrl());
        webDriver.quit();
    }

    @When("I click the Sparta Global logo on the trainer sidebar on the Weekly Attendance page")
    public void iClickTheSpartaGlobalLogoOnTheTrainerSidebarOnTheWeeklyAttendancePage() {
        weeklyAttendance.getSideBarTrainer().goToHomePageByClickingLogo();
    }

    @When("I click View on the trainer sidebar on the Weekly Attendance page")
    public void iClickViewOnTheTrainerSidebarOnTheWeeklyAttendancePage() {
        weeklyAttendance.getSideBarTrainer().selectView();
    }

    @And("I click on Consultancy Skills on the Weekly Attendance page")
    public void iClickOnConsultancySkillsOnTheWeeklyAttendancePage() {
        weeklyAttendance.getSideBarTrainer().goToConsultancySkills();
    }

    @Then("I am taken to the Consultancy Skills page from the Weekly Attendance page")
    public void iAmTakenToTheConsultancySkillsPageFromTheWeeklyAttendancePage() {
        Assertions.assertEquals("http://localhost:8080/consultancy", webDriver.getCurrentUrl());
        webDriver.quit();
    }

    @And("I click on Trainee Guide on the Weekly Attendance page")
    public void iClickOnTraineeGuideOnTheWeeklyAttendancePage() {
        weeklyAttendance.getSideBarTrainer().goToTraineeGuide();
    }

    @Then("I am taken to the Trainee Guide page from the Weekly Attendance Page")
    public void iAmTakenToTheTraineeGuidePageFromTheWeeklyAttendancePage() {
        Assertions.assertEquals("http://localhost:8080/guide", webDriver.getCurrentUrl());
        webDriver.quit();
    }

    @When("I click Trainer Options on the trainer sidebar on the Weekly Attendance page")
    public void iClickTrainerOptionsOnTheTrainerSidebarOnTheWeeklyAttendancePage() {
        weeklyAttendance.getSideBarTrainer().clickTrainerOptions();
    }

    @And("I click on Class Management on the Weekly Attendance page")
    public void iClickOnClassManagementOnTheWeeklyAttendancePage() {
        weeklyAttendance.getSideBarTrainer().goToClassManagement();
    }

    @Then("I am taken to the Class Management page from the Weekly Attendance page")
    public void iAmTakenToTheClassManagementPageFromTheWeeklyAttendancePage() {
        Assertions.assertEquals("http://localhost:8080/trainer/manageClass", webDriver.getCurrentUrl());
        webDriver.quit();
    }

    @And("I click on Trainee Management on the Weekly Attendance page")
    public void iClickOnTraineeManagementOnTheWeeklyAttendancePage() {
        weeklyAttendance.getSideBarTrainer().goToTraineeManagement();
    }

    @Then("I am taken to the Manage Trainee page from the Weekly Attendance page")
    public void iAmTakenToTheManageTraineePageFromTheWeeklyAttendancePage() {
        Assertions.assertEquals("http://localhost:8080/trainer/manageTrainee", webDriver.getCurrentUrl());
        webDriver.quit();
    }

    @And("I click on Add Weeks on the Weekly Attendance page")
    public void iClickOnAddWeeksOnTheWeeklyAttendancePage() {
        weeklyAttendance.getSideBarTrainer().goToAddWeeks();
    }

    @Then("I am taken to the Add Weeks page from the Weekly Attendance page")
    public void iAmTakenToTheAddWeeksPageFromTheWeeklyAttendancePage() {
        Assertions.assertEquals("http://localhost:8080/trainer/newWeek", webDriver.getCurrentUrl());
        webDriver.quit();
    }

    @And("I click on Assessments on the Weekly Attendance page")
    public void iClickOnAssessmentsOnTheWeeklyAttendancePage() {
        weeklyAttendance.getSideBarTrainer().goToAssessments();
    }

    @Then("I am taken to the Assessments page from the Weekly Attendance page")
    public void iAmTakenToTheAssessmentsPageFromTheWeeklyAttendancePage() {
        Assertions.assertEquals("http://localhost:8080/trainer/assessments", webDriver.getCurrentUrl());
        webDriver.quit();
    }

    @And("I click on Enter Attendance on the Weekly Attendance page")
    public void iClickOnEnterAttendanceOnTheWeeklyAttendancePage() {
        weeklyAttendance.getSideBarTrainer().goToEnterAttendance();
    }

    @Then("I am taken to the Enter Attendance page from the Weekly Attendance page")
    public void iAmTakenToTheEnterAttendancePageFromTheWeeklyAttendancePage() {
        Assertions.assertEquals("http://localhost:8080/trainer/attendanceEntry", webDriver.getCurrentUrl());
        webDriver.quit();
    }

    @And("I click on Weekly Attendance on the Weekly Attendance page")
    public void iClickOnWeeklyAttendanceOnTheWeeklyAttendancePage() {
        weeklyAttendance.getSideBarTrainer().goToWeeklyAttendance();
    }

    @Then("I am taken to the Weekly Attendance page from the Weekly Attendance page")
    public void iAmTakenToTheWeeklyAttendancePageFromTheWeeklyAttendancePage() {
    }

    @And("If the week {int} tab is open, it is closed")
    public void ifTheWeekTabIsOpenItIsClosed(int arg0) {
        if (weeklyAttendance.isWeekExpanded(arg0)) {
            weeklyAttendance.clickWeekRow(arg0);
        }
    }

    @When("I wait for {double} seconds, then click on the tab for week {int} on the Weekly Attendance page")
    public void iWaitForSecondsThenClickOnTheTabForWeekNumberOnTheWeeklyAttendancePage(double arg0, int arg1) {
        try {
            Thread.sleep(Math.round(arg0 * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        weeklyAttendance.clickWeekRow(arg1);
    }

    @When("I click on the tab for week {int} on the Weekly Attendance page")
    public void iClickOnTheTabForWeekNumberOnTheWeeklyAttendancePage(int arg0) {
        weeklyAttendance.clickWeekRow(arg0);
    }

    @Then("The week {int} tab should show a table with {int} columns")
    public void theWeekNumberTabShouldShowATableWithColumns(int arg0, int arg1) {
        int noOfStudents = weeklyAttendance.getStudentListForWeek(arg0).size();
        weeklyAttendance.clickWeekRow(arg0);
        boolean correctDays = true;
        for (int i = 0; i < noOfStudents; i++) {
            if (weeklyAttendance.getDayListForStudent(arg0, i).size() > arg1) {
                System.out.println(weeklyAttendance.getDayListForStudent(arg0, i).size());
                correctDays = false;
                break;
            }
        }
        Assertions.assertTrue(correctDays);
        webDriver.quit();
    }
}
