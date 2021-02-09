package com.sparta.greg.pom.pagesTest;

import com.sparta.greg.pom.pages.Assessments;
import com.sparta.greg.pom.pages.Login;
import com.sparta.greg.pom.pages.TraineeAttendancePage;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class TraineeAttendancePageTest {

    protected WebDriver webDriver;
    private Login loginPage;
    private HomeTrainee homePage;
    private TraineeAttendancePage traineeAttendancePage;
    private Properties properties;
    private String usernameTrainee;
    private String passwordTrainee;

    @BeforeEach
    void setup(){
        webDriver = new ChromeDriver();
        loginPage = new Login(webDriver);

        try {
            properties.load(new FileReader("src/test/resources/login.properties"));
            usernameTrainee = properties.getProperty("traineeUsername");
            passwordTrainee = properties.getProperty("traineePassword");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("Get an element")
    public void works(){
        traineeAttendancePage = new TraineeAttendancePage(webDriver);
        traineeAttendancePage.clickWeek(1);
    }
}
