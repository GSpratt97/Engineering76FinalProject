package com.sparta.greg.pom.pagesTest.trainer;

import com.sparta.greg.pom.pages.components.Login;
import com.sparta.greg.pom.pages.components.PropertyLoader;
import com.sparta.greg.pom.pages.trainee.AttendanceTrainee;
import com.sparta.greg.pom.pages.trainee.AttendanceTrainer;
import com.sparta.greg.pom.pages.trainee.HomeTrainee;
import com.sparta.greg.pom.pages.trainer.HomeTrainer;
import com.sparta.greg.pom.pages.trainer.TraineeProfile;
import com.sparta.greg.pom.webDriverFactory.WebDriverFactory;
import com.sparta.greg.pom.webDriverFactory.WebDriverType;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AttendanceTrainerTest {

    private static WebDriver webDriver;
    private static Login loginPage;
    private static HomeTrainer homePage;
    private static TraineeProfile traineeProfile;
    private static AttendanceTrainer trainerAttendance;
    private static String usernameTrainer;
    private static String passwordTrainer;

    @BeforeEach
    void setup(){
        webDriver = WebDriverFactory.getWebDriver(WebDriverType.CHROME);
        webDriver.get("http://localhost:8080/login");
        loginPage = new Login(webDriver);
        PropertyLoader.loadProperties();
        usernameTrainer = PropertyLoader.properties.getProperty("trainerUsername");
        passwordTrainer = PropertyLoader.properties.getProperty("trainerPassword");
        homePage = loginPage.logInAsTrainer(usernameTrainer, passwordTrainer);
        //Need an explicit wait
        traineeProfile = homePage.goToTraineeProfile();
        trainerAttendance = traineeProfile.goToTraineeAttendance();

//        webDriver = new ChromeDriver();
//        loginPage = new Login(webDriver);
//        PropertyLoader.loadProperties();
//        usernameTrainer = PropertyLoader.properties.getProperty("trainerUsername");
//        passwordTrainer = PropertyLoader.properties.getProperty("trainerPassword");
//        homePage = loginPage.logInAsTrainer(usernameTrainer, passwordTrainer);
//        //Need an explicit wait
//        traineeProfile = homePage.goToTraineeProfile();
//        trainerAttendance = traineeProfile.goToTraineeAttendance();
    }

    @Test
    @DisplayName("Go back to profile button")
    public void backToProfile(){
        traineeProfile = trainerAttendance.goToTraineeProfile();
        Assertions.assertTrue(webDriver.getCurrentUrl().contains("http://localhost:8080/trainer/traineeProfile"));
    }

    @Test
    @DisplayName("Click on a week homepage path")
    public void clickOnAWeekHomePageToAttendance(){
        trainerAttendance.clickWeek(11);
    }

    @Test
    @DisplayName("Toggle method test")
    public void doesToggleWork(){
        trainerAttendance.clickWeek(11);
        Assertions.assertTrue(trainerAttendance.isToggledOnWeek(11));
    }

    @Test
    @DisplayName("Count days in week")
    public void doesCountWork(){
        Assertions.assertEquals(5, trainerAttendance.getNumberOfDaysInWeek(6));
    }

    @AfterEach
    void closeDown(){
        webDriver.close();
        webDriver.quit();
    }
}
