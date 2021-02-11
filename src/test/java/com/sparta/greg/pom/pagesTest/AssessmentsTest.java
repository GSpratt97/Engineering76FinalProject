package com.sparta.greg.pom.pagesTest;

import com.sparta.greg.pom.pages.AssessmentBreakdown;
import com.sparta.greg.pom.pages.Assessments;
import com.sparta.greg.pom.pages.Login;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class AssessmentsTest {

    private static WebDriver webDriver;
    private static Assessments assessmentsPage;
    private static String usernameTrainer;
    private static String passwordTrainer;

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

        webDriver.get("http://localhost:8080/trainer/assessments");

        assessmentsPage = new Assessments(webDriver);

    }


    @Test
    void canClickFirstTrainee() {
        Assertions.assertEquals(AssessmentBreakdown.class, assessmentsPage.clickTrainee(assessmentsPage.selectFirstTrainee()).getClass());
    }

    @Test
    void canClickTraineeByName() {
        Assertions.assertEquals(AssessmentBreakdown.class, assessmentsPage.clickTraineeByName("David Trieu").getClass());
    }

    @Test
    void clickEmptyTraineeByNameThrowsNullException() {
        Exception exception = Assertions.assertThrows(NoSuchElementException.class, () -> {
            assessmentsPage.clickTraineeByName(" ");
        });
    }

    @Test
    void clickNullTraineeThrowsNullException() {
        Exception exception = Assertions.assertThrows(NullPointerException.class, () -> {
            assessmentsPage.clickTrainee(null);
        });
    }


    @AfterEach
    void close() {
        webDriver.close();
    }


}
