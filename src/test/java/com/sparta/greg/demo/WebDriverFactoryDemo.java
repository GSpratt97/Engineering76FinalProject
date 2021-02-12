package com.sparta.greg.demo;


import com.sparta.greg.pom.pages.components.Login;
import com.sparta.greg.pom.pages.trainee.FeedbackForm;
import com.sparta.greg.pom.webDriverFactory.WebDriverFactory;
import com.sparta.greg.pom.webDriverFactory.WebDriverType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class WebDriverFactoryDemo {

    private static WebDriver chromeDriver;
    private static WebDriver firefoxDriver;
    private static WebDriver safariDriver;
    private static WebDriver explorerDriver;
    private static WebDriver edgeDriver;
    private static WebDriver headlessDriver;

    private static Properties properties;


    @BeforeAll
    static void setup(){




        //safariDriver = WebDriverFactory.getWebDriver(WebDriverType.SAFARI);



        properties = new Properties();
        try {
            properties.load(new FileReader("src/test/resources/login.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    @DisplayName("Running a test in chromeDriver")
    void chromeDriverTest(){
        chromeDriver = WebDriverFactory.getWebDriver(WebDriverType.CHROME);
        Login login = new Login(chromeDriver);
        FeedbackForm feedbackForm = new FeedbackForm(chromeDriver);

        login.logInAsTrainee(properties.getProperty("traineeUsername"), properties.getProperty("traineePassword"));
        feedbackForm.getSideBarTrainee().clickTraineeOptions();
        feedbackForm.getSideBarTrainee().goToFeedbackForm();

        Assertions.assertTrue(feedbackForm.enterStop("Editing stop", 12));
    }


    @Test
    @DisplayName("Running a test in firefoxDriver")
    void firefoxDriverTest(){
        firefoxDriver = WebDriverFactory.getWebDriver(WebDriverType.FIREFOX);
        Login login = new Login(firefoxDriver);
        FeedbackForm feedbackForm = new FeedbackForm(firefoxDriver);

        login.logInAsTrainee(properties.getProperty("traineeUsername"), properties.getProperty("traineePassword"));
        feedbackForm.getSideBarTrainee().clickTraineeOptions();
        feedbackForm.getSideBarTrainee().goToFeedbackForm();

        Assertions.assertTrue(feedbackForm.enterStart("Editing start", 12));
    }


    @Test
    @DisplayName("Running a test in edgeDriver")
    void edgeDriverTest(){
        edgeDriver = WebDriverFactory.getWebDriver(WebDriverType.MICROSOFT_EDGE);
        Login login = new Login(edgeDriver);
        FeedbackForm feedbackForm = new FeedbackForm(edgeDriver);

        login.logInAsTrainee(properties.getProperty("traineeUsername"), properties.getProperty("traineePassword"));
        feedbackForm.getSideBarTrainee().clickTraineeOptions();
        feedbackForm.getSideBarTrainee().goToFeedbackForm();

        Assertions.assertTrue(feedbackForm.enterContinue("Editing continue", 25));
    }


    @Test
    @DisplayName("Running a test in IE")
    void IEDriverTest(){
        explorerDriver = WebDriverFactory.getWebDriver(WebDriverType.INTERNET_EXPLORER);
        Login login = new Login(explorerDriver);
        FeedbackForm feedbackForm = new FeedbackForm(explorerDriver);

        login.logInAsTrainee(properties.getProperty("traineeUsername"), properties.getProperty("traineePassword"));
        feedbackForm.getSideBarTrainee().clickTraineeOptions();
        feedbackForm.getSideBarTrainee().goToFeedbackForm();

        Assertions.assertTrue(feedbackForm.enterContinue("Editing continue", 25));
    }


    @Test
    @DisplayName("Running a test in headless mode")
    void headlessTest(){
        headlessDriver = WebDriverFactory.runHeadless(WebDriverType.CHROME);
        Login login = new Login(headlessDriver);
        FeedbackForm feedbackForm = new FeedbackForm(headlessDriver);

        login.logInAsTrainee(properties.getProperty("traineeUsername"), properties.getProperty("traineePassword"));
        feedbackForm.getSideBarTrainee().clickTraineeOptions();
        feedbackForm.getSideBarTrainee().goToFeedbackForm();

        Assertions.assertTrue(feedbackForm.enterContinue("Editing continue", 25));

    }



    @Test
    @DisplayName("Running a test in a smaller window")
    void smallerWindowTest(){
        chromeDriver = WebDriverFactory.getWebDriverWithWindowSize(WebDriverType.CHROME, 411, 823);

        Login login = new Login(chromeDriver);
        FeedbackForm feedbackForm = new FeedbackForm(chromeDriver);

        login.logInAsTrainee(properties.getProperty("traineeUsername"), properties.getProperty("traineePassword"));
        feedbackForm.getSideBarTrainee().clickTraineeOptions();
        feedbackForm.getSideBarTrainee().goToFeedbackForm();

        Assertions.assertTrue(feedbackForm.enterStop("Editing stop", 12));
    }

    @Test
    @DisplayName("Running a smaller window in edge")
    void smallerEdgeTest(){
        edgeDriver = WebDriverFactory.getWebDriverWithWindowSize(WebDriverType.e, 411, 823);

        Login login = new Login(chromeDriver);
        FeedbackForm feedbackForm = new FeedbackForm(chromeDriver);

        login.logInAsTrainee(properties.getProperty("traineeUsername"), properties.getProperty("traineePassword"));
        feedbackForm.getSideBarTrainee().clickTraineeOptions();
        feedbackForm.getSideBarTrainee().goToFeedbackForm();

        Assertions.assertTrue(feedbackForm.enterStop("Editing stop", 12));
    }





}
