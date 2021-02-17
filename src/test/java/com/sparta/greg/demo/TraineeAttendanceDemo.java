package com.sparta.greg.demo;

import com.sparta.greg.pom.pages.Login;
import com.sparta.greg.pom.pages.trainee.HomeTrainee;
import com.sparta.greg.pom.pages.templates.Attendance;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TraineeAttendanceDemo {

    protected WebDriver webDriver;
    private Login loginPage;
    private HomeTrainee homePage;
    private Attendance traineeAttendance;
    private Properties properties = new Properties();
    private String usernameTrainee;
    private String passwordTrainee;

    @Before
    public void setup(){
        webDriver = new ChromeDriver();
        loginPage = new Login(webDriver);

        try {
            properties.load(new FileReader("src/test/resources/login.properties"));
            usernameTrainee = properties.getProperty("traineeUsername");
            passwordTrainee = properties.getProperty("traineePassword");
        } catch (IOException e) {
            e.printStackTrace();
        }
        homePage = loginPage.logInAsTrainee(usernameTrainee, passwordTrainee);
    }

    @Test
    @DisplayName("Click on a week homepage path - POM")
    public void clickOnAWeekHomePageToAttendancePom(){
        traineeAttendance = homePage.goToWeeklyAttendance();
        traineeAttendance.clickWeek(12);
        webDriver.close();
    }

    @Test
    @DisplayName("Click on a week sidebar path - POM")
    public void clickOnAWeekSideBarPom(){
        homePage.getSideBarTrainee().clickTraineeOptions();
        traineeAttendance = homePage.getSideBarTrainee().goToTraineeAttendance();
        traineeAttendance.clickWeek(11);
        webDriver.close();
    }

    @Test
    @DisplayName("Toggle method test - POM")
    public void doesToggleWorkPom(){
        traineeAttendance = homePage.goToWeeklyAttendance();
        traineeAttendance.clickWeek(12);
        Assertions.assertTrue(traineeAttendance.isToggledOnWeek(12));
        webDriver.close();
    }

    @Test
    @DisplayName("Click on a week homepage path - Regular")
    public void clickOnAWeekHomePageToAttendance(){
        webDriver.get("http://localhost:8080");
        webDriver.findElement(By.cssSelector("input[name='username'][type='email']")).sendKeys(usernameTrainee);
        webDriver.findElement(By.cssSelector("input[name='password'][type='password']")).sendKeys(passwordTrainee);
        webDriver.findElement(By.cssSelector("button[type='submit']")).click();
        webDriver.findElement(By.linkText("Attendance Details")).click();
        webDriver.findElements(By.tagName("tbody")).get(0).click();
        webDriver.close();
    }

    @Test
    @DisplayName("Click on a week sidebar path - Regular")
    public void clickOnAWeekSideBar(){
        webDriver.get("http://localhost:8080");
        webDriver.findElement(By.cssSelector("input[name='username'][type='email']")).sendKeys(usernameTrainee);
        webDriver.findElement(By.cssSelector("input[name='password'][type='password']")).sendKeys(passwordTrainee);
        webDriver.findElement(By.cssSelector("button[type='submit']")).click();
        webDriver.findElement(By.cssSelector("a[data-target*='#collapseUtilities']")).click();
        webDriver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        webDriver.findElement(By.cssSelector("a[href='/trainee/trainee-attendance']")).click();
        webDriver.findElements(By.tagName("tbody")).get(0).click();
        webDriver.close();
    }

    @Test
    @DisplayName("Toggle method test - Regular")
    public void doesToggleWork(){
        webDriver.get("http://localhost:8080");
        webDriver.findElement(By.cssSelector("input[name='username'][type='email']")).sendKeys(usernameTrainee);
        webDriver.findElement(By.cssSelector("input[name='password'][type='password']")).sendKeys(passwordTrainee);
        webDriver.findElement(By.cssSelector("button[type='submit']")).click();
        webDriver.findElement(By.linkText("Attendance Details")).click();
        webDriver.findElements(By.tagName("tbody")).get(0).click();
        Assertions.assertEquals("true", webDriver.findElements(By.tagName("tbody")).get(0).findElements(By.tagName("tr")).get(0).getAttribute("aria-expanded"));
        webDriver.close();
    }
}
