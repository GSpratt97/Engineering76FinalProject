package com.sparta.greg.cucumber.stepdefs;

import com.sparta.greg.pom.pages.Login;
import com.sparta.greg.pom.pages.utilities.PropertyLoader;
import com.sparta.greg.pom.pages.trainer.TraineeProfile;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;

public class TraineeProfileStepdefs {
    WebDriver webDriver;
    String usernameTrainer;
    String passwordTrainer;
    TraineeProfile traineeProfilePage;

    HashMap<String, String> detailsBillBird = new HashMap<>();

    private void loadPropertiesLoginAsTrainerGoToTraineeProfile() {
        webDriver = new ChromeDriver();
        webDriver.get("http://localhost:8080/login");

        PropertyLoader.loadProperties();
        usernameTrainer = PropertyLoader.properties.getProperty("trainerUsername");
        passwordTrainer = PropertyLoader.properties.getProperty("trainerPassword");

        Login login = new Login(webDriver);
        login.logInAsTrainer(usernameTrainer, passwordTrainer);

        webDriver.get("http://localhost:8080/trainer/traineeProfile/41");

        traineeProfilePage = new TraineeProfile(webDriver);

        detailsBillBird.put("Full Name", "Bill Bird");
        detailsBillBird.put("Assigned Class", "Engineering 72");
        detailsBillBird.put("Course Assigned", "Java Development");
        detailsBillBird.put("Current Week of Course", "12");
        detailsBillBird.put("On Time", "0%");
        detailsBillBird.put("Late", "100%");
        detailsBillBird.put("Excused Absence", "0%");
        detailsBillBird.put("Unexcused Absence", "0%");
        detailsBillBird.put("Consultant Grade", "C");
        detailsBillBird.put("Technical Grade", "C");
        detailsBillBird.put("Overall Grade", "C");
        detailsBillBird.put("SQL Score", "30.9%");
        detailsBillBird.put("SQL Grade", "FAIL");
        detailsBillBird.put("SQL Assessment Date", "11/22/2019");
        detailsBillBird.put("SQL Duration", "77 mins");
        detailsBillBird.put("SQL Comparative Score", "27%");
        detailsBillBird.put("SQL Design Score", "16%");
        detailsBillBird.put("SQL Language and Knowledge Score", "29%");
        detailsBillBird.put("SQL Problem Solving Score", "40%");
        detailsBillBird.put("Not SQL Score", "78.0%");
        detailsBillBird.put("Not SQL Grade", "B-");
        detailsBillBird.put("Not SQL Assessment Date", "11/22/2019");
        detailsBillBird.put("Not SQL Duration", "77 mins");
        detailsBillBird.put("Not SQL Comparative Score", "27%");
        detailsBillBird.put("Not SQL Design Score", "16%");
        detailsBillBird.put("Not SQL Language and Knowledge Score", "29%");
        detailsBillBird.put("Not SQL Problem Solving Score", "40%");

    }


    @Given("I am logged in as a trainer and on the Trainee Profile Page of {string}")
    public void iAmLoggedInAsATrainerAndOnTheTraineeProfilePageOf(String trainee) {
        if (trainee.equals("Bill Bird")) {
            loadPropertiesLoginAsTrainerGoToTraineeProfile();
        }
    }

    @When("I look at the Trainee Details of the trainee on the Trainee Profile Page")
    public void iLookAtTheTraineeDetailsOfTheTraineeOnTheTraineeProfilePage() {
    }

    @Then("I see the details of {string} on the Trainee Profile Page")
    public void iSeeTheDetailsOfOnTheTraineeProfilePage(String trainee) {
        // Would be better to link the data here to the SQL database and find trainee based on e.g. name
        if (trainee.equals("Bill Bird")) {
            Assertions.assertEquals(traineeProfilePage.getFullName(), detailsBillBird.get("Full Name"));
            Assertions.assertEquals(traineeProfilePage.getAssignedClass(), detailsBillBird.get("Assigned Class"));
            Assertions.assertEquals(traineeProfilePage.getCourseAssigned(), detailsBillBird.get("Course Assigned"));
            Assertions.assertEquals(traineeProfilePage.getCurrentWeekOfCourse(), detailsBillBird.get("Current Week of Course"));

        } else {
            System.out.println("This @Then should not be used for any trainee apart from Bill Bird");
            Assertions.fail();
        }
        webDriver.quit();

    }

    @When("I look at the Attendance Breakdown of the trainee on the Trainee Profile Page")
    public void iLookAtTheAttendanceBreakdownOfTheTraineeOnTheTraineeProfilePage() {
    }

