package com.sparta.greg.pom.pagesTest;

import com.sparta.greg.pom.pages.HomeTrainee;
import com.sparta.greg.pom.pages.HomeTrainer;
import com.sparta.greg.pom.pages.Login;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class HomeTraineeTest {

    private static WebDriver webDriver;
    private static Login login;
    private static HomeTrainee homeTrainee;

    private static Properties properties = new Properties();
    private static String traineeUsername;
    private static String traineePassword;


    @BeforeEach
    void setup() {
        webDriver = new ChromeDriver();
        login = new Login(webDriver);
        try {
            properties.load(new FileReader("src/test/resources/login.properties"));
            traineeUsername = properties.getProperty("traineeUsername");
            traineePassword = properties.getProperty("traineePassword");
        } catch (IOException e) {
            e.printStackTrace();
        }
        login.enterUsernameAddress(traineeUsername);
        login.enterPassword(traineePassword);
        login.clickSubmitButton();
        homeTrainee = new HomeTrainee(webDriver);
    }

    @Test
    @DisplayName("Go to Home Trainee Page")
    void goToHomeTraineePage() {
        Assertions.assertEquals("http://localhost:8080/trainee/home", webDriver.getCurrentUrl());
    }

    @Test
    @DisplayName("Get Trainee Full Name")
    void getTraineeFullName() {
        Assertions.assertEquals("Bill Bird", homeTrainee.getFullName());
    }

    @Test
    @DisplayName("Get Trainee Assigned Class")
    void getTraineeAssignedClass() {
        Assertions.assertEquals("Engineering 72", homeTrainee.getAssignedClass());
    }

    @Test
    @DisplayName("testTraineePage")
    void testTraineePage() {
        homeTrainee.selectView();
        homeTrainee.selectConsultancySkills();
    }

    @Test
    @DisplayName("Get Trainee Course Assigned")
    void getTraineeCourseAssigned() {
        Assertions.assertEquals("Java Development", homeTrainee.getCourseAssigned());
    }

    @Test
    @DisplayName("Get Trainee Current Week of Course")
    void getTraineeCurrentWeekOfCourse() {
        Assertions.assertEquals("12", homeTrainee.getCurrentWeekOfCourse());
    }

    @Test
    @DisplayName("Get Trainee On Time ")
    void getAverageOnTime() {
        //the expected result will probably need to change as time goes
        Assertions.assertEquals("NO ENTRY", homeTrainee.getOnTime());
    }

    @Test
    @DisplayName("Get Trainee Late")
    void getTraineeLate() {
        Assertions.assertEquals("NO ENTRY", homeTrainee.getLate());
    }

    @Test
    @DisplayName("Get Trainee Excused Absense")
    void getTraineeExcusedAbsense() {
        Assertions.assertEquals("NO ENTRY", homeTrainee.getExcusedAbsence());
    }

    @Test
    @DisplayName("Get Trainee Unexcused Absense")
    void getTraineeUnexcusedAbsense() {
        Assertions.assertEquals("NO ENTRY", homeTrainee.getUnexcusedAbsence());
    }

    @Test
    @DisplayName("Get Trainee Consultant Grade")
    void getTraineeConsultantGrade() {
        Assertions.assertEquals("C", homeTrainee.getConsultantGrade());
    }

    @Test
    @DisplayName("Get Trainee Technical Grade")
    void getTraineeTechnicalGrade() {
        Assertions.assertEquals("C", homeTrainee.getTechnicalGrade());
    }

    @Test
    @DisplayName("Get Trainee Overall Grade")
    void getTraineeOverallGrade() {
        Assertions.assertEquals("C", homeTrainee.getOverallGrade());
    }

}
