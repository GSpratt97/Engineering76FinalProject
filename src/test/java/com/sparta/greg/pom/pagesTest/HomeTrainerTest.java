package com.sparta.greg.pom.pagesTest;

import com.sparta.greg.pom.pages.HomeTrainer;
import com.sparta.greg.pom.pages.Login;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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


    @BeforeAll
    static void setup() {
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
        homeTrainer.goToTraineeManagement();
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
    @DisplayName("Get Average On Time ")
    void getAverageOnTime() {
        //the expected result will probably need to change as time goes
        Assertions.assertEquals("89.84%", homeTrainer.getOnTime());
    }
}