    @Then("I see the Attendance Breakdown of {string} on the Trainee Profile Page")
    public void iSeeTheAttendanceBreakdownOfOnTheTraineeProfilePage(String trainee) {
        if (trainee.equals("Bill Bird")) {
            Assertions.assertEquals(traineeProfilePage.getOnTime(), detailsBillBird.get("On Time"));
            Assertions.assertEquals(traineeProfilePage.getLate(), detailsBillBird.get("Late"));
            Assertions.assertEquals(traineeProfilePage.getExcusedAbsence(), detailsBillBird.get("Excused Absence"));
            Assertions.assertEquals(traineeProfilePage.getUnexcusedAbsence(), detailsBillBird.get("Unexcused Absence"));
        } else {
            System.out.println("This @Then should not be used for any trainee apart from Bill Bird");
            Assertions.fail();
        }
        webDriver.quit();
    }

    @When("I look at the Grades for Previous Week of the trainee on the Trainee Profile Page")
    public void iLookAtTheGradesForPreviousWeekOfTheTraineeOnTheTraineeProfilePage() {
    }

    @Then("I see the Grades for Previous Week of {string} on the Trainee Profile Page")
    public void iSeeTheGradesForPreviousWeekOfOnTheTraineeProfilePage(String trainee) {
        if (trainee.equals("Bill Bird")) {
            Assertions.assertEquals(traineeProfilePage.getConsultantGrade(), detailsBillBird.get("Consultant Grade"));
            Assertions.assertEquals(traineeProfilePage.getTechnicalGrade(), detailsBillBird.get("Technical Grade"));
            Assertions.assertEquals(traineeProfilePage.getOverallGrade(), detailsBillBird.get("Overall Grade"));
        } else {
            System.out.println("This @Then should not be used for any trainee apart from Bill Bird");
            Assertions.fail();
        }
        webDriver.quit();
    }

    @When("I look at the General SQL Results of the trainee on the Trainee Profile Page")
    public void iLookAtTheGeneralSQLResultsOfTheTraineeOnTheTraineeProfilePage() {
    }

    @Then("I see the General SQL Results of {string} on the Trainee Profile Page")
    public void iSeeTheGeneralSQLResultsOfOnTheTraineeProfilePage(String trainee) {
        if (trainee.equals("Bill Bird")) {
            // Wrong Score, only currently have the one in the breakdown
            // Assertions.assertEquals(traineeProfilePage.getSqlScore(), detailsBillBird.get("SQL Score"));
            Assertions.assertEquals(traineeProfilePage.getGradeSQL(), detailsBillBird.get("SQL Grade"));

            // Don't see a way of getting assessment date from HTML
            //Assertions.assertEquals(traineeProfilePage.getSqlAssessmentDate(), detailsBillBird.get("SQL Assessment Date"));
        } else {
            System.out.println("This @Then should not be used for any trainee apart from Bill Bird");
            Assertions.fail();
        }
        webDriver.quit();
    }

    @When("I look at the General Not SQL Results of the trainee on the Trainee Profile Page")
    public void iLookAtTheGeneralNotSQLResultsOfTheTraineeOnTheTraineeProfilePage() {
    }

    @Then("I see the General Not SQL Results of {string} on the Trainee Profile Page")
    public void iSeeTheGeneralNotSQLResultsOfOnTheTraineeProfilePage(String trainee) {
        if (trainee.equals("Bill Bird")) {
            // Wrong Score, only currently have the one in the breakdown
            // Assertions.assertEquals(traineeProfilePage.getNotSqlScore(), detailsBillBird.get("Not SQL Score"));
            Assertions.assertEquals(traineeProfilePage.getGradeNotSQL(), detailsBillBird.get("Not SQL Grade"));

            // Don't see a way of getting assessment date from HTML
            //Assertions.assertEquals(traineeProfilePage.getNotSqlAssessmentDate(), detailsBillBird.get("Not SQL Assessment Date"));
        } else {
            System.out.println("This @Then should not be used for any trainee apart from Bill Bird");
            Assertions.fail();
        }
        webDriver.quit();
    }

    @When("I click on the toggle SQL breakdown button on the Trainee Profile Page")
    public void iClickOnTheToggleSQLBreakdownButtonOnTheTraineeProfilePage() {
        traineeProfilePage.toggleExpandSQLBreakdown();
    }

    @And("I look at the SQL Score Breakdown on the Trainee Profile Page")
    public void iLookAtTheSQLScoreBreakdownOnTheTraineeProfilePage() {
    }

