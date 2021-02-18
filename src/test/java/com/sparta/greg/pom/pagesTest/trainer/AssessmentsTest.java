package com.sparta.greg.pom.pagesTest.trainer;

import com.sparta.greg.pom.pages.utilities.PropertyLoader;
import com.sparta.greg.pom.pages.trainer.AssessmentBreakdown;
import com.sparta.greg.pom.pages.trainer.Assessments;
import com.sparta.greg.pom.pages.Login;
import com.sparta.greg.pom.webDriverFactory.WebDriverFactory;
import com.sparta.greg.pom.webDriverFactory.WebDriverType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class AssessmentsTest {

    private static WebDriver webDriver;
    private static Assessments assessmentsPage;
    private static String usernameTrainer;
    private static String passwordTrainer;

    @BeforeEach
    void setup() {
        webDriver = WebDriverFactory.getWebDriver(WebDriverType.CHROME);
        webDriver.get("http://localhost:8080/login");
        Login login = new Login(webDriver);
        PropertyLoader.loadProperties();
        usernameTrainer = PropertyLoader.properties.getProperty("trainerUsername");
        passwordTrainer = PropertyLoader.properties.getProperty("trainerPassword");
        login.logInAsTrainer(usernameTrainer, passwordTrainer);
        webDriver.get("http://localhost:8080/trainer/assessments");
        assessmentsPage = new Assessments(webDriver);

//        webDriver = new ChromeDriver();
//        webDriver.get("http://localhost:8080/login");
//
//        PropertyLoader.loadProperties();
//        usernameTrainer = PropertyLoader.properties.getProperty("trainerUsername");
//        passwordTrainer = PropertyLoader.properties.getProperty("trainerPassword");
//
//        Login login = new Login(webDriver);
//        login.logInAsTrainer(usernameTrainer, passwordTrainer);
//
//        webDriver.get("http://localhost:8080/trainer/assessments");
//
//        assessmentsPage = new Assessments(webDriver);

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
