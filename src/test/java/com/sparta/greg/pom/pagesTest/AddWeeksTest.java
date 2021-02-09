package com.sparta.greg.pom.pagesTest;

import com.sparta.greg.pom.pages.AddWeeks;
import com.sparta.greg.pom.pages.Login;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class AddWeeksTest {

    private static final Properties properties = new Properties();
    private static Login login;
    private static WebDriver webDriver;
    private static String trainerUsername;
    private static String trainerPassword;
    private AddWeeks addWeeks;

    @BeforeEach
    void setup() {
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
        goToAddWeeks();
        addWeeks = new AddWeeks(webDriver);

    }

    @Test
    public void test1(){
        Assertions.assertTrue(true);
    }

    @Test
    public void test2(){
        addWeeks.selectGroupToAdd("Data 17");
    }

    private void goToAddWeeks(){
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        webDriver.findElement(By.linkText("Trainer Options")).click();
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        webDriver.findElement(By.linkText("Add Weeks")).click();

    }
}
