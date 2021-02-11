package com.sparta.greg.pom.pagesTest.trainer;

import com.sparta.greg.pom.pages.trainer.HomeTrainer;
import com.sparta.greg.pom.pages.components.Login;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class HomeTrainerTest {

    private static WebDriver webDriver;
    private static Login login;
    private static HomeTrainer homeTrainer;

    private static Properties properties = new Properties();
    private static String trainerUsername;
    private static String trainerPassword;


    @BeforeEach
    void setup() {
        webDriver = new ChromeDriver();
        login = new Login(webDriver);
        try {
            properties.load(new FileReader("src/test/resources/login.properties"));
            trainerUsername = properties.getProperty("trainerUsername");
            trainerPassword = properties.getProperty("trainerPassword");
        } catch (IOException e) {
            e.printStackTrace();
        }
        login.enterUsernameAddress(trainerUsername);
        login.enterPassword(trainerPassword);
        login.clickSubmitButton();
        homeTrainer = new HomeTrainer(webDriver);
    }

    @Test
    @DisplayName("Go to Home Trainer Page")
    void goToHomeTrainerPage() {
        Assertions.assertEquals("http://localhost:8080/trainer/home", webDriver.getCurrentUrl());
    }

    @Test
    @DisplayName("Go to Enter Class Attendance")
    void goToEnterClassAttendance() {
        homeTrainer.goToEnterAttendanceThroughDashboard();
        Assertions.assertEquals("http://localhost:8080/trainer/attendanceEntry", webDriver.getCurrentUrl());
    }

    @Test
    @DisplayName("Go to view trainee profile")
    void goToViewTraineeProfile() {
        homeTrainer.goToTraineeProfile();
        //for DAVID TRIEU!!!!
        //the expected will change, depends on the trainee selected
        Assertions.assertEquals("http://localhost:8080/trainer/traineeProfile/10", webDriver.getCurrentUrl());
    }

    @Test
    @DisplayName("Get Trainer Full Name")
    void getTrainerFullName() {
        Assertions.assertEquals("Manish Gadhvi", homeTrainer.getFullName());
    }

    @Test
    @DisplayName("Get Trainer Assigned Class")
    void getTrainerAssignedClass() {
        Assertions.assertEquals("Engineering 72", homeTrainer.getAssignedClass());
    }

    @Test
    @DisplayName("Get Trainer Course Assigned")
    void getTrainerCourseAssigned() {
        Assertions.assertEquals("Java Development", homeTrainer.getCourseAssigned());
    }

    @Test
    @DisplayName("Get Current Week of Course")
    void getCurrentWeekOfCourse() {
        Assertions.assertEquals("12", homeTrainer.getCurrentWeekOfCourse());
    }

    @Test
    @DisplayName("Get Average On Time ")
    void getAverageOnTime() {
        //the expected result will probably need to change as time goes
        Assertions.assertEquals("90%", homeTrainer.getOnTime());
    }

    @Test
    @DisplayName("Get Average Late")
    void getAverageLate() {
        Assertions.assertEquals("7%", homeTrainer.getLate());
    }

    @Test
    @DisplayName("Get Excused Absence")
    void getExcusedAbsence() {
        Assertions.assertEquals("2%", homeTrainer.getExcusedAbsence());
    }

    @Test
    @DisplayName("Get Unexcused Absence")
    void getUnexcusedAbsence() {
        Assertions.assertEquals("1%", homeTrainer.getUnexcusedAbsence());
    }

    @Test
    @DisplayName("Find Specific Trainee in Dropdown")
    void findSpecificTraineeInDropdown() {
        homeTrainer.findTraineeFromDropdown("Reece Louch");
        homeTrainer.goToTraineeProfile();
        Assertions.assertEquals("http://localhost:8080/trainer/traineeProfile/187", webDriver.getCurrentUrl());
    }
}
