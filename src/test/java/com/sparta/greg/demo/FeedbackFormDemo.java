package com.sparta.greg.demo;

import com.sparta.greg.pom.pages.Login;
import com.sparta.greg.pom.pages.trainee.FeedbackForm;
import com.sparta.greg.pom.webDriverFactory.WebDriverFactory;
import com.sparta.greg.pom.webDriverFactory.WebDriverType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class FeedbackFormDemo {

    private static WebDriver chromeDriver;
    private static WebDriver firefoxDriver;
    private static WebDriver safariDriver;
    private static WebDriver explorerDriver;
    private static WebDriver edgeDriver;
    private static WebDriver headlessDriver;

    private static FeedbackForm feedbackForm;
    private static Login login;
    private static Login headlessLogin;
    private static FeedbackForm headlessFeedbackForm;

    private static Properties properties;


    @BeforeAll
    static void setup(){
        chromeDriver = WebDriverFactory.getWebDriver(WebDriverType.CHROME);

        //firefoxDriver = WebDriverFactory.getWebDriver(WebDriverType.FIREFOX);

        //safariDriver = WebDriverFactory.getWebDriver(WebDriverType.SAFARI);

        //explorerDriver = WebDriverFactory.getWebDriver(WebDriverType.INTERNET_EXPLORER);

        //edgeDriver = WebDriverFactory.getWebDriver(WebDriverType.MICROSOFT_EDGE);

        //headlessDriver = WebDriverFactory.runHeadless(WebDriverType.CHROME);

        

        
        properties = new Properties();
        try {
            properties.load(new FileReader("src/test/resources/login.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        login = new Login(chromeDriver);

        feedbackForm = new FeedbackForm(chromeDriver);

        login.logInAsTrainee(properties.getProperty("traineeUsername"), properties.getProperty("traineePassword"));

        feedbackForm.getSideBarTrainee().clickTraineeOptions();

        feedbackForm.getSideBarTrainee().goToFeedbackForm();
    }


    @Test
    @DisplayName("Running a test in headless mode")
    void headlessTest(){
        headlessLogin = new Login(headlessDriver);
        headlessFeedbackForm = new FeedbackForm(headlessDriver);

        headlessLogin.logInAsTrainee(properties.getProperty("traineeUsername"), properties.getProperty("traineePassword"));
        headlessFeedbackForm.getSideBarTrainee().clickTraineeOptions();
        headlessFeedbackForm.getSideBarTrainee().goToFeedbackForm();

        Assertions.assertTrue(headlessFeedbackForm.enterStop("Editing stop", 12));

    }



    @Test
    @DisplayName("Testing start, stop, continue")
    void editStartStopContinue(){
        Assertions.assertTrue(feedbackForm.enterStop("Editing stop", 12));
        Assertions.assertTrue(feedbackForm.enterStart("Editing start", 12));
        Assertions.assertTrue(feedbackForm.enterContinue("Editing continue", 25));
    }

    @Test
    @DisplayName("Testing can select grade with framework")
    void canSelectGrade(){
        Assertions.assertTrue(feedbackForm.isTechnicalGradeSelected("B"));

    }

    @Test
    @DisplayName("Testing can select consultant grade with framework")
    void canSelectConsultantGrade(){
        Assertions.assertTrue(feedbackForm.isConsultantGradeSelected("C"));
    }



    @Test
    @DisplayName("Testing start without framework")
    void editStartWithoutFramework(){
        WebDriver webdriver = new ChromeDriver();
        webdriver.get("http://localhost:8080/login");
        webdriver.findElement(By.cssSelector("input[name='username'][type='email']")).sendKeys(properties.getProperty("traineeUsername"));
        webdriver.findElement(By.cssSelector("input[name='password'][type='password']")).sendKeys(properties.getProperty("traineePassword"));
        webdriver.findElement(By.cssSelector("button[type='submit']")).click();


        webdriver.findElement(By.cssSelector("a[data-target*='#collapseUtilities']")).click();
        webdriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webdriver.findElement(By.cssSelector("a[href='/traineeRecentReport']")).click();

         webdriver.findElement(By.name("startTrainee")).sendKeys(
                 Keys.BACK_SPACE,
                 Keys.BACK_SPACE,
                 Keys.BACK_SPACE,
                 Keys.BACK_SPACE,
                 Keys.BACK_SPACE,
                 Keys.BACK_SPACE,
                 "Editing stop");
    }









}