    @Then("I see the specific SQL score breakdown of {string} on the Trainee Profile Page")
    public void iSeeTheCorrectSQLScoreBreakdownOnTheTraineeProfilePage(String trainee) {
        if (trainee.equals("Bill Bird")) {
            Assertions.assertEquals(traineeProfilePage.getSqlScore(), detailsBillBird.get("SQL Score"));
            Assertions.assertEquals(traineeProfilePage.getSqlDuration(), detailsBillBird.get("SQL Duration"));
            Assertions.assertEquals(traineeProfilePage.getSqlComparativeScore(), detailsBillBird.get("SQL Comparative Score"));
            Assertions.assertEquals(traineeProfilePage.getSqlDesignScore(), detailsBillBird.get("SQL Design Score"));
            Assertions.assertEquals(traineeProfilePage.getSqlLanguageAndKnowledgeScore(), detailsBillBird.get("SQL Language and Knowledge Score"));
            Assertions.assertEquals(traineeProfilePage.getSqlProblemSolvingScore(), detailsBillBird.get("SQL Problem Solving Score"));
        } else {
            System.out.println("This @Then should not be used for any trainee apart from Bill Bird");
            Assertions.fail();
        }
        webDriver.quit();

    }

    @When("I click on the toggle Not SQL breakdown button on the Trainee Profile Page")
    public void iClickOnTheToggleNotSQLBreakdownButtonOnTheTraineeProfilePage() {
        traineeProfilePage.toggleExpandNotSQLBreakdown();
    }

    @And("I look at the Not SQL Breakdown on the Trainee Profile Page")
    public void iLookAtTheNotSQLBreakdownOnTheTraineeProfilePage() {
    }

    @Then("I see the specific Not SQL score breakdown of {string} on the Trainee Profile Page")
    public void iSeeTheCorrectNotSQLScoreBreakdownOnTheTraineeProfilePage(String trainee) {
        if (trainee.equals("Bill Bird")) {
            Assertions.assertEquals(traineeProfilePage.getNotSqlScore(), detailsBillBird.get("Not SQL Score"));
            Assertions.assertEquals(traineeProfilePage.getNotSqlDuration(), detailsBillBird.get("Not SQL Duration"));
            Assertions.assertEquals(traineeProfilePage.getNotSqlComparativeScore(), detailsBillBird.get("Not SQL Comparative Score"));
            Assertions.assertEquals(traineeProfilePage.getNotSqlDesignScore(), detailsBillBird.get("Not SQL Design Score"));
            Assertions.assertEquals(traineeProfilePage.getNotSqlLanguageAndKnowledgeScore(), detailsBillBird.get("Not SQL Language and Knowledge Score"));
            Assertions.assertEquals(traineeProfilePage.getNotSqlProblemSolvingScore(), detailsBillBird.get("Not SQL Problem Solving Score"));
        } else {
            System.out.println("This @Then should not be used for any trainee apart from Bill Bird");
            Assertions.fail();
        }
        webDriver.quit();
    }

    @When("I click on Attendance Details on the Trainee Profile Page")
    public void iClickOnAttendanceDetailsOnTheTraineeProfilePage() {
        traineeProfilePage.goToTraineeAttendance();
    }

    @Then("I am taken to the Weekly Attendance Page from the Trainee Profile Page")
    public void iAmTakenToTheWeeklyAttendancePageFromTheTraineeProfilePage() {
        Assertions.assertTrue(webDriver.getCurrentUrl().contains("http://localhost:8080/trainer/weekly-attendance"));
        webDriver.quit();
    }

    @When("I click on Report Details on the Trainee Profile Page")
    public void iClickOnReportDetailsOnTheTraineeProfilePage() {
        traineeProfilePage.goToTraineeReport();
    }

    @Then("I am taken to the Report Trainer Page from the Trainee Profile Page")
    public void iAmTakenToTheReportTrainerPageFromTheTraineeProfilePage() {
        Assertions.assertTrue(webDriver.getCurrentUrl().contains("http://localhost:8080/trainer/report/"));
        webDriver.quit();
    }

    @When("I click on Back to Dashboard on the Trainee Profile Page")
    public void iClickOnBackToDashboardOnTheTraineeProfilePage() {
        traineeProfilePage.goBackToHomePageViaBackToDashboardButton();
    }

    @Then("I am taken to the Home Trainer Page from the Trainee Profile Page")
    public void iAmTakenToTheHomeTrainerPageFromTheTraineeProfilePage() {
        Assertions.assertEquals(webDriver.getCurrentUrl(), "http://localhost:8080/trainer/home");
        webDriver.quit();
    }

    // Standard Navigation using Sidebar

    @When("I click View on the trainer sidebar on the Trainee Profile Page")
    public void iClickViewOnTheTrainerSidebarOnTheTraineeProfilePage() {
        traineeProfilePage.getSideBarTrainer().selectView();
    }

    @And("I click on Consultancy Skills on the trainer sidebar on the Trainee Profile Page")
    public void iClickOnConsultancySkillsOnTheTrainerSidebarOnTheTraineeProfilePage() {
        traineeProfilePage.getSideBarTrainer().goToConsultancySkills();
    }

