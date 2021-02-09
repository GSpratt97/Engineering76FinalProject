package com.sparta.greg.pom.pagesTest;

import com.sparta.greg.pom.pages.EnterAttendance;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EnterAttendancePageTest {

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
        attendancePage.selectDate("22-09-2020");
        attendancePage.selectAttendanceType("On Time");
        Assertions.assertTrue(webDriver.findElement(By.id("attendanceId1")).isSelected());
        attendancePage.selectDate("22-09-2020");
        attendancePage.selectAttendanceType("Late");
        Assertions.assertTrue(webDriver.findElement(By.id("attendanceId2")).isSelected());
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
    }


}
