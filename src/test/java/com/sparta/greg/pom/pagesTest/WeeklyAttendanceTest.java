package com.sparta.greg.pom.pagesTest;

import com.sparta.greg.pom.pages.Login;
import com.sparta.greg.pom.pages.WeeklyAttendance;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.fail;

public class WeeklyAttendanceTest {

    private static final Properties properties = new Properties();
    private static Login login;
    private static WebDriver webDriver;
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
    }

    @Test
    @DisplayName("clickWeekRow returns true for populated list")
    void clickWeekRowReturnsTrueForPopulatedList() {
        login.logInAsTrainer(trainerUsername, trainerPassword);
        WeeklyAttendance weeklyAttendance = new WeeklyAttendance(webDriver);
        webDriver.get("http://localhost:8080/trainer/weekly-attendance");
        Assertions.assertTrue(weeklyAttendance.clickWeekRow(1));
    }
}
