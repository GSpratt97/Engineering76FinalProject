package com.sparta.greg.pom.pagesTest.trainer;


import com.sparta.greg.pom.pages.components.Login;
import com.sparta.greg.pom.pages.components.PropertyLoader;
import com.sparta.greg.pom.pages.trainer.HomeTrainer;
import com.sparta.greg.pom.pages.trainer.ReportTrainer;
import com.sparta.greg.pom.pages.trainer.TraineeProfile;
import com.sparta.greg.pom.pages.trainer.WeeklyAttendance;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class TraineeProfileTest {

    private static WebDriver webDriver;
    private static String usernameTrainer;
    private static String passwordTrainer;
    private static TraineeProfile traineeProfilePage;
    private static TraineeProfile traineeProfilePageEmpty;

    @BeforeAll
    static void setup() {
        webDriver = new ChromeDriver();
        webDriver.get("http://localhost:8080/login");

        PropertyLoader.loadProperties();
        usernameTrainer = PropertyLoader.properties.getProperty("trainerUsername");
        passwordTrainer = PropertyLoader.properties.getProperty("trainerPassword");

        Login login = new Login(webDriver);
        login.logInAsTrainer(usernameTrainer, passwordTrainer);

        // Bill Bird test profile
        webDriver.get("http://localhost:8080/trainer/traineeProfile/41");

        traineeProfilePage = new TraineeProfile(webDriver);
    }

    @Test
    void canClickBackToDashboardButton() {
        Assertions.assertEquals(HomeTrainer.class, traineeProfilePage.goBackToHomePageViaBackToDashboardButton().getClass());
    }

    @Test
    void canClickAttendanceDetails() {
        Assertions.assertEquals(WeeklyAttendance.class, traineeProfilePage.goToTraineeWeeklyAttendance().getClass());
    }

    @Test
    void canClickReportBreakdown() {
        Assertions.assertEquals(ReportTrainer.class, traineeProfilePage.goToTraineeReport().getClass());
    }

    @Test
    void canToggleSQLBreakdown() {
        // The attribute is null until you toggle the button
        //Assertions.assertEquals("false", webDriver.findElement(By.cssSelector("tr[href*='collapseSQL']")).getAttribute("aria-expanded"));
        traineeProfilePage.toggleExpandSQLBreakdown();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assertions.assertEquals("true", webDriver.findElement(By.cssSelector("tr[href*='collapseSQL']")).getAttribute("aria-expanded"));
        traineeProfilePage.toggleExpandSQLBreakdown();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assertions.assertEquals("false", webDriver.findElement(By.cssSelector("tr[href*='collapseSQL']")).getAttribute("aria-expanded"));
    }

    @Test
    void canToggleNonSQLBreakdown() {
        // The attribute is null until you toggle the button
        //Assertions.assertEquals("false", webDriver.findElement(By.cssSelector("tr[href*='collapseNotSQL']")).getAttribute("aria-expanded"));
        traineeProfilePage.toggleExpandNotSQLBreakdown();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assertions.assertEquals("true", webDriver.findElement(By.cssSelector("tr[href*='collapseNotSQL']")).getAttribute("aria-expanded"));
        traineeProfilePage.toggleExpandNotSQLBreakdown();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assertions.assertEquals("false", webDriver.findElement(By.cssSelector("tr[href*='collapseNotSQL']")).getAttribute("aria-expanded"));
    }

    @Test
    void toggleSQLCanHandleNoGrades() {
        webDriver.get("http://localhost:8080/trainer/traineeProfile/10");
        traineeProfilePageEmpty = new TraineeProfile(webDriver);
        Exception exception = Assertions.assertThrows(NoSuchElementException.class, () -> {
            traineeProfilePageEmpty.toggleExpandSQLBreakdown();
        });
    }

    @Test
    void toggleNotSQLCanHandleNoGrades() {
        webDriver.get("http://localhost:8080/trainer/traineeProfile/10");
        traineeProfilePageEmpty = new TraineeProfile(webDriver);
        Exception exception = Assertions.assertThrows(NoSuchElementException.class, () -> {
            traineeProfilePageEmpty.toggleExpandNotSQLBreakdown();
        });
    }

    @Nested
    @DisplayName("Tests for selecting specific data")
    class SelectingData {

        @Test
        void canSelectTraineeName() {
            Assertions.assertEquals(String.class, traineeProfilePage.getFullName().getClass());
        }

        @Test
        void cansSelectAssignedClass() {
            Assertions.assertEquals(String.class, traineeProfilePage.getAssignedClass().getClass());
        }

        @Test
        void canSelectCourseAssigned() {
            Assertions.assertEquals(String.class, traineeProfilePage.getCourseAssigned().getClass());
        }

        @Test
        void canSelectCurrentWeekOfCourse() {
            Assertions.assertEquals(String.class, traineeProfilePage.getCurrentWeekOfCourse().getClass());
        }

        @Test
        void canSelectGetOnTime() {
            Assertions.assertEquals(String.class, traineeProfilePage.getOnTime().getClass());
        }

        @Test
        void canSelectLate() {
            Assertions.assertEquals(String.class, traineeProfilePage.getLate().getClass());
        }

        @Test
        void canSelectExcusedAbsence() {
            Assertions.assertEquals(String.class, traineeProfilePage.getExcusedAbsence().getClass());
        }

        @Test
        void canSelectUnexcusedAbsence() {
            Assertions.assertEquals(String.class, traineeProfilePage.getUnexcusedAbsence().getClass());
        }

        @Test
        void canSelectConsultantGrade() {
            Assertions.assertEquals(String.class, traineeProfilePage.getConsultantGrade().getClass());
        }

        @Test
        void canSelectTechnicalGrade() {
            Assertions.assertEquals(String.class, traineeProfilePage.getTechnicalGrade().getClass());
        }

        @Test
        void canSelectOverallGrade() {
            Assertions.assertEquals(String.class, traineeProfilePage.getOverallGrade().getClass());
        }

        @Test
        void canSelectGradeSQL() {
            Assertions.assertEquals(String.class, traineeProfilePage.getGradeSQL().getClass());
            Assertions.assertEquals("FAIL", traineeProfilePage.getGradeSQL());
        }

        @Test
        void canSelectGradeNotSQL() {
            Assertions.assertEquals(String.class, traineeProfilePage.getGradeNotSQL().getClass());
            Assertions.assertEquals("B-", traineeProfilePage.getGradeNotSQL());
        }
    }

    @Nested
    @DisplayName("Assessments Breakdown")
    class AssessmentsBreakdown {

        @Test
        @DisplayName("Get SQL Score")
        void getSqlScore() {
            traineeProfilePage.toggleExpandSQLBreakdown();
            Assertions.assertEquals("30.9%", traineeProfilePage.getSqlScore());
        }

        @Test
        @DisplayName("Get SQL Duration")
        void getSqlDuration() {
            traineeProfilePage.toggleExpandSQLBreakdown();
            WebDriverWait wait = new WebDriverWait(webDriver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#collapseSQL > div:nth-child(2) > div.col-4")));
            Assertions.assertEquals("77 mins", traineeProfilePage.getSqlDuration());
        }

        @Test
        @DisplayName("Get SQL Comparative Score")
        void getSqlComparativeScore() {
            traineeProfilePage.toggleExpandSQLBreakdown();
            WebDriverWait wait = new WebDriverWait(webDriver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#collapseSQL > div:nth-child(3) > div.col-4")));
            Assertions.assertEquals("27%", traineeProfilePage.getSqlComparativeScore());
        }

        @Test
        @DisplayName("Get SQL Design Score")
        void getSqlDesignScore() {
            traineeProfilePage.toggleExpandSQLBreakdown();
            WebDriverWait wait = new WebDriverWait(webDriver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#collapseSQL > div:nth-child(1) > div.col-4")));
            Assertions.assertEquals("16%", traineeProfilePage.getSqlDesignScore());
        }

        @Test
        @DisplayName("Get SQL Language and Knowledge Score")
        void getSqlLanguageAndKnowledgeScore() {
            traineeProfilePage.toggleExpandSQLBreakdown();
            WebDriverWait wait = new WebDriverWait(webDriver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#collapseSQL > div:nth-child(2) > div.col-4")));
            Assertions.assertEquals("29%", traineeProfilePage.getSqlLanguageAndKnowledgeScore());
        }

        @Test
        @DisplayName("Get SQL Problem Solving Score")
        void getSqlProblemSolvingScore() {
            traineeProfilePage.toggleExpandSQLBreakdown();
            WebDriverWait wait = new WebDriverWait(webDriver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#collapseSQL > div:nth-child(3) > div.col-4")));
            Assertions.assertEquals("40%", traineeProfilePage.getSqlProblemSolvingScore());
        }

        @Test
        @DisplayName("Get Not SQL Score")
        void getNotSqlScore() {
            traineeProfilePage.toggleExpandNotSQLBreakdown();
            Assertions.assertEquals("78.0%", traineeProfilePage.getNotSqlScore());
        }

        @Test
        @DisplayName("Get Not SQL Duration")
        void getNonSqlDuration() {
            traineeProfilePage.toggleExpandNotSQLBreakdown();
            WebDriverWait wait = new WebDriverWait(webDriver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#collapseNotSQL > div:nth-child(2) > div.col-4")));
            Assertions.assertEquals("77 mins", traineeProfilePage.getNotSqlDuration());
        }

        @Test
        @DisplayName("Get Not SQL Design Score")
        void getNotSqlDesignScore() {
            traineeProfilePage.toggleExpandNotSQLBreakdown();
            WebDriverWait wait = new WebDriverWait(webDriver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#collapseNotSQL > div:nth-child(1) > div.col-4")));
            Assertions.assertEquals("16%", traineeProfilePage.getNotSqlDesignScore());
        }

        @Test
        @DisplayName("Get Not SQL Language and Knowledge Score")
        void getNotSqlLanguageAndKnowledgeScore() {
            traineeProfilePage.toggleExpandNotSQLBreakdown();
            WebDriverWait wait = new WebDriverWait(webDriver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#collapseNotSQL > div:nth-child(2) > div.col-4")));
            Assertions.assertEquals("29%", traineeProfilePage.getNotSqlLanguageAndKnowledgeScore());
        }

        @Test
        @DisplayName("Get Not SQL Problem Solving Score")
        void getNotSqlProblemSolvingScore() {
            traineeProfilePage.toggleExpandNotSQLBreakdown();
            WebDriverWait wait = new WebDriverWait(webDriver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#collapseNotSQL > div:nth-child(3) > div.col-4")));
            Assertions.assertEquals("40%", traineeProfilePage.getNotSqlProblemSolvingScore());
        }

        @Test
        @DisplayName("Get Not SQL Comparative Score")
        void getNotSqlComparativeScore() {
            traineeProfilePage.toggleExpandNotSQLBreakdown();
            WebDriverWait wait = new WebDriverWait(webDriver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#collapseNotSQL > div:nth-child(3) > div.col-4")));
            Assertions.assertEquals("27%", traineeProfilePage.getNotSqlComparativeScore());
        }

    }






    @AfterEach
    void close() {
        webDriver.get("http://localhost:8080/trainer/traineeProfile/41");
        traineeProfilePage = new TraineeProfile(webDriver);
    }

    @AfterAll
    static void quit() { webDriver.quit(); }
}
