package com.sparta.greg.pom.pagesTest;

import com.sparta.greg.pom.pages.EnterAttendance;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class EnterAttendanceTest {

    WebDriver webDriver = new ChromeDriver();
    EnterAttendance attendancePage;
    Properties properties = new Properties();

    @Before
    public void setUp()
    {
        try {
            properties.load(new FileReader("src/test/resources/login.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        webDriver.get("http://localhost:8080");
        webDriver.findElement(By.name("username")).sendKeys(properties.getProperty("trainerUsername"));
        webDriver.findElement(By.name("password")).sendKeys(properties.getProperty("trainerPassword"));
        webDriver.findElement(By.cssSelector("button[type='submit']")).click();
        webDriver.get("http://localhost:8080/trainer/attendanceEntry");
        attendancePage = new EnterAttendance(webDriver);
    }


    @Test
    public void radioButtons()
    {
        //assertions
        //R1
        attendancePage.selectAttendanceType("On Time");
        Assertions.assertTrue(webDriver.findElement(By.id("attendanceId1")).isSelected());

        //R2
        attendancePage.selectAttendanceType("Late");
        Assertions.assertTrue(webDriver.findElement(By.id("attendanceId2")).isSelected());

        //R3
        attendancePage.selectAttendanceType("Absent (Excused)");
        Assertions.assertTrue(webDriver.findElement(By.id("attendanceId3")).isSelected());

        //R4
        attendancePage.selectAttendanceType("Absent (Unexcused)");
        Assertions.assertTrue(webDriver.findElement(By.id("attendanceId4")).isSelected());

    }

    @Test
    public void changeTrainee()
    {
        //assertions
        attendancePage.selectTrainee("David");
        Assertions.assertTrue(webDriver.findElement(By.name("traineeId")).getText().contains("David"));
        attendancePage.selectTrainee("Bill");
        Assertions.assertTrue(webDriver.findElement(By.name("traineeId")).getText().contains("Bill"));
    }

    @After
    public void tearDown()
    {
        webDriver.quit();
    }
}
