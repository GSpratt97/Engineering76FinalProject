package com.sparta.greg.pom.pagesTest;

import com.sparta.greg.pom.pages.HomeTrainer;
import com.sparta.greg.pom.pages.Login;
import com.sparta.greg.pom.pages.TraineeAttendance;
import com.sparta.greg.pom.pages.TraineeProfile;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
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

    @BeforeEach
    void setup() {
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

//    @Test
//    void canClickReportBreakdown() {
//        Assertions.assertEquals(ReportTrainer.class, traineeProfilePage.);
//    }

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
        Exception exception = Assertions.assertThrows(NullPointerException.class, () -> {
            traineeProfilePageEmpty.toggleExpandSQLBreakdown();
        });
    }

    @Test
    void toggleNotSQLCanHandleNoGrades() {
        webDriver.get("http://localhost:8080/trainer/traineeProfile/10");
        traineeProfilePageEmpty = new TraineeProfile(webDriver);
        Exception exception = Assertions.assertThrows(NullPointerException.class, () -> {
            traineeProfilePageEmpty.toggleExpandNotSQLBreakdown();
        });
    }

    @AfterEach
    void close() {
        webDriver.close();
    }
}
