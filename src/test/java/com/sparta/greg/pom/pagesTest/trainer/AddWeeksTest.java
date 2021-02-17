package com.sparta.greg.pom.pagesTest.trainer;

import com.sparta.greg.pom.pages.components.PropertyLoader;
import com.sparta.greg.pom.pages.trainer.AddWeeks;
import com.sparta.greg.pom.pages.components.Login;
import com.sparta.greg.pom.webDriverFactory.WebDriverFactory;
import com.sparta.greg.pom.webDriverFactory.WebDriverType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class AddWeeksTest {

    private static final Properties properties = new Properties();
    private static Login login;
    private static WebDriver webDriver;
    private static String trainerUsername;
    private static String trainerPassword;
    private static AddWeeks addWeeks;

    @BeforeEach
    void setup() {
        webDriver = WebDriverFactory.getWebDriver(WebDriverType.CHROME);
        webDriver.get("http://localhost:8080/login");
        Login login = new Login(webDriver);
        PropertyLoader.loadProperties();
        trainerUsername = PropertyLoader.properties.getProperty("trainerUsername");
        trainerPassword = PropertyLoader.properties.getProperty("trainerPassword");
        login.logInAsTrainer(trainerUsername, trainerPassword);
        goToAddWeeks();
        addWeeks = new AddWeeks(webDriver);

//        webDriver = new ChromeDriver();
//        login = new Login(webDriver);
//        addWeeks = new AddWeeks(webDriver);
//
//        try {
//            properties.load(new FileReader("src/test/resources/login.properties"));
//            trainerUsername = properties.getProperty("trainerUsername");
//            trainerPassword = properties.getProperty("trainerPassword");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        logInToTrainer();
//        goToAddWeeks();
//        addWeeks = new AddWeeks(webDriver);
    }

    @Test
    public void test1(){
        Assertions.assertTrue(true);
    }

    @Test
    public void test2(){
        addWeeks.selectGroupToAdd("Engineering 76");
        addWeeks.pressAddWeekButton();
    }

    private void goToAddWeeks(){
        webDriver.get("http://localhost:8080/trainer/newWeek");

    }
    private void logInToTrainer(){
        login.enterUsernameAddress(trainerUsername);
        login.enterPassword(trainerPassword);
        login.clickSubmitButton();
    }
}
