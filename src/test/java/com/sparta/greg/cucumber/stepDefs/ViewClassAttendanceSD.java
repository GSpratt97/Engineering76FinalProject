package com.sparta.greg.cucumber.stepdefs;

import com.sparta.greg.pom.pages.components.Login;
import com.sparta.greg.pom.pages.trainee.FeedbackForm;
import com.sparta.greg.pom.pages.trainer.WeeklyAttendance;
import com.sparta.greg.pom.webDriverFactory.WebDriverFactory;
import com.sparta.greg.pom.webDriverFactory.WebDriverType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ViewClassAttendanceSD {

    private WebDriver webDriver;
    private WeeklyAttendance weeklyAttendance;
    String username;
    String password;

    public void loginAndGoToWeeklyAttendance() {
        Properties properties = new Properties();
        webDriver = WebDriverFactory.getWebDriver(WebDriverType.CHROME);
        webDriver.get("http://localhost:8080/login");

        try {
            properties.load(new FileReader("src/test/resources/login.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        username = properties.getProperty("trainerUsername");
        password = properties.getProperty("trainerPassword");

        Login login = new Login(webDriver);
        login.logInAsTrainee(properties.getProperty("traineeUsername"), properties.getProperty("traineePassword"));

        webDriver.get("http://localhost:8080/trainer/weekly-attendance");
        weeklyAttendance = new WeeklyAttendance(webDriver);
    }
}