    @Then("I am taken to the Consultancy Skills Page from the Trainee Profile Page")
    public void iAmTakenToTheConsultancySkillsPageFromTheTraineeProfilePage() {
        Assertions.assertEquals("http://localhost:8080/consultancy", webDriver.getCurrentUrl());
        webDriver.quit();
    }

    @And("I click on Trainee Guide on the trainer sidebar the Trainee Profile Page")
    public void iClickOnTraineeGuideOnTheTrainerSidebarTheTraineeProfilePage() {
        traineeProfilePage.getSideBarTrainer().goToTraineeGuide();
    }

    @Then("I am taken to the Trainee Guide Page from the Trainee Profile Page")
    public void iAmTakenToTheTraineeGuidePageFromTheTraineeProfilePage() {
        Assertions.assertEquals("http://localhost:8080/guide", webDriver.getCurrentUrl());
        webDriver.quit();
    }

    @When("I click Trainer Options on the trainer sidebar on the Trainee Profile Page")
    public void iClickTrainerOptionsOnTheTrainerSidebarOnTheTraineeProfilePage() {
        traineeProfilePage.getSideBarTrainer().clickTrainerOptions();
    }

    @And("I click on Class Management on the trainer sidebar on the Trainee Profile Page")
    public void iClickOnClassManagementOnTheTrainerSidebarOnTheTraineeProfilePage() {
        traineeProfilePage.getSideBarTrainer().goToClassManagement();
    }

    @Then("I am taken to the Class Management Page from the Trainee Profile Page")
    public void iAmTakenToTheClassManagementPageFromTheTraineeProfilePage() {
        Assertions.assertEquals("http://localhost:8080/trainer/manageClass", webDriver.getCurrentUrl());
        webDriver.quit();
    }

    @And("I click on Trainee Management on the trainer sidebar on the Trainee Profile Page")
    public void iClickOnTraineeManagementOnTheTrainerSidebarOnTheTraineeProfilePage() {
        traineeProfilePage.getSideBarTrainer().goToTraineeManagement();
    }

    @Then("I am taken to the Manage Trainee Page from the Trainee Profile Page")
    public void iAmTakenToTheManageTraineePageFromTheTraineeProfilePage() {
        Assertions.assertEquals("http://localhost:8080/trainer/manageTrainee", webDriver.getCurrentUrl());
        webDriver.quit();
    }

    @And("I click on Add Weeks on the trainer sidebar on the Trainee Profile Page")
    public void iClickOnAddWeeksOnTheTrainerSidebarOnTheTraineeProfilePage() {
        traineeProfilePage.getSideBarTrainer().goToAddWeeks();
    }

    @Then("I am taken to the Add Weeks Page from the Trainee Profile Page")
    public void iAmTakenToTheAddWeeksPageFromTheTraineeProfilePage() {
        Assertions.assertEquals("http://localhost:8080/trainer/newWeek", webDriver.getCurrentUrl());
        webDriver.quit();
    }

    @And("I click on Assessments on the trainer sidebar on the Trainee Profile Page")
    public void iClickOnAssessmentsOnTheTrainerSidebarOnTheTraineeProfilePage() {
        traineeProfilePage.getSideBarTrainer().goToAssessments();
    }

    @Then("I am taken to the Assessments Page from the Trainee Profile Page")
    public void iAmTakenToTheAssessmentsPageFromTheTraineeProfilePage() {
        Assertions.assertEquals("http://localhost:8080/trainer/assessments", webDriver.getCurrentUrl());
        webDriver.quit();
    }

    @And("I click on Enter Attendance on the trainer sidebar on the Trainee Profile Page")
    public void iClickOnEnterAttendanceOnTheTrainerSidebarOnTheTraineeProfilePage() {
        traineeProfilePage.getSideBarTrainer().goToEnterAttendance();
    }

    @Then("I am taken to the Enter Attendance Page from the Trainee Profile Page")
    public void iAmTakenToTheEnterAttendancePageFromTheTraineeProfilePage() {
        Assertions.assertEquals("http://localhost:8080/trainer/attendanceEntry", webDriver.getCurrentUrl());
        webDriver.quit();
    }

    @And("I click on Weekly Attendance on the trainer sidebar on the Trainee Profile Page")
    public void iClickOnWeeklyAttendanceOnTheTrainerSidebarOnTheTraineeProfilePage() {
        traineeProfilePage.getSideBarTrainer().goToWeeklyAttendance();
    }

    @Then("I am taken to the Trainer Attendance Page from the Trainee Profile Page")
    public void iAmTakenToTheTrainerAttendancePageFromTheTraineeProfilePage() {
        Assertions.assertEquals("http://localhost:8080/trainer/traineeAttendance/41", webDriver.getCurrentUrl());
        webDriver.quit();
    }
}
