package com.sparta.greg.pom.pagesTest.trainee;

import com.sparta.greg.pom.pages.components.PropertyLoader;
import com.sparta.greg.pom.pages.trainee.AttendanceTrainee;
import com.sparta.greg.pom.pages.trainee.HomeTrainee;
import com.sparta.greg.pom.pages.components.Login;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TraineeAttendanceTest {

    private static WebDriver webDriver;
    private static Login loginPage;
    private static HomeTrainee homePage;
    private static AttendanceTrainee traineeAttendance;
    private static String usernameTrainee;
    private static String passwordTrainee;

    @BeforeEach
    void setup(){
        webDriver = new ChromeDriver();
        loginPage = new Login(webDriver);
        PropertyLoader.loadProperties();
        usernameTrainee = PropertyLoader.properties.getProperty("traineeUsername");
        passwordTrainee = PropertyLoader.properties.getProperty("traineePassword");
        homePage = loginPage.logInAsTrainee(usernameTrainee, passwordTrainee);
    }

    @Test
    @DisplayName("Click on a week homepage path")
    void clickOnAWeekHomePageToAttendance(){
        traineeAttendance = homePage.goToWeeklyAttendance();
        traineeAttendance.clickWeek(11);
    }

    @Test
    @DisplayName("Click on a week sidebar path")
    public void clickOnAWeekSideBar(){
        homePage.getSideBarTrainee().clickTraineeOptions();
        traineeAttendance = homePage.getSideBarTrainee().goToTraineeAttendance();
        traineeAttendance.clickWeek(11);
    }

    @Test
    @DisplayName("Toggle method test")
    public void doesToggleWork(){
        traineeAttendance = homePage.goToWeeklyAttendance();
        traineeAttendance.clickWeek(11);
        Assertions.assertTrue(traineeAttendance.isToggledOnWeek(11));
    }

    @Test
    @DisplayName("Count days in week")
    public void doesCountWork(){
        traineeAttendance = homePage.goToWeeklyAttendance();
        Assertions.assertEquals(5, traineeAttendance.getNumberOfDaysInWeek(6));
    }

    @AfterEach
    void closeDown(){
        webDriver.close();
        webDriver.quit();
    }
}
