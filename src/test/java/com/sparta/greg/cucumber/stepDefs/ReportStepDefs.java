package com.sparta.greg.cucumber.stepdefs;

import com.sparta.greg.pom.pages.components.Login;
import com.sparta.greg.pom.pages.components.PropertyLoader;
import com.sparta.greg.pom.pages.components.SideBarTrainee;
import com.sparta.greg.pom.pages.components.SideBarTrainer;
import com.sparta.greg.pom.pages.trainee.ReportTrainee;
import com.sparta.greg.pom.pages.trainer.ReportTrainer;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReportStepDefs {

    private static WebDriver        webDriver;
    private static Login            login;
    private static ReportTrainee    reportTrainee;
    private static ReportTrainer    reportTrainer;

    //----------Given----------//
    @Given("I am logged in as a Trainee and I am on the Report page")
    public void iAmLoggedInAsATraineeAndIAmOnTheReportPage() {
        webDriver   = new ChromeDriver();
        login       = new Login(webDriver);

        PropertyLoader.loadProperties();
        String traineeUsername = PropertyLoader.properties.getProperty("traineeUsername");
        String traineePassword = PropertyLoader.properties.getProperty("traineePassword");

        login.logInAsTrainee(traineeUsername, traineePassword);
        webDriver.get("http://localhost:8080/trainee/report");

        reportTrainee = new ReportTrainee(webDriver);
        reportTrainee.setWeekReports();
    }

    @Given("I am logged in as a Trainer and I am on Bill Birds Report Page")
    public void iAmLoggedInAsATrainerAndIAmOnBillBirdsReportPage() {
        webDriver   = new ChromeDriver();
        login       = new Login(webDriver);

        PropertyLoader.loadProperties();
        String trainerUsername = PropertyLoader.properties.getProperty("trainerUsername");
        String trainerPassword = PropertyLoader.properties.getProperty("trainerPassword");

        login.logInAsTrainer(trainerUsername, trainerPassword);
        webDriver.get("http://localhost:8080/trainer/report/41");

        reportTrainer = new ReportTrainer(webDriver);
        reportTrainer.setWeekReports();
    }

    //----------When----------//
    @When("I select a weekly report as a Trainee")
    public void iSelectAWeeklyReportAsATrainee() {
        reportTrainee.clickExpandButton(reportTrainee.getWeekReports().get(0));
    }

    @When("I select a weekly report as a Trainer")
    public void iSelectAWeeklyReportAsATrainer() {
        reportTrainer.clickExpandButton(reportTrainer.getWeekReports().get(0));
    }

    @When("I return to Trainee Profile")
    public void iReturnToTraineeProfile() {
        reportTrainer.backToTraineeProfile();
    }

    @When("I click View on the Trainee Sidebar")
    public void iClickViewOnTheTraineeSidebar() {
        reportTrainee.getSideBarTrainee().selectView();
    }

    @When("I click Trainee Options on the Trainee Sidebar")
    public void iClickTraineeOptionsOnTheTraineeSidebar() {
        reportTrainee.getSideBarTrainee().clickTraineeOptions();
    }

    @When("I click View on the Trainer Sidebar")
    public void iClickViewOnTheTrainerSidebar() {
        reportTrainer.getSideBarTrainer().selectView();
    }

    @When("I click Trainer Options on the Trainer Sidebar")
    public void iClickTrainerOptionsOnTheTrainerSidebar() {
        reportTrainer.getSideBarTrainer().clickTrainerOptions();
    }

    //----------And----------//
    @And("I click Consultancy Skills as a Trainee")
    public void iClickConsultancySkillsAsATrainee() {
    }

    @And("I click Trainee Guide as a Trainee")
    public void iClickTraineeGuideAsATrainee() {
    }

    @And("I click Consultancy Skills as a Trainer")
    public void iClickConsultancySkillsAsATrainer() {
    }

    @And("I click Trainee Guide as a Trainer")
    public void iClickTraineeGuideAsATrainer() {
    }

    @And("I click Feedback Form")
    public void iClickFeedbackForm() {
    }

    @And("I click Reports History")
    public void iClickReportsHistory() {
    }

    @And("I click Attendance History")
    public void iClickAttendanceHistory() {
    }

    @And("I click Class Management")
    public void iClickClassManagement() {
    }

    @And("I click Trainee Management")
    public void iClickTraineeManagement() {
    }

    @And("I click Add Weeks")
    public void iClickAddWeeks() {
    }

    @And("I click Assessments")
    public void iClickAssessments() {
    }

    @And("I click Enter Attendance")
    public void iClickEnterAttendance() {
    }

    @And("I click Weekly Attendance")
    public void iClickWeeklyAttendance() {
    }

    //----------Then----------//
    @Then("the selected weekly report is expanded as Trainee")
    public void theSelectedWeeklyReportIsExpandedAsTrainee() {
    }

    @Then("the expanded weekly report is collapsed as Trainee")
    public void theExpandedWeeklyReportIsCollapsedAsTrainee() {
    }

    @Then("the weekly reports are in descending order as Trainee")
    public void theWeeklyReportsAreInDescendingOrderAsTrainee() {
    }

    @Then("the selected weekly report is expanded as Trainer")
    public void theSelectedWeeklyReportIsExpandedAsTrainer() {
    }

    @Then("the expanded weekly report is collapsed as Trainer")
    public void theExpandedWeeklyReportIsCollapsedAsTrainer() {
    }

    @Then("the weekly reports are in descending order as Trainer")
    public void theWeeklyReportsAreInDescendingOrderAsTrainer() {
    }

    @Then("I have returned to Trainee Profile")
    public void iHaveReturnedToTraineeProfile() {
    }

    @Then("I am taken to the Trainee Consultancy Skills page")
    public void iAmTakenToTheTraineeConsultancySkillsPage() {
    }

    @Then("I am taken to the Trainee Guide page")
    public void iAmTakenToTheTraineeGuidePage() {
    }

    @Then("I am taken to the Trainee Feedback Form page")
    public void iAmTakenToTheTraineeFeedbackFormPage() {
    }

    @Then("I am taken to the Trainee Reports History page")
    public void iAmTakenToTheTraineeReportsHistoryPage() {
    }

    @Then("I am taken to the Trainee Attendance History page")
    public void iAmTakenToTheTraineeAttendanceHistoryPage() {
    }

    @Then("I am taken to the Trainer Consultancy Skills page")
    public void iAmTakenToTheTrainerConsultancySkillsPage() {
    }

    @Then("I am taken to the Trainer Trainee Guide page")
    public void iAmTakenToTheTrainerTraineeGuidePage() {
    }

    @Then("I am taken to the Class Management page")
    public void iAmTakenToTheClassManagementPage() {
    }

    @Then("I am taken to the Trainee Management page")
    public void iAmTakenToTheTraineeManagementPage() {
    }

    @Then("I am taken to the Add Weeks page")
    public void iAmTakenToTheAddWeeksPage() {
    }

    @Then("I am taken to the Assessments page")
    public void iAmTakenToTheAssessmentsPage() {
    }

    @Then("I am taken to the Enter Attendance page")
    public void iAmTakenToTheEnterAttendancePage() {
    }

    @Then("I am taken to the Weekly Attendance page")
    public void iAmTakenToTheWeeklyAttendancePage() {
    }
}
