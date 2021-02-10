package com.sparta.greg.pom.pagesTest;

import com.sparta.greg.pom.pages.EnterAttendance;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.concurrent.TimeUnit;

public class EnterAttendanceTest {

    WebDriver webDriver = new ChromeDriver();
    EnterAttendance attendancePage;

    @Test
    public void radioButtons()
    {
        //SetUp
        webDriver.get("http://localhost:8080");
        webDriver.findElement(By.name("username")).sendKeys();
        webDriver.findElement(By.name("password")).sendKeys();
        webDriver.findElement(By.cssSelector("button[type='submit']")).click();
        webDriver.get("http://localhost:8080/trainer/attendanceEntry");
        attendancePage = new EnterAttendance(webDriver);

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
        //setup
        webDriver.get("http://localhost:8080");
        webDriver.findElement(By.name("username")).sendKeys();
        webDriver.findElement(By.name("password")).sendKeys();
        webDriver.findElement(By.cssSelector("button[type='submit']")).click();
        webDriver.get("http://localhost:8080/trainer/attendanceEntry");
        attendancePage = new EnterAttendance(webDriver);

        //assertions
        attendancePage.selectTrainee("David");
        Assertions.assertTrue(webDriver.findElement(By.name("traineeId")).getText().contains("David"));
        attendancePage.selectTrainee("Bill");
        Assertions.assertTrue(webDriver.findElement(By.name("traineeId")).getText().contains("Bill"));
    }
}
