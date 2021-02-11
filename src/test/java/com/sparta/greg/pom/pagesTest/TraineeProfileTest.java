package com.sparta.greg.pom.pagesTest;


import com.sparta.greg.pom.pages.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
        Properties properties = new Properties();

        try {
            properties.load(new FileReader("src/test/resources/login.properties"));
            usernameTrainer = properties.getProperty("trainerUsername");
            passwordTrainer = properties.getProperty("trainerPassword");
        } catch (IOException e) {
            e.printStackTrace();
        }

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
        Assertions.assertEquals(TraineeAttendance.class, traineeProfilePage.goToTraineeAttendance().getClass());
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






    @AfterEach
    void close() {
        webDriver.get("http://localhost:8080/trainer/traineeProfile/41");
        traineeProfilePage = new TraineeProfile(webDriver);
    }

    @AfterAll
    static void quit() { webDriver.quit(); }
}
